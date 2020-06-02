package client;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.xml.ws.Service;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.apache.logging.log4j.Logger;

/**
 * This keeps the cache of MAX_CONNECTIONS_POOL_SIZE number of
 * connections and tries to shares them equally amongst the threads. All the
 * connections are created right at the start and if an error occurs then the
 * cache is created again.
 *
 *
 * Are JAX-WS client proxies thread safe
 * According to the JAX-WS spec,
 * the client proxies are NOT thread safe. To write portable code, you should
 * treat them as non-thread safe and synchronize access or use a pool of
 * instances or similar.
 */

public abstract class ConnectionCache<T extends Service> {

    private static final Logger logger = org.apache.logging.log4j.LogManager.getLogger(ConnectionCache.class);

    private static final int MAX_CONNECTIONS_POOL_SIZE = 16;

    private final BlockingQueue<T> freeConnections = new ArrayBlockingQueue<T>(MAX_CONNECTIONS_POOL_SIZE);

    private final BlockingQueue<T> usedConnections = new ArrayBlockingQueue<T>(MAX_CONNECTIONS_POOL_SIZE);

    private int totalConnections = 0;

    private boolean firstTimeLoad = true;

    private boolean shutdownCalled = false;

    private ScheduledExecutorService scheduler;


    public void init() {
        logger.info("starting connectionCache");
        logger.info("start caching connections"); ;;
        BasicThreadFactory factory = new BasicThreadFactory.Builder()
                .namingPattern("connectioncache-scheduler-thread-%d").build();
        scheduler = Executors.newScheduledThreadPool(1, factory);

        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try {
                    initializeCache();
                    firstTimeLoad = false;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }

            }

        }, 0, 10, TimeUnit.MINUTES);

    }


    public void destroy() {
        shutdownCalled = true;
        try {
            scheduler.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    /**
     * It is important to call release after calling this method to release the connection
     * @return
     * @throws Exception
     * @throws InterruptedException
     */
    public T acquire() throws Exception, InterruptedException {
        T take;
        if(totalConnections < MAX_CONNECTIONS_POOL_SIZE){
            synchronized (ConnectionCache.class) {
                if(totalConnections < MAX_CONNECTIONS_POOL_SIZE){
                    logger.info("service connects, free connections: " + freeConnections.size() + ", used connections: " + usedConnections.size());
                    T service = tryConnect();
                    freeConnections.offer(service, 1, TimeUnit.MINUTES);
                    totalConnections++;
                    logger.info("connect done, free connections: " + freeConnections.size() + ", used connections: " + usedConnections.size());
                }
            }
        }
        // a thread waits a maximum 13 minutes for a connection
        take = freeConnections.poll(13, TimeUnit.MINUTES);
        if (take == null) {
            throw new Exception("connection not avaliable for 13 minutes so aborting connection wait!");
        }
        usedConnections.offer(take);

//  }
        return take;
    }


    public void release(T service){
        try {
            boolean remove = usedConnections.remove(service);
            if(remove){
                // this will make sure that if a cleanup has been done
                // the removed objects are not added to the connections cache
                freeConnections.offer(service,1, TimeUnit.MINUTES);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void initializeCache() throws InterruptedException {
        try {
            loadCache();
            logger.info(firstTimeLoad ? "connections creation finished successfully!" : "connections checked successfully!");
        } catch (Exception e) {
            logger.error("error while initializing the cache");
        }
    }

    private void loadCache() throws Exception {
        logger.info(firstTimeLoad ? "create and cache service connections" : "checking  connections!" );
        for (int i = 0; i < MAX_CONNECTIONS_POOL_SIZE; i++) {
            if(shutdownCalled){
                return;
            }
            release(acquire());
        }
    }

    public void refreshCache()  {
        usedConnections.clear();
        freeConnections.clear();
        totalConnections =0;
    }

    private T tryConnect() throws Exception  {
        boolean connect = true;
        int tryNum = 0;
        T service = null;
        while (connect && !Thread.currentThread().isInterrupted() && !shutdownCalled) {
            try {
                service = create();
                connect = false;
            } catch (Exception e) {
                tryNum = tryReconnect(tryNum, e);
            }
        }
        return service;
    }

    private int tryReconnect(int tryNum, Exception e) throws Exception {
        logger.warn(Thread.currentThread().getName() + " service service not available! : " + e);
        // try 10 times, if
        if (tryNum++ < 10) {
            try {
                logger.warn(Thread.currentThread().getName() + " wait 1 second");
                Thread.sleep(1000);
            } catch (InterruptedException f) {
                // restore interrupt
                Thread.currentThread().interrupt();
            }
        } else {
            logger.warn(" service could not connect, number of times tried: " + (tryNum - 1));
            refreshCache();
            throw new Exception(e);
        }
        logger.info(" try reconnect number: " + tryNum);
        return tryNum;
    }


    protected abstract T create() ;
}