/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaBean;

/**
 *
 * @author giuli
 */
public class Event {
    
    private String idEvent;
    private String title;
    private String description;
    private String typeEvent;
    private String typeGender;
    private String dataEvent;
    private String cap;
    private String placeName;
    
    
    public Event(String idEvent,String title, String description, String typeEvent, String typeGender, String dataEvent, String cap, String placeName)
    {
        this.idEvent = idEvent;
        this.title = title;
        this.description = description;
        this.typeEvent =  typeEvent;
        this.typeGender = typeGender;
        this.dataEvent = dataEvent;
        this.cap = cap;
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
        return typeEvent;
    }

    public void setTypeEvent(String typeEvent) {
        this.typeEvent = typeEvent;
    }

    public String getTypeGender() {
        return typeGender;
    }

    public void setTypeGender(String typeGender) {
        this.typeGender = typeGender;
    }

    public String getDataEvent() {
        return dataEvent;
    }

    public void setDataEvent(String dataEvent) {
        this.dataEvent = dataEvent;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
    
}
