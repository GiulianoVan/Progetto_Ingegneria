/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Addetto;

import java.util.Objects;

/**
 *
 * @author Pirozzi
 */
public class Addetto {

   private double stipendio;
   private String email;
   private String tel;
   private String cf;
   private int livello;
   private String nome;
   private String cognome;
   private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

   public Addetto(String nome,String cogn,String cf,String email,String tel,Double stip,int livello,String id)
   {
       this.nome = nome;
       this.cognome = cogn;
       this.cf = cf;
       this.email = email;
       this.tel = tel;
       this.stipendio = stip;
       this.livello = livello;
       this.id = id;
   }
  
 
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }


    public Double getStipendio() {
        return stipendio;
    }

    public void setStipendio(Double stipendio) {
        this.stipendio = stipendio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public Integer getLivello() {
        return livello;
    }

    public void setLivello(int livello) {
        this.livello = livello;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.stipendio);
        hash = 53 * hash + Objects.hashCode(this.email);
        hash = 53 * hash + Objects.hashCode(this.tel);
        hash = 53 * hash + Objects.hashCode(this.cf);
        hash = 53 * hash + Objects.hashCode(this.livello);
        hash = 53 * hash + Objects.hashCode(this.nome);
        hash = 53 * hash + Objects.hashCode(this.cognome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Addetto other = (Addetto) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.tel, other.tel)) {
            return false;
        }
        if (!Objects.equals(this.cf, other.cf)) {
            return false;
        }
        if (!Objects.equals(this.livello, other.livello)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cognome, other.cognome)) {
            return false;
        }
        if (!Objects.equals(this.stipendio, other.stipendio)) {
            return false;
        }
        return true;
    }
  


   
   
}
