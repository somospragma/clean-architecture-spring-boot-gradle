package co.com.theluguiant.domain.service;

import co.com.theluguiant.domain.request.ProductsRequest;
import co.com.theluguiant.domain.response.Response;

public interface ProductBusiness {
    Response<String> saveProduct(ProductsRequest request) throws Exception;
    void updateProduct();
    void deleteProduct();
    void getProduct();
    void getAllProducts();
}
