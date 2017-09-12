package io.zipcoder.persistenceapp.service;

import io.zipcoder.persistenceapp.domain.Car;

import java.util.List;

/**
 *
 */
public interface CarService {
    List<Car> getCarByMake(String make);

    void deleteCar(int id);

    void deleteCars(List<Car> cars);

    Iterable<Car> getSalesPackages();

    Iterable<Car> getSalesPackagesForYear(String year);

    void addCar(Car car);

}
