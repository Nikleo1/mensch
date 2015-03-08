/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensch.aerger.dich.nicht.modell;

import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import mensch.aerger.dich.nicht.MenschAergerDichNicht;
import mensch.aerger.dich.nicht.modell.stat.FeldType;

/**
 *
 * @author janneck
 */
public class Spieler {

    private int id;
    private Color farbe;
    private List<Figur> figuren;
    private int letzteZahl;
    private String name;
    public boolean getStarter = true;
    private List<Moeglichkeit> moeglichkeiten;
    public boolean istFertig;
    public int versuch = 1;

    public Spieler(int id, Color farbe) {
        this.istFertig = false;
        this.id = id;
        this.farbe = farbe;
        figuren = new LinkedList<Figur>();
    }

    public boolean istFertig() {
        return istFertig;
    }

    public void setFertig() {
        this.istFertig = true;
    }

    public Spieler() {

    }

    public List<Moeglichkeit> getMoeglichkeiten() {
        return moeglichkeiten;
    }

    public String getName() {
        return name;
    }

    public int getLetzteZahl() {
        return letzteZahl;
    }

    public void setLetzteZahl(int letzteZahl) {
        this.letzteZahl = letzteZahl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public Color getFarbe() {
        return farbe;
    }

    public List<Figur> getFiguren() {
        return figuren;
    }

    public boolean hatGewonnen() {
        boolean b = true;
        for (Figur F : this.getFiguren()) {
            if (F.getPos().getType() != FeldType.HAUS) {
                b = false;
            }
        }

        return b;
    }

    public boolean isVorhausLeer() {
        boolean b = true;
        for (Figur F : this.getFiguren()) {
            if (F.getPos().getType() == FeldType.VORHAUS) {
                b = false;
            }
        }
        return b;
    }

    public boolean isVorhausVoll() {
        boolean b = true;
        for (Figur F : this.getFiguren()) {
            if (F.getPos().getType() != FeldType.VORHAUS) {
                b = false;
            }
        }
        return b;
    }
    public boolean isHausAufegraumt(){
        boolean b = true;
        int nr = 5;
        Feld feld = null;
        for (Figur f : this.getFiguren()) {
            if(!(f.getPos().getType() == FeldType.HAUS || f.getPos().getType() == FeldType.VORHAUS)){
                b = false;
            }
            if(f.getPos().getType() == FeldType.HAUS && f.getPos().getNummer() < nr){
                nr = f.getPos().getNummer();
                feld = f.getPos();
            }
        }
        if(nr != 5){
            while(feld.hatHaus()){
                if(!feld.getHaus().istBelegt()){
                    b = false;
                }
                feld = feld.getHaus();
            }
        }
        
        return b;
    }

    public void refreshMoeglichkeiten(int Zahl) {
        LinkedList<Moeglichkeit> felder = new LinkedList<Moeglichkeit>();
        for (Figur f : this.getFiguren()) {
            Feld sf = f.getPos();
            if (Zahl == 6 && sf.getType() == FeldType.VORHAUS && (MenschAergerDichNicht.getFenster().getSpielFeld().getStartFelder().get(this.getId()).istBelegt() == false || MenschAergerDichNicht.getFenster().getSpielFeld().getStartFelder().get(this.getId()).getBelegt().getEigentuemer().getId() != this.getId())) {
                boolean mFrei = true;
                for (Moeglichkeit vgl : felder) {
                    if (vgl.getFeld().getPosition().getX() == MenschAergerDichNicht.getFenster().getSpielFeld().getStartFelder().get(this.getId()).getPosition().getX()) {
                        if (vgl.getFeld().getPosition().getY() == MenschAergerDichNicht.getFenster().getSpielFeld().getStartFelder().get(this.getId()).getPosition().getY()) {
                            mFrei = false;
                        }
                    }
                }
                if (mFrei) {
                    felder.add(new Moeglichkeit(f, MenschAergerDichNicht.getFenster().getSpielFeld().getStartFelder().get(this.getId())));
                }
            } else {
                boolean loesung = true;
                for (int i = 0; i < Zahl; i++) {
                    
                    if (sf.getNaechstes() != null || sf.getHaus() != null) {
                        if (sf.hatHaus() && sf.getHaus().getEigentuemer() == this.getId()) {
                            sf = sf.getHaus();
                            if (sf.istBelegt()){
                                loesung = false;
                            }
                        } else {
                            sf = sf.getNaechstes();
                        }
                        
                    }else if(Zahl == (i + 1)){
                        loesung = false;
                    }
                }
                if ((!sf.istBelegt() ||  sf.getBelegt().getEigentuemer().getId() != this.getId()) && sf.getType() != FeldType.VORHAUS && loesung) {
                    felder.add(new Moeglichkeit(f, sf));
                }
            }

        }

        this.moeglichkeiten = felder;

    }

    public void setFiguren(List<Figur> figuren) {
        this.figuren = figuren;
    }

    public void istDran() {
    }

    public void getStarter() {
    }

}
