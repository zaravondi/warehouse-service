package com.project.warehouseservice.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name="PRODUCT_CATEGORY")
public class ProductCategory {

    @SequenceGenerator(name = "product_category_sequence",
            sequenceName = "product_category_sequence",
            allocationSize = 1, initialValue = 9)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator ="product_category_sequence"
    )
    private Long id;

    @Column(nullable = false)
    private String categoryName;

    public ProductCategory(String categoryName) {
        this.categoryName = categoryName;
    }
}
