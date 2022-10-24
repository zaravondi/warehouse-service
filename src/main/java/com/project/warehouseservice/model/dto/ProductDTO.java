package com.project.warehouseservice.model.dto;

import com.project.warehouseservice.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class ProductDTO implements Comparable<ProductDTO>{

    private String productName;
    private BigDecimal price;
    private int quantity;
    private String productCategoryName;
    private String locationName;
    private Long id;
    @Override
    public int compareTo(ProductDTO o) {
        return this.productName.compareToIgnoreCase(o.productName);
    }

}
