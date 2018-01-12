/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;


/**
 *
 * @author gabriel camata
 */
public class Leitura {	
    public Leitura(String caminho){
        File f = new File(caminho);
        
        SAXBuilder builder = new SAXBuilder();
        Document doc;
        try {
            doc = builder.build(f);
            Element root = (Element) doc.getRootElement();
		         
            List livros = root.getChildren();
            Iterator i = livros.iterator();
		             
            while( i.hasNext() ){
                Element livro = (Element) i.next();
                inserirBD inserir;
                inserir = new inserirBD(livro.getChildText("Nome"),livro.getChildText("Sobrenome"),livro.getChildText("Titulo"),
                livro.getChildText("Subtitulo"),livro.getChildText("Local"),livro.getChildText("Ano"),
                livro.getChildText("Editora"),livro.getChildText("Paginas"));
            }
        } catch (JDOMException | IOException ex) {
            JOptionPane.showMessageDialog(null, "ERROR : "+ex);
            //Logger.getLogger(Leitura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

