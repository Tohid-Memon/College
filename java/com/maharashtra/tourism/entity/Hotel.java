package com.maharashtra.tourism.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="hotel_suggestions")
public class Hotel {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @ManyToOne(fetch=FetchType.LAZY, optional=false) @JoinColumn(name="destination_id") private Destination destination;
    @Column(nullable=false) private String name;
    @Column(nullable=false) private String category;
    @Column(nullable=false,precision=10,scale=2) private BigDecimal pricePerNight;
    @Column(length=700) private String description;
    private String facilities;
    public Hotel(){}
    public Hotel(Destination destination,String name,String category,BigDecimal pricePerNight,String description,String facilities){this.destination=destination;this.name=name;this.category=category;this.pricePerNight=pricePerNight;this.description=description;this.facilities=facilities;}
    public Long getId(){return id;} public Long getDestinationId(){return destination==null?null:destination.getId();}
    public String getName(){return name;} public String getCategory(){return category;} public BigDecimal getPricePerNight(){return pricePerNight;} public String getDescription(){return description;} public String getFacilities(){return facilities;}
}
