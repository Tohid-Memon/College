package com.maharashtra.tourism.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "destinations", uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class Destination {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 120) private String name;
    private String district;
    @Column(length = 1200) private String description;
    private String bestTime;
    private Integer recommendedDays;
    private String category;
    private String imageUrl;

    public Destination() {}
    public Destination(String name, String district, String description, String bestTime, Integer recommendedDays, String category, String imageUrl) {
        this.name=name; this.district=district; this.description=description; this.bestTime=bestTime; this.recommendedDays=recommendedDays; this.category=category; this.imageUrl=imageUrl;
    }
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getName(){return name;} public void setName(String name){this.name=name;}
    public String getDistrict(){return district;} public void setDistrict(String district){this.district=district;}
    public String getDescription(){return description;} public void setDescription(String description){this.description=description;}
    public String getBestTime(){return bestTime;} public void setBestTime(String bestTime){this.bestTime=bestTime;}
    public Integer getRecommendedDays(){return recommendedDays;} public void setRecommendedDays(Integer recommendedDays){this.recommendedDays=recommendedDays;}
    public String getCategory(){return category;} public void setCategory(String category){this.category=category;}
    public String getImageUrl(){return imageUrl;} public void setImageUrl(String imageUrl){this.imageUrl=imageUrl;}
}
