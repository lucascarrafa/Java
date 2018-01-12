/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author gabriel camata
 */
public class ConnectionFactory {
   
    public Connection Conectar(){
        try{
           return DriverManager.getConnection("jdbc:mysql://localhost:3306/referenciasdb","root","gabriel");
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        
        
    }
}
