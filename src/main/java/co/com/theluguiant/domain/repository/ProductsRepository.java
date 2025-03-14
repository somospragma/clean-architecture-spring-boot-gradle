package co.com.theluguiant.domain.repository;

import co.com.theluguiant.domain.entity.Products;

import java.util.Optional;

public interface ProductsRepository {
    public String getTableName();
    public void saveProduct(Products product) throws Exception;
    public Products getProduct(String pk, Optional<String> sk) throws Exception;
}
