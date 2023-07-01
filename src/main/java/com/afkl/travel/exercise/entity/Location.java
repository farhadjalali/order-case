package com.afkl.travel.exercise.entity;

import io.micrometer.core.lang.Nullable;

import javax.persistence.*;

@Entity
public class Location {
    public Location(){
    }

    public Location(int id, String code, String type, Double longitude, Double latitude, Integer parent_id) {
        this.id = id;
        this.code = code;
        this.type = type;
        this.longitude = longitude;
        this.latitude = latitude;
        this.parent_id = parent_id;
    }

    @Id
    private int id;

    private String code;
    private String type;
    @Nullable
    private Double latitude;
    @Nullable
    private Double longitude;
    private Integer parent_id;

    // Getter and setter for 'id'
    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Getter and setter for 'code'
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    // Getter and setter for 'type'
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Getter and setter for 'latitude'
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    // Getter and setter for 'longitude'
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    // Getter and setter for 'parent id'
    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }
}
