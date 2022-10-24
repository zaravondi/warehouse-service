package com.project.warehouseservice.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationDTO {
    private String address;
    private String city;
    private String country;
    private Long id;
}
