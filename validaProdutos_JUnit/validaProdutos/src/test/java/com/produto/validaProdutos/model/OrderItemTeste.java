package com.produto.validaProdutos.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.produto.validaProdutos.OrderItem;
import com.produto.validaProdutos.Produto;

import org.junit.jupiter.api.Test;

public class OrderItemTeste {
    @Test
    public void showCalculateTotalPrice(){
        final Produto produto = new Produto(2l, "CocaCocla", 8.90, 5.0);
        final OrderItem orderItem = new OrderItem(produto, 3, 0.0);
        final Double result = orderItem.totalPrice();
        assertEquals(11.90, result);

    }

    
}
