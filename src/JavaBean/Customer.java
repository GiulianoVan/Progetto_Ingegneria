/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBean;

import java.util.Observable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Vincent
 */
public class Customer extends Observable{
    
    private String username;
    private String password;
    private String name;
    private String surname;
    private String email;
    private String tax_code;
    private String phone;
    private Date date_born;
    
    /**
     *
     * @param username
     * @param password
     * @param name
     * @param surname
     * @param email
     * @param tax_code
     * @param phone
     * @param date_born
     */
    public Customer(String username,String password,String name,String surname,String email,String tax_code,String phone,Date date_born)
    {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.tax_code = tax_code;
        this.phone = phone;
        this.date_born = date_born;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }
    
    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
	
	/**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

	/**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

	/**
     * @return the tax_code
     */
    public String getTax_code() {
        return tax_code;
    }

    /**
     * @param tax_code the tax_code to set
     */
    public void setTax_code(String tax_code) {
        this.tax_code = tax_code;
    }

	/**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the date_born
     */
    public Date getDate_born() {
        return date_born;
    }
    /**
     * @param date_born the date_born to set
     */
    public void setDate_born(Date date_born) {
        this.date_born = date_born;
    }
    
public void setValoreUsername(String username) { //NOTIFICA AGLI OSSERVATORI(VIEW) IL VALORE DI username
    this.username = username;
    setChanged();
    notifyObservers(this.username);
    }
	
public void setValorePassword(String password) { //NOTIFICA AGLI OSSERVATORI(VIEW) IL VALORE DI password
    this.password = password;
    setChanged();
    notifyObservers(this.password);
    }
	
public void setValoreName(String name) { //NOTIFICA AGLI OSSERVATORI(VIEW) IL VALORE DI name
    this.name = name;
    setChanged();
    notifyObservers(this.name);
    }
	
public void setValoreSurname(String surname) { //NOTIFICA AGLI OSSERVATORI(VIEW) IL VALORE DI surname
    this.surname = surname;
    setChanged();
    notifyObservers(this.surname);
    }
	
public void setValoreEmail(String email) { //NOTIFICA AGLI OSSERVATORI(VIEW) IL VALORE DI email
    this.email = email;
    setChanged();
    notifyObservers(this.email);
    }
	
public void setValoreTax_code(String tax_code) { //NOTIFICA AGLI OSSERVATORI(VIEW) IL VALORE DI tax_code
    this.tax_code = tax_code;
    setChanged();
    notifyObservers(this.tax_code);
    }
	
public void setValorePhone(String phone) { //NOTIFICA AGLI OSSERVATORI(VIEW) IL VALORE DI phone
    this.phone = phone;
    setChanged();
    notifyObservers(this.phone);
    }
	
public void setValoreDate_born(Date date_born) { //NOTIFICA AGLI OSSERVATORI(VIEW) IL VALORE DI date_born
    this.date_born = date_born;
    setChanged();
    notifyObservers(this.date_born);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.username);
        hash = 41 * hash + Objects.hashCode(this.password);
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + Objects.hashCode(this.surname);
        hash = 41 * hash + Objects.hashCode(this.email);
        hash = 41 * hash + Objects.hashCode(this.tax_code);
        hash = 41 * hash + Objects.hashCode(this.phone);
        hash = 41 * hash + Objects.hashCode(this.date_born);
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
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.tax_code, other.tax_code)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        return Objects.equals(this.date_born, other.date_born);
    }

}

