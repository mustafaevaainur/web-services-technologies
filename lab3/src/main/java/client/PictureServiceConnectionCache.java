package client;


class MyServiceConnectionCache extends ConnectionCache<PictureService> {

    private static  MyServiceConnectionCache myServiceConnectionCache = new MyServiceConnectionCache();

    public static MyServiceConnectionCache getInstance(){
        return myServiceConnectionCache;
    }

    private MyServiceConnectionCache() {
    }

    @Override
    protected PictureService create() {
        return new PictureService();
    }
}