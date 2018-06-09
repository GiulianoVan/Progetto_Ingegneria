/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.JavaBean;

import java.sql.Time;
import java.util.Set;

/**
 *
 * @author Pirozzi
 */
public class ManagementTurn {
    
    Addetto addetto;
    Event event;

    public Addetto getAddetto() {
        return addetto;
    }

    public void setAddetto(Addetto addetto) {
        this.addetto = addetto;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Time getStartTurn() {
        return startTurn;
    }

    public void setStartTurn(Time startTurn) {
        this.startTurn = startTurn;
    }

    public Time getEndTurn() {
        return endTurn;
    }

    public void setEndTurn(Time endTurn) {
        this.endTurn = endTurn;
    }
    Time startTurn;
    Time endTurn;
    
    public ManagementTurn(Addetto addetto,Event event,Time startTurn,Time endTurn)
    {
        this.addetto=addetto;
        this.event = event;
        this.startTurn = startTurn;
        this.endTurn = endTurn;
    }
    
}
