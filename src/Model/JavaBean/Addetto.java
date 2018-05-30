/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.JavaBean;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Pirozzi
 */
public class Addetto {
    
   private double stipendio; // ("^[0-9]+?.[0-9]{2}$");
   private String email; /* IF((REGEXP_LIKE(EMAIL,'^[a-z0-9]{1}[a-z0-9._%-]{0,62}[a-z0-9_%-]{1}\@[a-z0-9]{1}[a-z0-9._%-]{1,252}\.[a-z]{2,4}$','i')) ) THEN
			SELECT REGEXP_SUBSTR(EMAIL,'[.]{2,}',1) INTO MULTIPLE_DOTS FROM DUAL; --Verifica se ci sono più punti consecutivi - esempio: mar.rossi@studenti..unina.it
			IF(MULTIPLE_DOTS IS NULL) THEN
				RETURN 1; -- l'email è corretta
			ELSE
				RAISE ERROR_DOTS;
			END IF;*/
   private String tel; // ("^(\+[0-9]{1,3}[/ ]{1})?[0-9]{3,6}[ -]?[0-9]{7,}$");
   private String cf; // ("^[a-z1-9]{16}$",Pattern.CASE_INSENSITIVE);
   private String nome; // ("^[a-z]+(['']?[a-z ]+)*$",Pattern.CASE_INSENSITIVE);
   private String cognome; // ("^[a-z]+(['' -]?[a-z ]+)*$",Pattern.CASE_INSENSITIVE);
   private String id; // ("[0-9]{6}$");
   private String password;
   private String username;
   private Date dnascita;

    public Date getDnascita() {
        return dnascita;
    }

    public void setDnascita(Date dnascita) {
        this.dnascita = dnascita;
    }

   
    public String getPassword() {
        
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

   public Addetto(String nome,String cogn,String cf,String email,String tel,Double stip,Date data,String id)
   {
       this.nome = nome;
       this.cognome = cogn;
       this.cf = cf;
       this.email = email;
       this.tel = tel;
       this.stipendio = stip;
       this.dnascita = data;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.stipendio);
        hash = 53 * hash + Objects.hashCode(this.email);
        hash = 53 * hash + Objects.hashCode(this.tel);
        hash = 53 * hash + Objects.hashCode(this.cf);
        hash = 53 * hash + Objects.hashCode(this.dnascita);
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
        if (!Objects.equals(this.dnascita, other.dnascita)) {
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
