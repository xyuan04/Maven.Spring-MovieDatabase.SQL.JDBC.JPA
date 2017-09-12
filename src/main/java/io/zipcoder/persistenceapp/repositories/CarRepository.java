package io.zipcoder.persistenceapp.repositories;

import io.zipcoder.persistenceapp.repositories.helpers.CarUpdater;
import org.springframework.data.jpa.repository.JpaRepository;
import io.zipcoder.persistenceapp.domain.Car;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 *
 */
public interface CarRepository extends JpaRepository<Car, Integer>, CarUpdater {

    //@Query("SELECT car From Car car WHERE make = ?1")
    List<Car> findByMake(String make);


    @Query("SELECT car FROM Car car WHERE car.year = ?1")
    Iterable<Car> findCarsByYear(String year);



//not quite working yet
//    @Query("SELECT car, package FROM CAR car, SalesPackage package WHERE car.id in (SELECT DISTINCT package.car_id FROM SalesPackage package)")
//    Iterable<Car> findCarsWithSales();



}
