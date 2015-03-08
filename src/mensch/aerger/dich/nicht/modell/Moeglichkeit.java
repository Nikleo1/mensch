/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mensch.aerger.dich.nicht.modell;

/**
 *
 * @author janneck
 */
public class Moeglichkeit {
    
    private Figur figur;
    private Feld feld;
    private int gewichtung;

    public Moeglichkeit(Figur figur, Feld feld) {
        this.figur = figur;
        this.feld = feld;
        this.gewichtung = 0;
    }

    public Figur getFigur() {
        return figur;
    }

    public Feld getFeld() {
        return feld;
    }

    public int getGewichtung() {
        return gewichtung;
    }

    public void addGewichtung(int gewichtung) {
        this.gewichtung = this.gewichtung + gewichtung;
    }

  
    
    
    
    
}
