package com.foxmided.carrestapi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @NotBlank
    @Size(min = 10, max = 20)
    @Column(name = "carid")
    private String carId;
    @NotBlank
    @Size(min = 1, max = 10)
    @Column(name = "carmark")
    private String carMark;
    @NotBlank
    @Size(min = 1, max = 10)
    @Column(name = "caryear")
    private Integer carYear;
    @NotBlank
    @Size(min = 1, max = 10)
    @Column(name = "carmodel")
    private String carModel;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "car_category",joinColumns = @JoinColumn(name = "car_id"),inverseJoinColumns = @JoinColumn(name = "idcategory"))
    private List<Category> categories = new ArrayList<>();

    public Car(){}
    public Car(String carId,String carMark,Integer carYear,String carModel){
        this.carId = carId;
        this.carMark = carMark;
        this.carYear = carYear;
        this.carModel = carModel;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Integer getCarYear() {
        return carYear;
    }

    public void setCarYear(Integer carYear) {
        this.carYear = carYear;
    }

    public String getCarMark() {
        return carMark;
    }

    public void setCarMark(String carMark) {
        this.carMark = carMark;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
