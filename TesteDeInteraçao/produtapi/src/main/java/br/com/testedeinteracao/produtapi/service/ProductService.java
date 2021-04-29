package br.com.testedeinteracao.produtapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.testedeinteracao.produtapi.model.Product;
import br.com.testedeinteracao.produtapi.model.ProductClientApi;

@Service
public class ProductService {
    @Autowired
    private ProductClientApi client;

    public List<Product>findAll(){
        return client.findAll();
    }

}
