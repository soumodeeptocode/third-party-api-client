package com.scaler.demo.project.inheritance.demo.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "tbc_mentors")
public class Mentor extends User {
    private Double averageRating;
}
