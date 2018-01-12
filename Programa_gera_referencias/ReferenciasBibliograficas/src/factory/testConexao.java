/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author gabriel camata
 */
public class testConexao {
    public static void main(String[] args){
        try {
             JOptionPane.showMessageDialog(null,"Testando a conexao");
             Connection con = new ConnectionFactory().Conectar();
              JOptionPane.showMessageDialog(null,"Esta conectado");
             
        } catch (Exception e) {
         JOptionPane.showMessageDialog(null,"Error: "+ e);
        }
    }
}
