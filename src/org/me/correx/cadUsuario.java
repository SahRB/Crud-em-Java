/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.me.correx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author sabri
 */
public class cadUsuario {

    private static final String URL = "jdbc:derby://localhost:1527/dbcorrex";
    private static final String USUARIO = "CORREX";
    private static final String SENHA = "correx";
    public static void cadastrarUsuario(String nome, String tipo, String cpf, String senha) {
       try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            
            String sql = "INSERT INTO USUARIO (NOME, TIPO, CPF, SENHA) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, nome);
             statement.setString(2, tipo);
            statement.setString(3, cpf);
            statement.setString(4, senha);
      

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Usuario cadastrado com sucesso.");
               
                // Lógica para oferecer a opção de copiar o código do produto
            } else {
                System.out.println("Falha ao cadastrar o usuario.");
            }

            statement.close();
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar o produto: " + e.getMessage());
        }
    }
    }
    
    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template

/**
 *
 * @author sabri
 */

     
 
    
