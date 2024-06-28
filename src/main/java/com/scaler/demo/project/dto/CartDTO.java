package com.scaler.demo.project.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CartDTO implements Serializable {
    @JsonProperty(required = true)
    private int id;
    @JsonProperty(required = true)
    private int userId;
    private Date date;
    private List<ProductDTO> products;

    public CartDTO(int id, int userId){

    }
}
