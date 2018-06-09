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
