package io.zipcoder.persistenceapp.service.jpa;

import io.zipcoder.persistenceapp.domain.Car;
import io.zipcoder.persistenceapp.repositories.CarRepository;
import io.zipcoder.persistenceapp.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */
@Service
public class JpaCarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;


    @Override
    public List<Car> getCarByMake(String make) {
        return carRepository.findByMake(make);
    }

    @Override
    public void deleteCar(int id) {
        carRepository.delete(id);
    }

    @Override
    public void deleteCars(List<Car> cars) {
        carRepository.delete(cars);
    }

    @Override
    public Iterable<Car> getSalesPackages() {
        return carRepository.findAll().stream().filter(car -> car.getAutoPrices().size() > 0).collect(Collectors.toList());
    }

    @Override
    public Iterable<Car> getSalesPackagesForYear(String year) {
        return carRepository.findCarsByYear(year);
    }

    @Override
    public void addCar(Car car) {
        carRepository.save(car);
    }
}
