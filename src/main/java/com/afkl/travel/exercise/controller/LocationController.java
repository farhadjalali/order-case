package com.afkl.travel.exercise.controller;

import com.afkl.travel.exercise.entity.Location;
import com.afkl.travel.exercise.exception.NotFoundException;
import com.afkl.travel.exercise.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/travel/locations")
@CrossOrigin(origins = "http://localhost:3000")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping("")
    public List<Location> getLocations() {
        return locationService.getLocations();
    }

    @GetMapping("/{id}")
    public Location getLocationById(@PathVariable("id") Integer id) throws NotFoundException {
        return getLocationById(id);
    }

    // Other methods...

    @PostMapping("")
    public Location createLocation(@RequestBody Location location) {
        return locationService.createLocation(location);
    }

    @PutMapping("/{id}")
    public Location updateLocation(
            @PathVariable("id") Integer id,
            @RequestBody Location locationDetails
    ) throws NotFoundException {
        return locationService.updateLocation(id, locationDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable("id") Integer id) {
        locationService.deleteLocation(id);
    }
}
