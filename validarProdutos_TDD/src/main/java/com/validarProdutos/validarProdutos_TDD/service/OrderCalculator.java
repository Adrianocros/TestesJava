package com.validarProdutos.validarProdutos_TDD.service;

import com.validarProdutos.validarProdutos_TDD.model.OrderItem;

import java.util.List;




public class OrderCalculator {
    public Double calculateOrder(final List<OrderItem> items ){
         return items.stream().mapToDouble(OrderItem::totalPrice)
         .sum();
    }

    public Double calculeMultipleOrders(final List<List<OrderItem>> orders){
        return orders.stream().mapToDouble(this::calculateOrder)
        .sum();
        
    }
}
