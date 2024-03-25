package com.foxmided.carrestapi.Repository;

import com.foxmided.carrestapi.Model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query("SELECT c FROM Car c")
    List<Car> getAll();

    @Query("SELECT c FROM Car c WHERE c.carId = :id")
    Car findCarByCarId(@Param("id") String id);

    @Modifying
    @Query("UPDATE Car c SET c.carMark = :carMark, c.carModel = :carModel, c.carYear = :carYear WHERE c.id = :id")
    void updateCarByCarId(@Param("carMark") String carMark, @Param("carModel") String carModel,
                          @Param("carYear") Integer carYear, @Param("id") Integer id) throws SQLException;

    @Query("select c FROM Car c where c.carMark = :carMark")
    List<Car> getAllByCarMark(@Param("carMark") String carMark) throws SQLException;

    @Query("SELECT c from Car c where c.carModel = :carModel")
    List<Car> getAllByCarModel(@Param("carModel") String carModel) throws SQLException;

    @Query("SELECT c FROM Car c JOIN c.categories ct WHERE (c.carMark IS NULL OR c.carMark = :carMark)" +
            "AND (c.carModel IS NULL OR c.carModel = :carModel) AND (c.carYear IS NULL OR (c.carYear > :minYear AND c.carYear < :maxYear)) " +
            "AND (ct.categoryName IS NULL OR ct.categoryName = :category)")
    List<Car> searchCarByParameters(@Param("carMark") String carMark,
                                    @Param("carModel") String carModel,
                                    @Param("minYear") Integer minYear,
                                    @Param("maxYear") Integer maxYear,
                                    @Param("category") String category);

}
