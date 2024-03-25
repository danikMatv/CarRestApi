package com.foxmided.carrestapi.Service;

import com.foxmided.carrestapi.Model.Car;
import com.foxmided.carrestapi.Repository.CarRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.html.parser.Entity;
import java.sql.SQLException;
import java.util.List;

@Service
public class CarService {
    private static final Logger logger = LoggerFactory.getLogger(Car.class);
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getAll() {
        logger.info("Car getAll metod");
        return carRepository.getAll();
    }

    public Car findCarByCarId(@Param("Id") String carId) {
        logger.info("Car findCarById metod");
        return carRepository.findCarByCarId(carId);
    }

    @Transactional
    public void save(Car entity) throws SQLException {
        logger.info("Car save metod");
        carRepository.save(entity);
    }

    @Transactional
    public void delete(Integer entityId) {
        logger.info("Car delete metod");
        carRepository.deleteById(entityId);
    }

    @Transactional
    public void updateCarByCarId(@Param("carMark") String carMark, @Param("carModel") String carModel,
                                 @Param("carYear") Integer carYear, @Param("id") Integer id) throws SQLException {
        logger.info("Car updateCarByCarId metod");
        carRepository.updateCarByCarId(carMark, carModel, carYear, id);
    }

    public List<Car> searchCarByParameters(String manufacturer, String model,
                                           Integer minYear, Integer maxYear, String category) {
        return carRepository.searchCarByParameters(manufacturer, model, minYear, maxYear, category);
    }
}
