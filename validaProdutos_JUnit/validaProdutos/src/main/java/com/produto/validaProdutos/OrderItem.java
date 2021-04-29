package com.produto.validaProdutos;

public class OrderItem {
    private Produto produto;
    private Integer qualidade;
    private Double desconto;

    public Double totalPrice(){
        return produto.getPriceWithDiscont(desconto) * qualidade;
    }


    

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQualidade() {
        return qualidade;
    }

    public void setQualidade(Integer qualidade) {
        this.qualidade = qualidade;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }




    public OrderItem(Produto produto, Integer qualidade, Double desconto) {
        this.produto = produto;
        this.qualidade = qualidade;
        this.desconto = desconto;
    }

    

}
