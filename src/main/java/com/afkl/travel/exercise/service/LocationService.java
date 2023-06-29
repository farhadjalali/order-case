package com.afkl.travel.exercise.service;

import com.afkl.travel.exercise.entity.Location;
import com.afkl.travel.exercise.exception.NotFoundException;
import com.afkl.travel.exercise.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class LocationService {
    private final LocationRepository locationRepository;

    @Autowired
    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getLocations() {
        return locationRepository.findAll();
    }

    public Location getLocationById(@PathVariable("id") Integer id) throws NotFoundException {
        return locationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Location not found with id: " + id));
    }

    public Location createLocation(@RequestBody Location location) {
        return locationRepository.save(location);
    }

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

    public void deleteLocation(@PathVariable("id") Integer id) {
        Location location = locationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Location not found with id: " + id));

        locationRepository.delete(location);
    }
}
