/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensch.aerger.dich.nicht.modell;

import java.awt.Color;
import java.util.HashMap;
import java.util.List;
import mensch.aerger.dich.nicht.MenschAergerDichNicht;




/**
 *
 * @author janneck
 */
public class Spielfeld {

    private Wuerfel wuerfel;
    private int SpielerZahl;
    private HashMap<Integer, Feld> startFelder;
    private HashMap<Integer, List<Feld>> hausFelder;
    private HashMap<Integer, Spieler> spieler;

    public Spielfeld(Wuerfel w, int Spielerzahl) {
        startFelder = new HashMap<Integer, Feld>();
        hausFelder = new HashMap<Integer, List<Feld>>();
      
        spieler = new HashMap<Integer, Spieler>();
        wuerfel = w;
        this.SpielerZahl = Spielerzahl;
        this.baueAuf();
        this.zeichne();
    }

    public HashMap<Integer, Feld> getStartFelder() {
        return startFelder;
    }

    public HashMap<Integer, Spieler> getSpieler() {
        return spieler;
    }

    protected void baueAuf() {

    }

    public void zeichne() {
        Feld f1 = this.getStartFelder().get(1);
        Feld f2 = f1;
        Feld f3 = f1;
        // f1 = f1.getNaechstes();
        this.wuerfel.werfe();
        while (f2.getNaechstes() != f1) {

            Color c = Color.black;
            if (f2.getEigentuemer() != 0) {
                c = this.getSpieler().get(f2.getEigentuemer()).getFarbe();
            }

            MenschAergerDichNicht.getFenster().getGrafikmanager().getFeldManager().addFeld(f2.getPosition().getX(), f2.getPosition().getY(), c);

            f3 = f2;

            while (f3.getHaus() != null) {

                f3 = f3.getHaus();

                c = this.getSpieler().get(f3.getEigentuemer()).getFarbe();
               
                MenschAergerDichNicht.getFenster().getGrafikmanager().getFeldManager().addFeld(f3.getPosition().getX(), f3.getPosition().getY(), c);
                //f3 = f3.getHaus();

            }

            f2 = f2.getNaechstes();
        }

        Color c = Color.black;
        if (f2.getEigentuemer() != 0) {
            c = this.getSpieler().get(f2.getEigentuemer()).getFarbe();
        }
        MenschAergerDichNicht.getFenster().getGrafikmanager().getFeldManager().addFeld(f2.getPosition().getX(), f2.getPosition().getY(), c);
        f3 = f2;

        while (f3.getHaus() != null) {

            f3 = f3.getHaus();

            c = this.getSpieler().get(f3.getEigentuemer()).getFarbe();
            MenschAergerDichNicht.getFenster().getGrafikmanager().getFeldManager().addFeld(f3.getPosition().getX(), f3.getPosition().getY(), c);
                //f3 = f3.getHaus();

        }

        for (List<Feld> felder : this.getHausFelder().values()) {
            for (Feld f : felder) {
                c = this.getSpieler().get(f.getEigentuemer()).getFarbe();
                MenschAergerDichNicht.getFenster().getGrafikmanager().getFeldManager().addFeld(f.getPosition().getX(), f.getPosition().getY(), c);
            }
        }
        
        
        for(Spieler s: this.getSpieler().values()){
            for(Figur f : s.getFiguren()){
                MenschAergerDichNicht.getFenster().getGrafikmanager().getFigurenManager().addFigur(f);
            }
        }
    }

    public HashMap<Integer, List<Feld>> getHausFelder() {
        return hausFelder;
    }

    

    public Wuerfel getWuerfel() {
        return wuerfel;
    }


    public int getSpielerZahl() {
        return SpielerZahl;
    }

    public void setSpielerZahl(int SpielerZahl) {
        this.SpielerZahl = SpielerZahl;
    }

    
}
