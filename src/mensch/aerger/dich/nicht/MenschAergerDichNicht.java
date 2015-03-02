/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mensch.aerger.dich.nicht;

import mensch.aerger.dich.nicht.view.StartGui;
import mensch.aerger.dich.nicht.view.MainGUI;
import mensch.aerger.dich.nicht.controll.Spielsteuerung;

/**
 *
 * @author Administrator
 */
public class MenschAergerDichNicht {

    /**
     * @param args the command line arguments
     */
    private static MainGUI fenster;
    private static Spielsteuerung spielSteuerung;
   
    public static void main(String[] args) {

        fenster = new MainGUI();
        fenster.starte();
        StartGui.main(args);
        
        
    }

    public static Spielsteuerung getSpielSteuerung() {
        return spielSteuerung;
    }

    public static void setSpielSteuerung(Spielsteuerung spielSteuerung) {
        MenschAergerDichNicht.spielSteuerung = spielSteuerung;
    }

    
    public static MainGUI getFenster() {
        return fenster;
    }
    
}
