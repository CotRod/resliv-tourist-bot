package com.github.cotrod.dao.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "city_name", nullable = false)
    private String cityName;

    @Column(name = "description", nullable = false)
    private String description;

}
