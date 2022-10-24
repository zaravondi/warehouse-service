package com.project.warehouseservice.contracts;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductUpdateRequest {
    @Min(1L)
    private Long productId;
    @NotNull
    private String productName;
    private BigDecimal price;
    @Min(1)
    private int quantity;
    @Min(1L)
    private Long productCategoryId;
    @Min(1L)
    private Long locationId;
}
