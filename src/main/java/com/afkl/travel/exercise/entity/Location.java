package com.afkl.travel.exercise.entity;

// Todo: when this syntax?
import javax.persistence.*;

@Entity
public class Location {
    @Id
    private int id;

    public Location(){
    }

    public Location(int id, String code, LocationType type, double longitude, double latitude, Integer parent) {
        this.id = id;
        this.code = code;
        this.type = type;
        this.longitude = longitude;
        this.latitude = latitude;
        this.parent = parent;
    }

    private String code;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String name;
    private LocationType type;
    private double latitude;
    private double longitude;
    private String description;
    private Integer parent;

    // Getter and setter for 'code'
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    // Getter and setter for 'name'
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter and setter for 'type'
    public LocationType getType() {
        return type;
    }

    public void setType(LocationType type) {
        this.type = type;
    }

    // Getter and setter for 'latitude'
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    // Getter and setter for 'longitude'
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    // Getter and setter for 'description'
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getter and setter for 'parentCode'
    public Integer getParent() {
        return parent;
    }

    public void setParent(Integer parent) {
        this.parent = parent;
    }
}
