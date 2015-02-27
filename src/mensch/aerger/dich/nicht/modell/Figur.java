/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensch.aerger.dich.nicht.modell;

/**
 *
 * @author Administrator
 */
public class Figur {
    Spieler eigentuemer;
    Feld pos;

    public Figur(Spieler eigentuemer, Feld pos) {
        this.eigentuemer = eigentuemer;
        this.pos = pos;
    }

    public Spieler getEigentuemer() {
        return eigentuemer;
    }

    public void setEigentuemer(Spieler eigentuemer) {
        this.eigentuemer = eigentuemer;
    }

    public Feld getPos() {
        return pos;
    }

    public void setPos(Feld pos) {
        this.pos = pos;
    }
    
   
    
    
    
}
