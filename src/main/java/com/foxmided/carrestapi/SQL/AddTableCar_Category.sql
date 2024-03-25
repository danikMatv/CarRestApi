CREATE TABLE car_category(
    car_categoryCarId INTEGER,
    car_categoryCategoryId INTEGER,
    FOREIGN KEY(car_categoryCarId) REFERENCES car(id),
    FOREIGN KEY(car_categoryCategoryId) REFERENCES category(categoryid)
);