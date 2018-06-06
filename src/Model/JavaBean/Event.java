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
 * @author giuli
 */
public class Event {
    
    private String idEvent; // ("[0-9]{6}$");
    private String title;       // ("[a-z0-9,.;'"/-_#?!]+$",Pattern.CASE_INSENSITIVE);
    private String description; // ("[a-z0-9,.;'"/-_#?!]+$",Pattern.CASE_INSENSITIVE); (uguale a title)
    private String eventType;
    private String kindType;
    private Date dateEvent;
    private String zipCoce; // ("^[0-9]{3}[0-9xX]{2}$"));
    private String placeName; // ("^(([a-z]{1}[°]?)|([0-9]+[°]?))(([ '',."/-]{1}(([a-z]{1}[°]?)|([0-9]+[°]?)))*["'']?[,./-]?[a-z 0-9]+)*[.]?$",Pattern.CASE_INSENSITIVE);
    
    
    public Event(String idEvent,String title, String description, String typeEvent, String typeGender, Date dataEvent, String cap, String placeName)
    {
        this.idEvent = idEvent;
        this.title = title;
        this.description = description;
        this.eventType =  typeEvent;
        this.kindType = typeGender;
        this.dateEvent = dataEvent;
        this.zipCoce = cap;
        this.placeName = placeName;
    }

    public Event(String title, String description, String typeEvent, String typeGender, Date dataEvent, String placeName)
    {
        this.title = title;
        this.description = description;
        this.eventType =  typeEvent;
        this.kindType = typeGender;
        this.dateEvent = dataEvent;
        this.placeName = placeName;
    }
    
    public String getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(String idEvent) {
        this.idEvent = idEvent;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeEvent() {
        return eventType;
    }

    public void setTypeEvent(String typeEvent) {
        this.eventType = typeEvent;
    }

    public String getTypeGender() {
        return kindType;
    }

    public void setTypeGender(String typeGender) {
        this.kindType = typeGender;
    }

    public Date getDataEvent() {
        return dateEvent;
    }

    public void setDataEvent(Date dataEvent) {
        this.dateEvent = dataEvent;
    }

    public String getCap() {
        return zipCoce;
    }

    public void setCap(String cap) {
        this.zipCoce = cap;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.idEvent);
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
        final Event other = (Event) obj;
        if (!Objects.equals(this.idEvent, other.idEvent)) {
            return false;
        }
        return true;
    }
    
    
    
}
