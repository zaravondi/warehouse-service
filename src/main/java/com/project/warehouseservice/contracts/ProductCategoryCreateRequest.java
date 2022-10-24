package com.project.warehouseservice.contracts;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProductCategoryCreateRequest {

    @NotNull
    private String categoryName;
}
