/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mensch.aerger.dich.nicht.objekts;

import java.awt.Color;

/**
 *
 * @author janneck
 */
public class Spieler {
    private int id;
    private Color farbe;

    public int getId() {
        return id;
    }

    public Color getFarbe() {
        return farbe;
    }

    public Spieler(int id, Color farbe) {
        this.id = id;
        this.farbe = farbe;
    }
   
    
    
    
}
