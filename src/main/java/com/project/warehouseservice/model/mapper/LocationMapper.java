package com.project.warehouseservice.model.mapper;

import com.project.warehouseservice.model.Location;
import com.project.warehouseservice.model.dto.LocationDTO;
import org.modelmapper.ModelMapper;

public class LocationMapper {

    public static LocationDTO toDTO(Location location){

        ModelMapper modelMapper=new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        return modelMapper.map(location,LocationDTO.class);
    }
}
