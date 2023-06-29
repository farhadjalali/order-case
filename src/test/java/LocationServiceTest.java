import com.afkl.travel.exercise.entity.Location;
import com.afkl.travel.exercise.entity.LocationType;
import com.afkl.travel.exercise.exception.NotFoundException;
import com.afkl.travel.exercise.repository.LocationRepository;
import com.afkl.travel.exercise.service.LocationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LocationServiceTest {

    @Mock
    private LocationRepository locationRepository;

    @InjectMocks
    private LocationService locationService;

    @Test
    void testGetLocations() {
        // Prepare
        List<Location> locations = new ArrayList<>();
        locations.add(new Location(1, "Location 1", LocationType.CITY, 1.23, 4.56, null));
        locations.add(new Location(2, "Location 2", LocationType.AIRPORT, 7.89, 10.11, 1));

        when(locationRepository.findAll()).thenReturn(locations);

        // Execute
        List<Location> result = locationService.getLocations();

        // Verify
        assertEquals(2, result.size());
        assertEquals("Location 1", result.get(0).getName());
        assertEquals("Location 2", result.get(1).getName());
    }

    @Test
    void testGetLocationById_LocationFound() throws NotFoundException {
        // Prepare
        Location location = new Location(1, "Location 1", LocationType.CITY, 1.23, 4.56, null);
        when(locationRepository.findById(1)).thenReturn(Optional.of(location));

        // Execute
        Location result = locationService.getLocationById(1);

        // Verify
        assertNotNull(result);
        assertEquals("Location 1", result.getName());
    }

    @Test
    void testGetLocationById_LocationNotFound() {
        // Prepare
        when(locationRepository.findById(1)).thenReturn(Optional.empty());

        // Execute and Verify
        assertThrows(NotFoundException.class, () -> locationService.getLocationById(1));
    }

    // Similarly, you can write tests for createLocation, updateLocation, and deleteLocation methods.
    // Make sure to cover different scenarios and edge cases.

    // ...
}
