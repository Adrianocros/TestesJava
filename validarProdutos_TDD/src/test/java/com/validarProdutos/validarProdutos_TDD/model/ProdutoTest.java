package com.validarProdutos.validarProdutos_TDD.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ProdutoTest {
    
    @Test
    public void shouldCalculateTotalPriceWithDiscount(){
        Produto produto = new Produto(1l,"Teste",100.00,0.10);
        Double result = produto.getPriceWithDiscont(0.10);
        assertEquals(90.0, result);
    }

    @Test
    public void whenDiscountIsHigherThenMaxDiscountsShoulUseMaxDiscountPercentage(){
       Produto produto = new Produto(1l,"Teste", 100.00,0.10);
       Double result = produto.getPriceWithDiscont(0.15);
       assertEquals(90.0, result); 
    }
    @Test
    public void whenDiscountIsLowerThenMaxDiscountsShoulUseProviderDiscount(){
       Produto produto = new Produto(1l,"Teste", 100.00,0.10);
       Double result = produto.getPriceWithDiscont(0.05);
       assertEquals(95.0, result); 
    }


}
