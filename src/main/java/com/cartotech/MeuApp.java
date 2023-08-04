package com.cartotech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MeuApp {

    public static void main(String[] args){
        
        try{
            Class.forName("org.sqlite.JDBC");
            System.err.println("Lib encontrada!");
        } catch (ClassNotFoundException e){
            System.err.println("Lib não encontrada.");
        }

        Connection con = null;
        try{
            con = DriverManager.getConnection("jdbc:sqlite:database.db");
            System.err.println("Conexão realizada com sucesso.");
        }
        catch (SQLException e){
            System.err.println("Banco de dados não encontrado.");
        } 

        try{
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("select * from estado");
            while (rs.next()){
                System.err.printf("Id: %d Nome: %s UF: %s \n", rs.getInt("id"),rs.getString("nome"),rs.getString("uf"));
            }
            System.err.println("Query concluída!");
        } catch (SQLException e){
            System.err.println("Erro na execução da query.");
        } 
    }
    
}
