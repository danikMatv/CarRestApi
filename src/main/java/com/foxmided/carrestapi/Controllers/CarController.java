package com.foxmided.carrestapi.Controllers;

import com.foxmided.carrestapi.Model.Car;
import com.foxmided.carrestapi.Model.CarCategoryDto;
import com.foxmided.carrestapi.Model.Category;
import com.foxmided.carrestapi.Service.CarService;
import com.foxmided.carrestapi.Service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/car")
public class CarController {

    private final CarService carService;
    private final CategoryService categoryService;

    public CarController(CarService carService, CategoryService categoryService) {
        this.carService = carService;
        this.categoryService = categoryService;
    }

    @Operation(summary = "get all car")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "get cars"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "500", description = "Server Error")})
    @GetMapping("")
    public List<Car> getAllCar() {
        return carService.getAll();
    }
    @Operation(summary = "add new car")
    @PostMapping("/add")
    public ResponseEntity<CarCategoryDto> addNewCar(@RequestBody CarCategoryDto carCategoryDto) throws SQLException {

        Car car = carCategoryDto.getCar();
        Category category = carCategoryDto.getCategory();
        car.getCategories().add(category);
        category.getCars().add(car);
        carService.save(car);
        categoryService.save(category);
        return ResponseEntity.ok(carCategoryDto);
    }

    //@PreAuthorize("hasRole('User')")
    @Operation(summary = "find car by id")
    @GetMapping("/find/{id}")
    public Car findCarById(@PathVariable String id) {
        return carService.findCarByCarId(id);
    }
    @Operation(summary = "delete car")
    @PostMapping("/delete/{id}")
    public void deleteCar(@PathVariable Integer id) throws SQLException {
        carService.delete(id);
    }
    @Operation(summary = "change smth in car by car id")
    @PutMapping(path = "/update/{id}")
    public void updateCar(@PathVariable String id, @RequestBody Car car) throws SQLException {
        Car cars = carService.findCarByCarId(id);
        if (!cars.toString().isEmpty()) {
            carService.updateCarByCarId(car.getCarMark(), car.getCarModel(), car.getCarYear(), car.getId());
        }
    }
    @Operation(summary = "serch car by smth param")
    @GetMapping(path = "/searchBy")
    public ResponseEntity<List<Car>> searchCarByParameters(@RequestParam(required = false) String manufacturer,
                                                           @RequestParam(required = false) String model,
                                                           @RequestParam(required = false) Integer minYear,
                                                           @RequestParam(required = false) Integer maxYear,
                                                           @RequestParam(required = false) String category) {
        List<Car> cars = carService.searchCarByParameters(manufacturer, model, minYear, maxYear, category);
        return ResponseEntity.ok(cars);
    }
}
