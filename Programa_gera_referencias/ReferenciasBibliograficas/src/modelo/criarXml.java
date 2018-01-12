/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.xml.bind.annotation.*;
import java.util.Collection;
import org.jdom2.output.XMLOutputter;
import java.io.*;
/**
 *
 * @author gabriel camata
 */
@XmlRootElement(name = "Livros")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "Livros",
        propOrder = {"Nome", "Sobrenome", "Titulo", "Subtitulo", "Local", "Ano", "Editora", "Paginas"}
)
public class criarXml {
    @XmlElement(name = "Nome", required = true)
    private String Nome;
    
    @XmlElement(name = "Sobrenome", required = true)
    private String Sobrenome;
    
    @XmlElement(name = "Titulo", required = true)
    private String Titulo;
    
    @XmlElement(name = "Subtitulo", required = true)
    private String Subtitulo;
    
    @XmlElement(name = "Local", required = true)
    private String Local;

    @XmlElement(name = "Ano", required = true)
    private String Ano;
    
    @XmlElement(name = "Editora", required = true)
    private String Editora;
    
    @XmlElement(name = "Paginas", required = true)
    private String Paginas;

   
    
    public String getNome() {
        return Nome;
    }
    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    public String getSobrenome() {
        return Sobrenome;
    }
    public void setSobrenome(String Sobrenome) {
        this.Sobrenome = Sobrenome;
    }
    public String getTitulo() {
        return Titulo;
    }
    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }
    public String getSubtitulo() {
        return Subtitulo;
    }
    public void setSubtitulo(String Subtitulo) {
        this.Subtitulo = Subtitulo;
    }
    public String getLocal() {
        return Local;
    }
    public void setLocal(String Local) {
        this.Local = Local;
    }
    public String getAno() {
        return Ano;
    }
    public void setAno(String Ano) {
        this.Ano = Ano;
    }
    public String getEditora() {
        return Editora;
    }
    public void setEditora(String Editora) {
        this.Editora = Editora;
    }
    public String getPaginas() {
        return Paginas;
    }
    public void setPaginas(String Paginas) {
        this.Paginas = Paginas;
    }


}
