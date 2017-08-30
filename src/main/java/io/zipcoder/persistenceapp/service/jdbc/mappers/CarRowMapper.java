package io.zipcoder.persistenceapp.service.jdbc.mappers;

import io.zipcoder.persistenceapp.domain.Car;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 */
public class CarRowMapper implements RowMapper<Car> {


    @Override
    public Car mapRow(ResultSet resultSet, int i) throws SQLException {
        return
                new Car(
                    resultSet.getString("Make"),
                    resultSet.getString("Model"),
                    resultSet.getString("Year")
                );
    }

}
