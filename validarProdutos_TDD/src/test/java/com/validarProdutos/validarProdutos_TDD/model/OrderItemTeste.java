package com.validarProdutos.validarProdutos_TDD.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.validarProdutos.validarProdutos_TDD.service.OrderCalculator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




public class OrderItemTeste {
    //Anotação que podem ajudar par configurar o setup de test
    //Mais utilizado em testes de integração
    @AfterAll
   static void afterAll(){
       System.out.println("After All");
   }

   @AfterEach
    void afterEach(){
    System.out.println("After Each");
   }

   @BeforeAll
   static void beforeAll(){
       System.out.println("Before all");
   }
  
    @BeforeEach
    void setUp(){
        System.out.println("Execução antes de cada uma BeforeEatch");
    }


   @Test
   public void showCalculateTotalPrice(){
        final Produto produto = new Produto(2l, "CocaCocla", 10.0, 5.0);
        final OrderItem orderItem = new OrderItem(produto, 3, 0.0);
        final Double result = orderItem.totalPrice();
        assertEquals(30.0, result);

    }

    
}
