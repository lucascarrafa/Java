/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.*;
import factory.ConnectionFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author gabriel camata
 */
public class inserirBD {
    private final Connection con;
    /**
     *
     * @param sqlNome
     * @param sqlSobrenome
     * @param sqlTitulo
     * @param sqlSubtitulo
     * @param sqlPlace
     * @param sqlAno
     * @param sqlEditora
     * @param sqlPagina
     */
    public inserirBD(String sqlNome,String sqlSobrenome,String sqlTitulo,
              String sqlSubtitulo,String sqlPlace,String sqlAno,String sqlEditora,String sqlPagina){
        this.con = new ConnectionFactory().Conectar();
        String sql;
        sql = "INSERT INTO livros (nome,sobrenome,titulo,subtitulo,place,ano,editora,paginas) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement stmt;
            try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, sqlNome);
            stmt.setString(2, sqlSobrenome);
            stmt.setString(3, sqlTitulo);
            stmt.setString(4, sqlSubtitulo);
            stmt.setString(5, sqlPlace);
            stmt.setString(6, sqlAno);
            stmt.setString(7, sqlEditora);
            stmt.setString(8, sqlPagina);
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null,"Gravado com Sucesso");
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Nao foi possivel gravar, ERROR: " + ex);
            //Logger.getLogger(inserirBD.class.getName()).log(Level.SEVERE, null, ex);
            }
            
       
    }
    
}
