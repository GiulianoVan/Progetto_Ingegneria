/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBean;

/**
 *
 * @author Pirozzi
 */
public class Admin {
 
    private String nome; // ("^[a-z]+(['']?[a-z ]+)*$",Pattern.CASE_INSENSITIVE);
    private String cognome; // ("^[a-z]+(['' -]?[a-z ]+)*$",Pattern.CASE_INSENSITIVE);
    private String id; // ("[0-9]{6}$");
    private String cf; // ("^[a-z1-9]{16}$",Pattern.CASE_INSENSITIVE);

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
