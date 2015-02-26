/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mensch.aerger.dich.nicht;

import mensch.aerger.dich.nicht.objekts.Wuerfel;

/**
 *
 * @author Administrator
 */
public class MenschAergerDichNicht {

    /**
     * @param args the command line arguments
     */
    private static MainGUI fenster;
   
    public static void main(String[] args) {

        fenster = new MainGUI();
        fenster.starte();
        fenster.setVisible(true);
        
    }

    public static MainGUI getFenster() {
        return fenster;
    }
    
}
