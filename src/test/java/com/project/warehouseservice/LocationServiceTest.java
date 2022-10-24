package com.project.warehouseservice;

import com.project.warehouseservice.contracts.LocationCreateRequest;
import com.project.warehouseservice.contracts.LocationUpdateRequest;
import com.project.warehouseservice.model.Location;
import com.project.warehouseservice.repository.LocationRepository;
import com.project.warehouseservice.service.LocationService;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;


import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@RunWith(SpringRunner.class)
@SpringBootTest
@Ignore
class LocationServiceTest {
/*
    @Autowired
    private LocationService locationService;

    @MockBean
    private LocationRepository locationRepository;

    private String address="Reşitpaşa, Eski Büyükdere Cd. No:8, 34467 Sarıyer/İstanbul";


    @Test
    public void addLocationTest(){
        LocationCreateRequest request = new LocationCreateRequest();
        request.setAddress(address);
        request.setCity("city");
        request.setCountry("country");
        when(locationRepository.saveAndFlush(any(Location.class))).thenReturn(generateLocationObject());
        assertEquals(1L,locationService.addLocation(request).longValue());

    }

    private Location generateLocationObject(){
        Location location=new Location();
        location.setAddress(address);
        location.setCountry("country");
        location.setCity("city");
        location.setId(1L);
        return location;
    }
    @Test
    public void updateLocationTest(){
        LocationUpdateRequest request= new LocationUpdateRequest();
        request.setLocationId(1L);
        request.setAddress("SAMPLE");
        when(locationRepository.findById(request.getLocationId())).thenReturn(Optional.of(generateLocationObject()));
        when(locationRepository.save(any(Location.class))).thenReturn(generateLocationObject());
        assertEquals(HttpStatus.OK,locationService.updateLocation(request).getStatusCode());

    }

    @Test
    public void getLocationTest()  {
        when(locationRepository.findAll()).thenReturn(Stream.of(new Location(address)).collect(Collectors.toList()));
        assertEquals(1,locationService.retrieveAllLocation().size());
    }



    @Test
    public void deleteLocationTest()  {
        Long locationId=1L;
        when(locationRepository.findById(locationId)).thenReturn(Optional.of(generateLocationObject()));
        assertEquals(HttpStatus.OK,locationService.deleteLocation(locationId).getStatusCode());

    }


*/



}
