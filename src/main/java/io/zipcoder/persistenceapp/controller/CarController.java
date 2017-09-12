package io.zipcoder.persistenceapp.controller;

import io.zipcoder.persistenceapp.domain.Car;
import io.zipcoder.persistenceapp.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */
@RestController
public class CarController {


    @Autowired
    private CarService carService;


    @RequestMapping(value = "/cars/byManufacturer/{make}", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Car>> lookUpMake(@PathVariable String make){

        List<Car> result = carService.getCarByMake(make);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/cars", method = RequestMethod.POST)
    public ResponseEntity<?> createCar(@RequestBody Car car){
        carService.addCar(car);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/cars/sales", method = RequestMethod.GET)
    public ResponseEntity<?> listSales(){
        return new ResponseEntity<Object>(carService.getSalesPackages(), HttpStatus.OK);
    }

    @RequestMapping(value = "/cars/sales/{year}", method = RequestMethod.GET)
    public ResponseEntity<?> listSalesForYear(@PathVariable String year){
        return new ResponseEntity<Object>(carService.getSalesPackagesForYear(year), HttpStatus.OK);
    }

    @RequestMapping(value = "/cars/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteCar(@PathVariable int id){
        carService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
