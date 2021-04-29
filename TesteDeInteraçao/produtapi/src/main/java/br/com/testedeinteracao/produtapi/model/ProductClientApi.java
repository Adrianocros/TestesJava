package br.com.testedeinteracao.produtapi.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductClientApi {

    @Value("${product.api.url}")
    private String url; 
    
    public List<Product> findAll(){
        ResponseEntity<ProductDTO> responseEntity = 
        new RestTemplate().getForEntity(url, ProductDTO.class);
        return responseEntity.getBody().getProducts();
    }


}
