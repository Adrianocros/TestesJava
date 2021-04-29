package com.validarProdutos.validarProdutos_TDD.model;


public class Produto {
    
    private Long id;
    private String nome;
    private Double price;
    private Double maxDiscountPercentage;


    public Produto(Long id, String nome, Double price, Double maxDiscountPercentage) {
        this.id = id;
        this.nome = nome;
        this.price = price;
        this.maxDiscountPercentage = maxDiscountPercentage;
    }

    public Double getPriceWithDiscont(final double d){
        if(d > maxDiscountPercentage){
            return price * (1 - maxDiscountPercentage);
            }else{
                return price * (1 - d);
        }
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getMaxDiscountPercentage() {
        return maxDiscountPercentage;
    }

    public void setMaxDiscountPercentage(Double maxDiscountPercentage) {
        this.maxDiscountPercentage = maxDiscountPercentage;
    }

    

    
       
}
