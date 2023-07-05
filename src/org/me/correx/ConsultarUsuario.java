/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.me.correx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class ConsultarUsuario {
    
private static final String URL = "jdbc:derby://localhost:1527/dbcorrex";
    private static final String USUARIO = "CORREX";
    private static final String SENHA = "correx";
    public static String verificarTipoUsuario(String cpf, String senha) {
       try (Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA)) {
            
            String sql = ("SELECT tipo FROM usuario WHERE cpf = ? AND senha = ?");
            PreparedStatement statement = connection.prepareStatement(sql);
            
         
            statement.setString(1, cpf);
            statement.setString(2, senha);
      

          ResultSet rs =statement.executeQuery();

            if (rs.next()) {
                return rs.getString("tipo");
            }

            rs.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
