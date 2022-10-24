package com.project.warehouseservice.service;

import com.project.warehouseservice.contracts.LocationCreateRequest;
import com.project.warehouseservice.contracts.LocationUpdateRequest;
import com.project.warehouseservice.model.Location;
import com.project.warehouseservice.model.dto.LocationDTO;
import com.project.warehouseservice.model.mapper.LocationMapper;
import com.project.warehouseservice.repository.LocationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LocationService {

    private static final Logger logger= LoggerFactory.getLogger(LocationService.class);
    @Autowired
    private LocationRepository locationRepository;
    public Long addLocation(LocationCreateRequest request) {
        Location location=new Location();
        location.setAddress(request.getAddress());
        location.setCity(request.getCity());
        location.setCountry(request.getCountry());
        return locationRepository.saveAndFlush(location).getId();
    }

    public ResponseEntity<String>  updateLocation(LocationUpdateRequest request) {

        try{
            Optional<Location> locationOptional =locationRepository.findById(request.getLocationId());
            if(locationOptional.isPresent()){
                Location location= locationOptional.get();
                location.setAddress(request.getAddress());
                locationRepository.save(location);
            }
            else{
                logger.error("Given id location not found");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);

            }
        }
        catch (Exception e){
            logger.error(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    public  ResponseEntity<String> deleteLocation(Long locationId) {

        try{
            Optional<Location> locationOptional =locationRepository.findById(locationId);
            if(locationOptional.isPresent()){
                locationRepository.deleteById(locationId);
            }
            else{
                logger.error("Given location id could not find database" +locationId);
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
        catch (Exception e){
             logger.error(e.getMessage());
        }
        return ResponseEntity.ok().build();
    }

    public List<LocationDTO> retrieveAllLocation() {
       return locationRepository.findAll().stream().map(l-> LocationMapper.toDTO(l)).collect(Collectors.toList());
    }
    public  Location retrieveLocationById(Long locationId){
        return locationRepository.findById(locationId).orElseThrow(()-> null);
    }
}
