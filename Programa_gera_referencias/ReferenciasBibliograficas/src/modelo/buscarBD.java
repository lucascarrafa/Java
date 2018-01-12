/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import factory.ConnectionFactory;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author gabriel camata
 */
public class buscarBD {
    private final Connection con;
    Statement stmt;
    public buscarBD(String titulo){
        this.con = new ConnectionFactory().Conectar();
        
        try {
            this.stmt = con.createStatement();
            ResultSet rs = this.stmt.executeQuery("select * from livros");
            String nome = null;
            while(rs.next()){
                if(rs.getString("titulo").equals(titulo)){
                   
                    try {
                        nome = rs.getString("titulo");
                        FileWriter referencia;
                        referencia = new FileWriter(new File("buscaReferencia.txt"));
                        referencia.write(rs.getString("sobrenome").toUpperCase()+ ","+ rs.getString("nome")+". "+
                        rs.getString("titulo")+""+ ": "+rs.getString("subtitulo")+". "+rs.getString("place")+": "+
                        rs.getString("editora")+", "+rs.getString("ano")+". "+ rs.getString("paginas")+"p.");
                        referencia.close();
                        JOptionPane.showMessageDialog(null, "Titulo Encontrado!");
                     } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,"Não criou o arquivo txt, por causa de: " +ex);
                    }
                }
            
            }
            if(nome == null) JOptionPane.showMessageDialog(null, "Nao foi encontrado o titulo");
            rs.close();
            
           
            
        } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null,"ERROR: "+ex);    
        //Logger.getLogger(buscarBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}