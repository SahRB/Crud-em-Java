/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.me.correx;

/**
 *
 * @author sabri
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.sql.SQLException;

public class rastreio {
    private static final String URL = "jdbc:derby://localhost:1527/dbcorrex";
    private static final String USUARIO = "CORREX";
    private static final String SENHA = "correx";
    public static String[] SelecionaProduto(String codProduto) {
       try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            
            String sql = ("SELECT nomeproduto,status,localatual,previsao FROM PRODUTO WHERE codproduto = ?");
            PreparedStatement statement = connection.prepareStatement(sql);
            
         
            statement.setString(1, codProduto);
      

          ResultSet rs =statement.executeQuery();

            if (rs.next()) {
               
                String nomenovo = rs.getString("NOMEPRODUTO");
                String statusnovo = rs.getString("STATUS");
                String localnovo = rs.getString("LOCALATUAL");
                Date previsaonovo = rs.getDate("PREVISAO");
                
               return new String[]{nomenovo,statusnovo,localnovo,previsaonovo.toString()};
            }
                    
            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
         return null;
        }
    }
