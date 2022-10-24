package com.project.warehouseservice.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Entity
@Table(name="LOCATION")
public class Location {

    @SequenceGenerator(name = "location_sequence",
            sequenceName = "location_sequence",
            allocationSize = 1,initialValue = 5)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator ="location_sequence"
    )
    private Long id;
    @Column(nullable = false)
    private String address;

    private String city;
    private String country;

    public Location(String address) {
        this.address = address;
    }
}
