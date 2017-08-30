package io.zipcoder.persistenceapp.service.jdbc.extractors;

import io.zipcoder.persistenceapp.domain.Car;
import io.zipcoder.persistenceapp.domain.SalesPackage;
import io.zipcoder.persistenceapp.service.jdbc.mappers.CarRowMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class CarSalesExtractor implements ResultSetExtractor<Iterable<Car>> {

    @Override
    public Iterable<Car> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Map<Integer, Car> carsFound = new HashMap<>();
        CarRowMapper crm = new CarRowMapper();

        while(resultSet.next()){
            Integer id = resultSet.getInt("car_id");
            Car car = carsFound.get(id);

            // If this is the first time we've seen it, create and add this car.
            if(null == car){
//                car = new Car(resultSet.getString("make"),
//                        resultSet.getString("model"),
//                        resultSet.getString("year"));
                car = crm.mapRow(resultSet, resultSet.getRow());
                carsFound.put(id, car);
            }


            SalesPackage salesPackage = new SalesPackage();
            salesPackage.setPkgName(resultSet.getString("package"));
            salesPackage.setPrice(resultSet.getBigDecimal("price"));
            car.addPackage(salesPackage);

        }

        return carsFound.values();
    }

}