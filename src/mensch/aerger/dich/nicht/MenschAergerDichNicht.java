/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mensch.aerger.dich.nicht;

import java.util.logging.Level;
import java.util.logging.Logger;
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

    public static void setFenster(MainGUI fenster) {
        MenschAergerDichNicht.fenster = fenster;
    }
   
    public static void main(String[] args) {

        MainGUI.main(args);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MenschAergerDichNicht.class.getName()).log(Level.SEVERE, null, ex);
        }
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
