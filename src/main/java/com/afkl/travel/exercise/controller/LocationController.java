package com.afkl.travel.exercise.controller;

import com.afkl.travel.exercise.entity.Location;
import com.afkl.travel.exercise.repository.LocationRepository;
import com.afkl.travel.exercise.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/travel/locations")
public class LocationController {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationController(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @GetMapping("")
    public List<Location> getLocations() {
        return locationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Location getLocationById(@PathVariable("id") Integer id) throws NotFoundException {
        return locationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Location not found with id: " + id));
    }

    // Other methods...

    @PostMapping("")
    public Location createLocation(@RequestBody Location location) {
        return locationRepository.save(location);
    }

    @PutMapping("/{id}")
    public Location updateLocation(
            @PathVariable("id") Integer id,
            @RequestBody Location locationDetails
    ) throws NotFoundException {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Location not found with id: " + id));

        // Update the location details
        location.setCode(locationDetails.getCode());
        location.setName(locationDetails.getName());
        location.setType(locationDetails.getType());
        location.setLatitude(locationDetails.getLatitude());
        location.setLongitude(locationDetails.getLongitude());
        location.setDescription(locationDetails.getDescription());
        location.setParent(locationDetails.getParent());

        return locationRepository.save(location);
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable("id") Integer id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Location not found with id: " + id));

        locationRepository.delete(location);
    }
}
