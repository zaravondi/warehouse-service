package com.project.warehouseservice.controller;
import com.project.warehouseservice.contracts.LocationCreateRequest;
import com.project.warehouseservice.contracts.LocationUpdateRequest;
import com.project.warehouseservice.model.dto.LocationDTO;
import com.project.warehouseservice.service.LocationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(path = "/api/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping(value = "/add")
    @Operation(summary = "add location from database")
    public ResponseEntity<Long> addLocation(@RequestBody @Valid LocationCreateRequest request ){
        return new ResponseEntity<>(locationService.addLocation(request), HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    @Operation(summary = "update location from database")
    public ResponseEntity<String> updateLocation(@RequestBody @Valid LocationUpdateRequest request ){
        return locationService.updateLocation(request);
    }

    @DeleteMapping(value = "/delete")
    @Operation(summary = "delete location with given id from database")
    public ResponseEntity<String> deleteLocation(@RequestParam("locationId") @NotNull Long locationId ){
        return  locationService.deleteLocation(locationId);
    }

    @GetMapping(value = "/retrieve")
    @Operation(summary = "retrieve all locations from database")
    public ResponseEntity<List<LocationDTO>> retrieveAllLocation(){
        return new ResponseEntity<>(locationService.retrieveAllLocation(), HttpStatus.OK);
    }
}
