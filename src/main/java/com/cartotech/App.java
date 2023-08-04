package com.cartotech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    
    private static final String JDBC_URL = "jdbc:sqlite:database.db";

    public static void main(String[] args) {
        new App();
    }

    public App(){
        try(Connection conn = getConnection()){
            carregarDriverJDBC();
            listarEstados(conn);
            //localizarEstado(conn, "PR");
            listarDadosTabela(conn, "produto");
            Produto p1 = new Produto("Steam Deck", 0, 2500.00);
            Produto p2 = new Produto(201);
            ProdutoDAO pd = new ProdutoDAO(conn);            
            pd.salvar(p1);
            pd.excluir(p2);
        } catch (SQLException e) {
            System.err.println("Não foi possível conectar ao banco de dados: " + e.getMessage());
        }        
    }

    private void listarDadosTabela(Connection conn, String tabela) {
        String sql = "select * from " + tabela;
        //System.out.println(sql);
        try {
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            ResultSetMetaData metadata = result.getMetaData();
            int cols = metadata.getColumnCount();

            for (int i = 1; i <= cols; i++) {
                System.out.printf("%-25s | ", metadata.getColumnName(i));
            }
            System.out.println();

            while(result.next()){
                for (int i = 1; i <= cols; i++) {
                    System.out.printf("%-25s | ", result.getString(i));
                }
                System.out.println();
            }
        } catch (SQLException e) {
            System.err.println("Erro na execução da consulta: " + e.getMessage());
        }
        
    }

    private void localizarEstado(Connection conn, String uf) {
        try{
            //var sql = "select * from estado where uf = '" + uf + "'"; //suscetível a SQL Injection
            String sql = "select * from estado where uf = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            //System.out.println(sql);
            statement.setString(1, uf);
            ResultSet result = statement.executeQuery();
            if(result.next()){
                System.out.printf("Id: %d Nome: %s UF: %s\n", result.getInt("id"), result.getString("nome"), result.getString("uf"));
            }
            System.out.println();
        } catch(SQLException e){
            System.err.println("Erro ao executar consulta SQL: " + e.getMessage());
        }
        
    }

    private void listarEstados(Connection conn) {
        try{
            System.out.println("Conexão com o banco realizada com sucesso.");

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("select * from estado");
            while(result.next()){
                System.out.printf("Id: %d Nome: %s UF: %s\n", result.getInt("id"), result.getString("nome"), result.getString("uf"));
            }
            System.out.println();
        } catch (SQLException e) {
            System.err.println("Não foi possível executar a consulta ao banco: " + e.getMessage());
        }
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL);
    }

    private void carregarDriverJDBC() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            System.err.println("Não foi possível carregar a biblioteca para acesso ao banco de dados: " + e.getMessage());
        }
    }
}
