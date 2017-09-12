package io.zipcoder.persistenceapp.domain;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 *
 */
@Entity
@Table(name = "auto_prices")
public class SalesPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String pkgName;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPkgName() {
        return pkgName;
    }

    public void setPkgName(String pkgName) {
        this.pkgName = pkgName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
