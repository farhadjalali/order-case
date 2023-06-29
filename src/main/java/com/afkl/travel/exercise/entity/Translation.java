package com.afkl.travel.exercise.entity;

import javax.persistence.*;

@Entity
public class Translation {
    @Id
    private Integer id;

    public Translation() {
    }

    public Translation(Integer id, Integer locationId, String language, String name, String description) {
        this.id = id;
        this.locationId = locationId;
        this.language = language;
        this.name = name;
        this.description = description;
    }

    private Integer locationId;
    private String language;
    private String name;
    private String description;
    // Todo: What should  be the type here
    @ManyToOne
    private Location locationEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer location) {
        this.locationId = location;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Location getLocationEntity() {
        return locationEntity;
    }

    public void setLocationEntity(Location locationEntity) {
        this.locationEntity = locationEntity;
    }
}
