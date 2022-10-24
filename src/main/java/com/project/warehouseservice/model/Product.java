package com.project.warehouseservice.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Entity
@Table(name="PRODUCT")
public class Product {

    @SequenceGenerator(name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1,initialValue = 19)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator ="product_sequence"
    )
    private Long id;
    @Column(nullable = false)
    private String productName;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private int quantity;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_productcategory_id", referencedColumnName = "id")
    private ProductCategory productCategory;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "fk_location_id", referencedColumnName = "id")
    private Location location;


}
