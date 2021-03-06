/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensch.aerger.dich.nicht.modell;

import java.awt.Color;
import mensch.aerger.dich.nicht.MenschAergerDichNicht;

/**
 *
 * @author janneck
 */
public class Wuerfel {

    private int zahl;
    private int x, y;

    public Wuerfel(int x, int y) {
        this.x =  x * MenschAergerDichNicht.getFenster().getScale() ;
        this.y = y * MenschAergerDichNicht.getFenster().getScale();

    }

    public int werfe() {
        zahl = (int) (Math.random() * 6 + 1);
        this.zeichne();
        return zahl;
    }

    private void zeichne() {
        MenschAergerDichNicht.getFenster().getGrafikmanager().getWuerfelManager().clearAll();
        MenschAergerDichNicht.getFenster().getGrafikmanager().getWuerfelManager().addWuerfel(x, y, (int) MenschAergerDichNicht.getFenster().getScale() , (int) (MenschAergerDichNicht.getFenster().getScale() * 0.15), Color.BLACK);
        if (zahl == 1) {
            MenschAergerDichNicht.getFenster().getGrafikmanager().getWuerfelManager().addAuge(x + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.4), y + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.4));
        } else if (zahl == 2) {
            MenschAergerDichNicht.getFenster().getGrafikmanager().getWuerfelManager().addAuge(x + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.15), y + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.15));
            MenschAergerDichNicht.getFenster().getGrafikmanager().getWuerfelManager().addAuge(x + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.65), y + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.65));
        } else if (zahl == 3) {

            MenschAergerDichNicht.getFenster().getGrafikmanager().getWuerfelManager().addAuge(x + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.15), y + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.15));
            MenschAergerDichNicht.getFenster().getGrafikmanager().getWuerfelManager().addAuge(x + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.4), y + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.4));
            MenschAergerDichNicht.getFenster().getGrafikmanager().getWuerfelManager().addAuge(x + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.65), y + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.65));
        } else if (zahl == 4) {
            MenschAergerDichNicht.getFenster().getGrafikmanager().getWuerfelManager().addAuge(x + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.15), y + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.15));
            MenschAergerDichNicht.getFenster().getGrafikmanager().getWuerfelManager().addAuge(x + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.15), y + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.65));
            MenschAergerDichNicht.getFenster().getGrafikmanager().getWuerfelManager().addAuge(x + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.65), y + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.15));
            MenschAergerDichNicht.getFenster().getGrafikmanager().getWuerfelManager().addAuge(x + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.65), y + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.65));
        } else if (zahl == 5) {
            MenschAergerDichNicht.getFenster().getGrafikmanager().getWuerfelManager().addAuge(x + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.15), y + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.15));
            MenschAergerDichNicht.getFenster().getGrafikmanager().getWuerfelManager().addAuge(x + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.15), y + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.65));
            MenschAergerDichNicht.getFenster().getGrafikmanager().getWuerfelManager().addAuge(x + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.65), y + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.15));
            MenschAergerDichNicht.getFenster().getGrafikmanager().getWuerfelManager().addAuge(x + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.65), y + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.65));

            MenschAergerDichNicht.getFenster().getGrafikmanager().getWuerfelManager().addAuge(x + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.4), y + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.4));
        } else if (zahl == 6) {
            MenschAergerDichNicht.getFenster().getGrafikmanager().getWuerfelManager().addAuge(x + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.15), y + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.15));
            MenschAergerDichNicht.getFenster().getGrafikmanager().getWuerfelManager().addAuge(x + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.15), y + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.4));
            MenschAergerDichNicht.getFenster().getGrafikmanager().getWuerfelManager().addAuge(x + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.15), y + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.65));
            MenschAergerDichNicht.getFenster().getGrafikmanager().getWuerfelManager().addAuge(x + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.65), y + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.15));
            MenschAergerDichNicht.getFenster().getGrafikmanager().getWuerfelManager().addAuge(x + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.65), y + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.4));
            MenschAergerDichNicht.getFenster().getGrafikmanager().getWuerfelManager().addAuge(x + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.65), y + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.65));

        }

    }

    public int getX() {
        return x + 5;
    }

    public int getY() {
        return y + 30;
    }
    public int getXout() {
        return (x + MenschAergerDichNicht.getFenster().getScale() +10);
    }

    public int getYout() {
        return (y + MenschAergerDichNicht.getFenster().getScale() + 30);
    }
    

}
