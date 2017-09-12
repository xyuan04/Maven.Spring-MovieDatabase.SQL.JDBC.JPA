package io.zipcoder.persistenceapp.domain;


import javax.persistence.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
@Entity
@Table(name = "Cars") // Required if class & table names are different
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int Id;

    private String make;
    private String model;
    private String year;

    @OneToMany
    private List<SalesPackage> salesPackages = new LinkedList<>();

    public Car() {
    }

    public Car(String make, String model, String year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public String getMake() {

        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void addPackage(SalesPackage sp){
        salesPackages.add(sp);
    }

    public List<SalesPackage> getSalesPackages(){
        return Collections.unmodifiableList(salesPackages);
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
