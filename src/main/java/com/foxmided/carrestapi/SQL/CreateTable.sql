CREATE TABLE car(
    id SERIAL NOT NULL,
    carId varchar(256) NOT NULL ,
    carMark varchar(255) NOT NULL,
    carYear INTEGER NOT NULL,
    carModel varchar(255) NOT NULL
);
CREATE TABLE category(
    categoryId SERIAL PRIMARY KEY,
    categoryName varchar(255) NOT NULL
);