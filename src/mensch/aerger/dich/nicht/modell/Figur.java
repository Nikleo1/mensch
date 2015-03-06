/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensch.aerger.dich.nicht.modell;

import mensch.aerger.dich.nicht.MenschAergerDichNicht;

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
    public void insHaus(){
        Feld p = null;
        for(Feld f : MenschAergerDichNicht.getFenster().getSpielFeld().getHausFelder().get(this.getEigentuemer().getId())){
            if(!f.istBelegt() && p == null){
                p = f;
            }
        }
        this.bewegeAufFeld(p);
        
    }

    public void bewegeAufFeld(Feld pos) {
        if (pos != null) {
            this.getPos().leeren();
        }
        
        this.pos = pos;
        if(pos.istBelegt()){
            pos.getBelegt().insHaus();
        }
        pos.belege(this);
        MenschAergerDichNicht.getFenster().getGrafikmanager().getFigurenManager().updateSpieler();
    }

}
