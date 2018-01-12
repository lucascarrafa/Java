/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import factory.ConnectionFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jdom2.*;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author gabriel camata
 */
public class exportarBD {
    private final Connection con;
    Statement st;
    
    public exportarBD(){
        this.con = new ConnectionFactory().Conectar();
        try {
            this.st = con.createStatement();
            ResultSet rs = this.st.executeQuery("select * from livros");
            Document doc = new Document();
            Element root = new Element("Livros");
            
            while(rs.next()){
                Element ref = new Element("ref");
                Element Nome = new Element("Nome");
                Element Sobrenome = new Element("Sobrenome");
                Element Titulo = new Element("Titulo");
                Element Subtitulo = new Element("Subtitulo");
                Element Local = new Element("Local");
                Element Ano = new Element("Ano");
                Element Editora = new Element("Editora");
                Element Paginas = new Element("Paginas");
                
                Nome.setText(rs.getString("nome"));
                Sobrenome.setText(rs.getString("sobrenome"));
                Titulo.setText(rs.getString("titulo"));
                Subtitulo.setText(rs.getString("subtitulo"));
                Local.setText(rs.getString("place"));
                Ano.setText(rs.getString("ano"));
                Editora.setText(rs.getString("editora"));
                Paginas.setText(rs.getString("paginas"));
                
                ref.addContent(Nome);
                ref.addContent(Sobrenome);
                ref.addContent(Titulo);
                ref.addContent(Subtitulo);
                ref.addContent(Local);
                ref.addContent(Ano);
                ref.addContent(Editora);
                ref.addContent(Paginas);
                root.addContent(ref);
                /*root.addContent(Nome);
                root.addContent(Sobrenome);
                root.addContent(Titulo);
                root.addContent(Subtitulo);
                root.addContent(Local);
                root.addContent(Ano);
                root.addContent(Editora);
                root.addContent(Paginas);
                */
            }
            doc.setRootElement(root);
            XMLOutputter xout = new XMLOutputter();
            OutputStream out = new FileOutputStream( new File("Exportacao.xml"));
            xout.output(doc , out);
            JOptionPane.showMessageDialog(null, "Exportação do BD feita com sucesso");
        } catch (SQLException ex) {
            Logger.getLogger(exportarBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(exportarBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(exportarBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
