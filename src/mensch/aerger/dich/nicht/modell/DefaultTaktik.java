/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensch.aerger.dich.nicht.modell;

import java.util.List;
import mensch.aerger.dich.nicht.modell.stat.FeldType;

/**
 *
 * @author Janna
 */
public class DefaultTaktik implements SpielTaktik{

    @Override
    public List<Moeglichkeit> getPoints(List<Moeglichkeit> moeglichkeiten) {
        for(Moeglichkeit m: moeglichkeiten){
            
            //wenn näher als 10 am haus
            if(m.getFigur().entfernungZumHaus() < 10){
                m.addGewichtung(1);
            }else if (m.getFigur().entfernungZumHaus() < 10){
                m.addGewichtung(7);
            }
            //im Haus aufrücken
            if(m.getFigur().getPos().getType() == FeldType.HAUS && m.getFeld().getType() == FeldType.HAUS){
                m.addGewichtung(2);
            }
            //ins Haus ziehen
            if(m.getFigur().getPos().getType() != FeldType.HAUS && m.getFeld().getType() == FeldType.HAUS){
                m.addGewichtung(3);
            }
            //Start räumen
            if(m.getFigur().getPos().getEigentuemer() == m.getFigur().getEigentuemer().getId() && m.getFigur().getPos().getType() == FeldType.Start){
                m.addGewichtung(4);
            }
            //Schlagen
            if(m.getFeld().istBelegt()){
                m.addGewichtung(5);
            }
            //Aus Vorhaus raus
            if(m.getFigur().getPos().getType() == FeldType.VORHAUS){
                m.addGewichtung(6);
            }
        }
        return moeglichkeiten;
    }
    
}
