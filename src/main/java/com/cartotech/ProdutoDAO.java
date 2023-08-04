package com.cartotech;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO{

    Connection conexao;

    public ProdutoDAO(Connection conexao){
        this.setConexao(conexao);
    }
        
    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }

    public void salvar(Produto produto){
        String sql = "INSERT INTO produto (nome, marca_id, valor) VALUES (?, ?, ?)";
        try{
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, produto.getNome());
            stm.setInt(2, produto.getMarca().getId());
            stm.setDouble(3, produto.getValor());
            stm.executeUpdate();
        } catch (SQLException e){
            System.err.println("Erro ao salvar.");
        }
    }

    public void excluir(Produto produto){
        String sql = "DELETE FROM produto WHERE id = ?";
        try{
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setInt(1, produto.getId());
            stm.executeUpdate();
        } catch (SQLException e){
            System.err.println("Erro ao exluir.");
        }
    }
}
