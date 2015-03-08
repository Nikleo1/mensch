/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensch.aerger.dich.nicht.controll;

import java.util.LinkedList;
import java.util.List;
import mensch.aerger.dich.nicht.modell.Moeglichkeit;
import mensch.aerger.dich.nicht.modell.SpielTaktik;

/**
 *
 * @author Janna
 */
public class TaktikManager {
     private LinkedList<SpielTaktik> interfaces;

    public TaktikManager() {
        interfaces = new LinkedList<SpielTaktik>();
    }
    public void addInterface(SpielTaktik s){
        this.interfaces.add(s);
    }
    public void removeInterface(SpielTaktik s){
        this.interfaces.remove(s);
    }
    
    public Moeglichkeit getMoeglichkeit(List<Moeglichkeit> moeglichkeiten) {
        for(SpielTaktik sT : interfaces){
            sT.getPoints(moeglichkeiten);
        }
        List<Moeglichkeit> fertig = new LinkedList<Moeglichkeit>();
        Moeglichkeit moeg = null;
        int points = 0;
        for(Moeglichkeit m : moeglichkeiten){
            if(m.getGewichtung() > points){
                points = m.getGewichtung();                 
                moeg = m;
                fertig.clear();
                fertig.add(m);
            }else if(m.getGewichtung() == points){
                fertig.add(m);
            }
        }
        return fertig.get((int) (Math.random() * fertig.size()));
       
    }
    
}
