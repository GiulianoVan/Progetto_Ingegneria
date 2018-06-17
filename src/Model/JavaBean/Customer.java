/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.JavaBean;

import java.util.Observable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Vincent
 */
public class Customer extends Observable{
    
    private String idCustomer; // ("[0-9]{6}$");
    private String username; // ("^[a-z]+(['']?[a-z ]+)*$",Pattern.CASE_INSENSITIVE); (uguale a name)
    private String name;     // ("^[a-z]+(['']?[a-z ]+)*$",Pattern.CASE_INSENSITIVE);
    private String surname; // ("^[a-z]+(['' -]?[a-z ]+)*$",Pattern.CASE_INSENSITIVE);
    private String email; /* IF( (REGEXP_LIKE(EMAIL,'^[a-z0-9]{1}[a-z0-9._%-]{0,62}[a-z0-9_%-]{1}\@[a-z0-9]{1}[a-z0-9._%-]{1,252}\.[a-z]{2,4}$','i')) ) THEN
			SELECT REGEXP_SUBSTR(EMAIL,'[.]{2,}',1) INTO MULTIPLE_DOTS FROM DUAL; --Verifica se ci sono più punti consecutivi - esempio: mar.rossi@studenti..unina.it
			IF(MULTIPLE_DOTS IS NULL) THEN
				RETURN 1; -- l'email è corretta
			ELSE
				RAISE ERROR_DOTS;
			END IF;*/
    private String tax_code; // ("^[a-z1-9]{16}$",Pattern.CASE_INSENSITIVE);
    private String phone; // ("^(\+[0-9]{1,3}[/ ]{1})?[0-9]{3,6}[ -]?[0-9]{7,}$");
    private Date date_born;
    private int tickets_purchased;
    
    /**
     *
     * @param idCustomer
     * @param username
     * @param name
     * @param surname
     * @param email
     * @param tax_code
     * @param phone
     * @param date_born
     */
    public Customer(String idCustomer,String username,String name,String surname,String email,String tax_code,String phone,Date date_born,int tickets)
    {
        this.idCustomer = idCustomer;
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.tax_code = tax_code;
        this.phone = phone;
        this.date_born = date_born;
        this.tickets_purchased = tickets;
    }

    /**
     * @return the idCustomer
     */
    public String getIdCustomer() {
        return idCustomer;
    }

    /**
     * @param idCustomer the idCustomer to set
     */
    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
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

    public Integer getTickets_purchased() {
        return tickets_purchased;
    }

    public void setTickets_purchased(int tickets_purchased) {
        this.tickets_purchased = tickets_purchased;
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
    
public void setValoreIdCustomer(String idCustomer) { //NOTIFICA AGLI OSSERVATORI(VIEW) IL VALORE DI idCustomer
    this.idCustomer = idCustomer;
    setChanged();
    notifyObservers(this.idCustomer);
    }

public void setValoreUsername(String username) { //NOTIFICA AGLI OSSERVATORI(VIEW) IL VALORE DI username
    this.username = username;
    setChanged();
    notifyObservers(this.username);
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
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.idCustomer);
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
        if (!Objects.equals(this.idCustomer, other.idCustomer)) {
            return false;
        }
        return true;
    }

    
}

    