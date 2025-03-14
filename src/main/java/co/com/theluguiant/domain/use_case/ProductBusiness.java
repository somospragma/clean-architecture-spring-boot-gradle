package co.com.theluguiant.domain.use_case;

import co.com.theluguiant.domain.dto.request.ProductsRequest;
import co.com.theluguiant.domain.dto.response.Response;

public interface ProductBusiness {
    Response<String> saveProduct(ProductsRequest request) throws Exception;
    void updateProduct();
    void deleteProduct();
    void getProduct();
    void getAllProducts();
}
