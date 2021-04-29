package com.produto.validaProdutos;

import java.util.List;


public class OrderCalculator {
    public Double calculateOrder(final List<OrderItem> items ){
         return items.stream().mapToDouble(OrderItem::totalPrice)
         .sum();
    }
}
