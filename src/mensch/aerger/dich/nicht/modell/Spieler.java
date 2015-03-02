/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensch.aerger.dich.nicht.modell;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author janneck
 */
public class Spieler {

    private int id;
    private Color farbe;
    private List<Figur> figuren;

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

    protected void istDran() {

    }

}
