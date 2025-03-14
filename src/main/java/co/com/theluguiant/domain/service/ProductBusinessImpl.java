package co.com.theluguiant.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.theluguiant.data.repository.ProductsRepository;
import co.com.theluguiant.domain.entity.Products;
import co.com.theluguiant.domain.dto.request.ProductsRequest;
import co.com.theluguiant.domain.dto.response.Response;
import co.com.theluguiant.utils.Generator;
import co.com.theluguiant.domain.utils.ResponseGenerator;
import co.com.theluguiant.utils.Util;


@Service
public class ProductBusinessImpl implements ProductBusiness {
	
	private final ProductsRepository productsRepository;

    @Autowired
    public ProductBusinessImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

	@Override
	public Response<String> saveProduct(ProductsRequest request) throws Exception {
		// TODO Auto-generated method stub
		Products product = new Products();

        String idProduct = Generator.getNewIdGenerator();
        String createDate = Util.dateInFormat();

        product.setIdProduct(idProduct);
        product.setProductType(String.valueOf(1));
        product.setName(request.getName());
        product.setStatus(String.valueOf(true));
        product.setValue(request.getValue()); // Using getValue() instead of getPrice()
        product.setCreatedDate(createDate);
        
        productsRepository.saveProduct(product);
        
		return ResponseGenerator.callResponse("Save", null);
	}

	@Override
	public void updateProduct() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteProduct() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getProduct() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAllProducts() {
		// TODO Auto-generated method stub
		
	}

}
