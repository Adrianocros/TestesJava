package com.validarProdutos.validarProdutos_TDD.service;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Arrays;
import java.util.List;

import com.validarProdutos.validarProdutos_TDD.model.OrderItem;
import com.validarProdutos.validarProdutos_TDD.model.Produto;

import org.junit.jupiter.api.Test;

public class OrderCalculatorTest {
    @Test
    public void shouldCalculateTotalOrderPrice(){
        final OrderCalculator orderCalculator = new OrderCalculator();
        final List<OrderItem>orderItems = anOrder();
        Double result =  orderCalculator.calculateOrder(orderItems);
        assertEquals(30.00,result);
    }
   
    @Test
    public void sholdCalculateTotalOfMultileOrders(){
        final OrderCalculator orderCalculator = new OrderCalculator();
        final List<List<OrderItem>> orders = Arrays.asList(anOrder(),anOrder());
        final Double result = orderCalculator.calculeMultipleOrders(orders);   
        assertEquals(60.0,result);
    }

    private OrderItem aOrderItem(final Integer quantidade, 
                                final Double desconto, 
                                final Double preco,
                                final Double MaxDescontoPorcento){
        Produto produto = new Produto(1l,"TESTE", preco, MaxDescontoPorcento);
        return new OrderItem(produto, quantidade,desconto );
    }

    private List<OrderItem> anOrder() {
        return Arrays.asList(
            aOrderItem(2, /*quantidade*/ 0.0 /*desconto*/, 10.0 /*preco*/, 0.10 /*MaxDescontoPorcento*/),
            aOrderItem(10, 0.0, 1.0, 0.10)
        );
    }
}
