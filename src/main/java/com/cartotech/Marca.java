package com.cartotech;

public class Marca {
     int id;
     String nome;

    public Marca(int id, String nome){
        this.setId(id);
        this.setNome(nome);
    }

    public Marca(int id){
        this.setId(id);
    }

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }    
}
