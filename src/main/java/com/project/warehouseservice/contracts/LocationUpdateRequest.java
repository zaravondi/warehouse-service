package com.project.warehouseservice.contracts;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class LocationUpdateRequest {

    @Min(1L)
    private Long locationId;
    @NotNull
    private String address;
    @NotNull
    private String city;
    @NotNull
    private String country;
}
