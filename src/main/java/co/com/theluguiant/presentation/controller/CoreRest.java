package co.com.theluguiant.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import co.com.theluguiant.domain.dto.request.ProductsRequest;
import co.com.theluguiant.domain.dto.response.Response;
import co.com.theluguiant.domain.use_case.ProductBusiness;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/core_rest")
public class CoreRest {
    ProductBusiness productBusiness;

    @Autowired
    public void setProductBusiness(ProductBusiness productBusiness) {
        this.productBusiness = productBusiness;
    }
    
    @ResponseBody
    @PostMapping(value = "/save",produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<String> save(@Valid @RequestBody ProductsRequest request) throws Exception {
        return productBusiness.saveProduct(request);
    }

}
