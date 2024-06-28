package com.scaler.demo.project.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private Date createdAt;
    private Date lastUpdatedAt;
    private boolean isDeleted;

}
