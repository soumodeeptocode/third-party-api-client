package com.scaler.demo.project.repository;

import com.scaler.demo.project.model.Product;
import com.scaler.demo.project.model.projections.ProductWithIdAndName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByNameContaining(String word);

    @Override
    Optional<Product> findById(Long aLong);

    @Override
    List<Product> findAll();

    /**
     * HSQL
     * @return
     */
//    @Query("select p from Product p")
//    List<ProductWithIdAndName> getAllProducts();
    @Query(value = "select id as productId, name, description from products", nativeQuery = true)
    List<ProductWithIdAndName> getProductByIdAndName();

    @Query(value = "select id, name from products", nativeQuery = true)
    List<Map<String, Object>> getAllProducts();





//   row ->  id, name, description
//    List<row>
}

