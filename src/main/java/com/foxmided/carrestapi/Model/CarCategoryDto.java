package com.foxmided.carrestapi.Model;

public class CarCategoryDto {

    private Car car;
    private Category category;

    public CarCategoryDto() {
    }

    public CarCategoryDto(Car car, Category category) {
        this.car = car;
        this.category = category;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
