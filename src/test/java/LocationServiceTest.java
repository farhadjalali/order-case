import com.afkl.travel.exercise.entity.Location;
import com.afkl.travel.exercise.exception.NotFoundException;
import com.afkl.travel.exercise.repository.LocationRepository;
import com.afkl.travel.exercise.service.LocationService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = LocationServiceTest.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LocationServiceTest {

    @Mock
    private LocationRepository locationRepository;

    private LocationService locationService;

    @BeforeAll
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        locationService = new LocationService(locationRepository);
    }

    @Test
    public void testUsAirports() {
        // Prepare
        List<Location> locations = new ArrayList<>();
        locations.add(new Location(1, "Location 1", "city", 1.23, 4.56, null));
        locations.add(new Location(2, "Location 2", "airport", 7.89, 10.11, 1));

        when(locationRepository.findRecursiveByTypeAndParentCode("airport", "US")).thenReturn(new ArrayList<>());

        // Execute
         List<Location> result = locationService.getLocations("us-airports");

        // Verify
        assertEquals(0, result.size());
    }

    @Test
    void testGetLocationById_LocationNotFound() {
        // Prepare
        when(locationRepository.findById(1)).thenReturn(Optional.empty());

        // Execute and Verify
        assertThrows(NotFoundException.class, () -> locationService.getLocationById(1));
    }
}
