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
public class cadProduto {
    
     private static final String URL = "jdbc:derby://localhost:1527/dbcorrex ";
    private static final String USUARIO = "CORREX";
    private static final String SENHA = "correx";
   
    
    


    
    
    public static void cadastrarProduto(String codProduto,String nomeProduto, String status, String localAtual, Date previsao, String tipoProduto, double peso, double tamanho, String remetente, String destinatario) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String codigoRastreio = UUID.randomUUID().toString().substring(20);
            
            String sql = "INSERT INTO PRODUTO (CODPRODUTO, NOMEPRODUTO, STATUS, LOCALATUAL, PREVISAO, TIPOPRODUTO, PESO, TAMANHO, REMETENTE, DESTINATARIO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setString(1, codProduto);
            statement.setString(2, nomeProduto);
            statement.setString(3, status);
            statement.setString(4, localAtual);
            statement.setDate(5, (java.sql.Date) previsao);
            statement.setString(6, tipoProduto);
            statement.setDouble(7, peso);
            statement.setDouble(8, tamanho);
            statement.setString(9, remetente);
            statement.setString(10, destinatario);

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("Produto cadastrado com sucesso.");
                System.out.println("Código de rastreio: " + codigoRastreio);
                System.out.println("Deseja copiar o código do produto?");
                // Lógica para oferecer a opção de copiar o código do produto
            } else {
                System.out.println("Falha ao cadastrar o produto.");
            }

            statement.close();
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar o produto: " + e.getMessage());
        }
    }
   public static boolean excluirProduto(String codigoProduto) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            String sql = "DELETE FROM PRODUTO WHERE CODPRODUTO = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, codigoProduto);
                
                int rowsDeleted = statement.executeUpdate();
                
                if (rowsDeleted > 0) {
                    System.out.println("Produto excluído com sucesso.");
                    return true;
                } else {
                    System.out.println("Nenhum produto encontrado com o código informado.");
                    return false;
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao excluir o produto: " + e.getMessage());
            return false;
        }
    }
 

    
}
