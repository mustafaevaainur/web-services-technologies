DROP TABLE "pictures" CASCADE;

CREATE TABLE "pictures" (
  id bigserial NOT NULL,
  name character varying(200),
  author character varying(200),
  year integer,
  material character varying(200),
  height numeric,
  width numeric,
  CONSTRAINT "pictures_pk" PRIMARY KEY (id)
);

INSERT INTO pictures(name, author, year, material, height, width) values ('Мона Лиза', 'Леонардо да Винчи', 1503, 'Маслянные краски', 77, 53);
INSERT INTO pictures(name, author, year, material, height, width) values ('Звездная ночь', 'Винсент Ван Гог', 1889, 'Маслянные краски', 73.7, 92.1);
INSERT INTO pictures(name, author, year, material, height, width) values ('Тайная вечеря', 'Леонардо да Винчи', 1495, 'Темпера', 460, 880);