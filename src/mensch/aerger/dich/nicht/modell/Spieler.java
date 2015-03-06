/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensch.aerger.dich.nicht.modell;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import mensch.aerger.dich.nicht.controll.Spielsteuerung;
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

    public Spieler(int id, Color farbe) {
        this.id = id;
        this.farbe = farbe;
        figuren = new LinkedList<Figur>();
    }
    public Spieler(){
        
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
    public boolean hatGewonnen(){
        boolean b = true;
        for(Figur F :this.getFiguren()){
            if(F.getPos().getType() != FeldType.HAUS){
                b = false;
            }
        }
        
        return b;
    }
    public boolean isVorhausLeer(){
        boolean b = true;
         for(Figur F :this.getFiguren()){
            if(F.getPos().getType() != FeldType.VORHAUS){
                b = false;
            }
        }
        return b;
    }
    public void istDran(){}
    public void getStarter(){}
        
    
    

}
