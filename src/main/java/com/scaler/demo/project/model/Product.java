package com.scaler.demo.project.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "products")
public class Product extends BaseModel {
    private String name;
    private String description;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Category category;
    private String imageUrl;
    private Double price;

}
