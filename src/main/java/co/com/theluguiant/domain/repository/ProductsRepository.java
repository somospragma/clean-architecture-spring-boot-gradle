package co.com.theluguiant.domain.repository;

import co.com.theluguiant.domain.entity.Products;

/**
 * Repository interface for Product operations.
 * This follows the Dependency Inversion Principle - high-level modules (domain)
 * define interfaces that low-level modules (data) implement.
 */
public interface ProductsRepository {
    
    /**
     * Saves a product based on the provided entity.
     * 
     * @param product The product entity to save
     * @return Void
     */
    Void saveProduct(Products product);
    
    // Add other repository methods as needed
}
