package com.cartotech;

public class Produto{
    int id;
    String nome;
    Marca marca;
    double valor;

    public Produto(String nome, int marca_id, double valor){
        this.setNome(nome);
        this.setMarca(marca_id);
        this.setValor(valor);
    }

    public Produto(int id){
        this.setId(id);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Marca getMarca() {
        return marca;
    }

    public double getValor() {
        return valor;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public void setMarca(int marca_id){
        Marca marca = new Marca(marca_id);
        this.setMarca(marca);
    }

    public void setValor(double valor) {
        this.valor = valor;
    }        
}