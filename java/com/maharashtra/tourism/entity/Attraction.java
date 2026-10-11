package com.maharashtra.tourism.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="attractions")
public class Attraction {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
    @ManyToOne(fetch=FetchType.LAZY, optional=false) @JoinColumn(name="destination_id") private Destination destination;
    @Column(nullable=false) private String name;
    @Column(length=700) private String description;
    private String category;
    private String visitPeriod;
    private Integer visitMinutes;
    @Column(precision=10,scale=2) private BigDecimal entryFee;
    public Attraction(){}
    public Attraction(Destination destination,String name,String description,String category,String visitPeriod,Integer visitMinutes,BigDecimal entryFee){this.destination=destination;this.name=name;this.description=description;this.category=category;this.visitPeriod=visitPeriod;this.visitMinutes=visitMinutes;this.entryFee=entryFee;}
    public Long getId(){return id;} public Long getDestinationId(){return destination==null?null:destination.getId();}
    public String getName(){return name;} public String getDescription(){return description;} public String getCategory(){return category;} public String getVisitPeriod(){return visitPeriod;} public Integer getVisitMinutes(){return visitMinutes;} public BigDecimal getEntryFee(){return entryFee;}
}
