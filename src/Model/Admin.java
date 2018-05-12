/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Pirozzi
 */
public class Admin {
 
    private String nome;
    private String cognome;
    private String id;
    private String cf;

    public Admin(String nome,String cognome,String id,String cf)
    {
        this.nome = nome;
        this.cognome=cognome;
        this.id=id;
        this.cf=cf;
    }
    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }
    
    public String getName() {
        return nome;
    }

    public void setName(String name) {
        this.nome = name;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
}
