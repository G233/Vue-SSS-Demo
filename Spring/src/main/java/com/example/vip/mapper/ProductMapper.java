package com.example.vip.mapper;
import com.example.vip.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductMapper extends JpaRepository<Product, Long>{

}
