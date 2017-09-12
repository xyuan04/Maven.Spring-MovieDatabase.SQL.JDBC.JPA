package io.zipcoder.persistenceapp.service.jdbc;

import io.zipcoder.persistenceapp.domain.Car;
import io.zipcoder.persistenceapp.domain.SalesPackage;
import io.zipcoder.persistenceapp.service.CarService;
import io.zipcoder.persistenceapp.service.jdbc.extractors.CarSalesExtractor;
import io.zipcoder.persistenceapp.service.jdbc.mappers.CarRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 */
@Service
public class JdbcCarServiceImpl implements CarService {


    @Autowired
    JdbcTemplate jdbcTemplate;


    private static final String DELETE_CAR_BY_ID = "DELETE FROM cars WHERE id = ?";
    private static final String DELETE_CAR_BY_FIELDS = "DELETE FROM cars WHERE make = ? AND model = ? AND year = ?;";
    private static final String SELECT_CARS_BY_MAKE = "SELECT * FROM cars WHERE make = ?;";
    private static final String SELECT_ALL_SALES_PACKAGES =
            "SELECT car_id, make, model, year, package, price "
            + "from auto_prices as p, cars as c "
            + "WHERE c.id = p.car_id;";

    private static final String SELECT_SALES_PACKAGES_FOR_YEAR =
            "SELECT car_id, make, model, year, package, price "
            + "from auto_prices as p, cars as c "
            + "WHERE c.id = p.car_id "
            + "AND c.year = ?;";


    @Override
    public List<Car> getCarByMake(String make){

        return jdbcTemplate.query(SELECT_CARS_BY_MAKE, new CarRowMapper(), make);
    }

    @Override
    public void deleteCar(int id) {
        jdbcTemplate.update(DELETE_CAR_BY_ID, id);
    }


    @Override
    public void deleteCars(List<Car> cars){
        List<Object[]> carFields = new LinkedList<>();
        for(Car car : cars){
            Object[] fields = new Object[3];
            fields[0] = car.getMake();
            fields[1] = car.getModel();
            fields[2] = car.getYear();
            carFields.add(fields);
        }
        jdbcTemplate.batchUpdate(DELETE_CAR_BY_FIELDS, carFields);
    }

    @Override
    public Iterable<Car> getSalesPackages(){

        //Get the row set for cars and the packages available
        return jdbcTemplate.query(SELECT_ALL_SALES_PACKAGES, new CarSalesExtractor());



    }

    @Override
    public Iterable<Car> getSalesPackagesForYear(String year){

        //Get the row set for cars and the packages available
        return jdbcTemplate.query(SELECT_SALES_PACKAGES_FOR_YEAR, new CarSalesExtractor(), year);



    }

    @Override
    public void addCar(Car car) {
        jdbcTemplate.update("INSERT INTO CARS (make, model, year) VALUES (?, ?, ?)",
                car.getMake(),
                car.getModel(),
                car.getYear());
    }


}
