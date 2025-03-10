package co.com.theluguiant.data.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import co.com.theluguiant.domain.entity.Products;

@Repository
public class ProductsRepository  extends BaseRepository<Products> {

    @Value("${amazon.dynamo.products.table}")
    private String table;
    @Value("#{new Boolean('${amazon.dynamo.products.consistentRead}')}") 
    private boolean consistentRead;

    @Override
    public String getTableName(){
        return table;
    }

    public void saveProduct(Products product){
        save(product);
    }
    
    public Products getProduct(String pk, Optional<String> sk) {
        return super.getItem(pk, sk);
    }
}




