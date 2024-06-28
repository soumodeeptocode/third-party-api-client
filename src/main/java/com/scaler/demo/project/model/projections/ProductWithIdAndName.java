package com.scaler.demo.project.model.projections;

import javax.swing.tree.RowMapper;

//Projection Interface//
public interface ProductWithIdAndName {
    Long getProductId();
    String getName();
    String getDescription();
}
