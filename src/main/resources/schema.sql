DROP TABLE IF EXISTS books;

CREATE table if not exists authors(
id serial primary key,
authorName varchar(255) NOT NULL,
category varchar(1) NOT NULL
);

CREATE TABLE if not exists books(
id serial PRIMARY KEY,
author int references authors(id),
title VARCHAR(250) NOT NULL,
priceOld  VARCHAR(250) DEFAULT NULL,
price VARCHAR(250) DEFAULT NULL
);

