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
/**
 *
 * @author sabri
 */
public class EditaProduto {
    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/
    
     private static final String URL = "jdbc:derby://localhost:1527/dbcorrex ";
    private static final String USUARIO = "CORREX";
    private static final String SENHA = "correx";
   
    public static void editarProduto(String nomeProduto,String status, String localAtual,Date previsao, String tipoProduto, double peso, double tamanho, String remetente, String destinatario,String codProduto) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            
            String sql = "UPDATE PRODUTO SET NOMEPRODUTO = ?, STATUS = ?, LOCALATUAL = ?, PREVISAO = ?, TIPOPRODUTO = ?, PESO = ?, TAMANHO = ?, REMETENTE = ?, DESTINATARIO = ? WHERE CODPRODUTO= ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, nomeProduto);
            statement.setString(2, status);
            statement.setString(3, localAtual);
            statement.setDate(4, (java.sql.Date) previsao);
            statement.setString(5, tipoProduto);
            statement.setDouble(6, peso);
            statement.setDouble(7, tamanho);
            statement.setString(8, remetente);
            statement.setString(9, destinatario);
            statement.setString(10, codProduto);

            int rowsUpdated = statement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Produto atualizado com sucesso.");
                // Lógica para oferecer a opção de copiar o código do produto
            } else {
                System.out.println("Falha ao atualizar o produto.");
            }

            statement.close();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar o produto: " + e.getMessage());
        }
    }
}

