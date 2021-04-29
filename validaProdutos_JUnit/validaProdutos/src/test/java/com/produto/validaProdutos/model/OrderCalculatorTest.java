package com.produto.validaProdutos.model;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Arrays;
import java.util.List;

import com.produto.validaProdutos.OrderCalculator;
import com.produto.validaProdutos.OrderItem;
import com.produto.validaProdutos.Produto;

import org.junit.jupiter.api.Test;


public class OrderCalculatorTest {
    @Test
    public void shouldCalculateTotalOrderPrice(){
        final OrderCalculator orderCalculator = new OrderCalculator();
        final List<OrderItem>orderItems = Arrays.asList(
            aOrderItem(2, /*quantidade*/ 0.0 /*desconto*/, 10.0 /*preco*/, 0.10 /*MaxDescontoPorcento*/),
            aOrderItem(10, 0.0, 1.0, 0.10)
        );
        Double result =  orderCalculator.calculateOrder(orderItems);
        assertEquals(30.00,result);
    }

    private OrderItem aOrderItem(final Integer quantidade, 
                                final Double desconto, 
                                final Double preco,
                                final Double MaxDescontoPorcento){
        Produto produto = new Produto(1l,"TESTE", preco, MaxDescontoPorcento);
        return new OrderItem(produto, quantidade,desconto );
    }
}
