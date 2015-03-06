/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensch.aerger.dich.nicht.modell;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import mensch.aerger.dich.nicht.MenschAergerDichNicht;

/**
 *
 * @author Administrator
 */
public class SpielerSpieler extends Spieler {
    
    public SpielerSpieler(int id, String name, Color farbe) {
        super(id, farbe);
        super.setName(name);
    }
    private boolean warteAufAuswahl = false;
    private boolean warteAufWuerfel = false;
    private int versuch = 1;
    
    public void wuerfele() {
        if (this.getStarter || this.warteAufWuerfel) {
            this.setLetzteZahl(MenschAergerDichNicht.getFenster().getSpielFeld().getWuerfel().werfe());
            System.out.println("D " + this.getLetzteZahl());
            
            if (this.getStarter) {
                this.getStarter = false;
                MenschAergerDichNicht.getSpielSteuerung().getStarter();
                
            } else {
                
                System.out.println("R " + this.getLetzteZahl());
                this.refreshMoeglichkeiten(this.getLetzteZahl());
                MenschAergerDichNicht.getFenster().getGrafikmanager().getMoeglichkeitenManager().clearAll();
                for (Moeglichkeit m : this.getMoeglichkeiten()) {
                    MenschAergerDichNicht.getFenster().getGrafikmanager().getMoeglichkeitenManager().addMoeglichkeit(m.getFeld().getPosition());
                }
                if (this.isVorhausVoll() && this.versuch < 3 && this.getMoeglichkeiten().isEmpty()) {
                    this.versuch++;
                    MenschAergerDichNicht.getFenster().setzeText("Bitte würfele erneut " + this.getName());
                } else {
                    if (!this.getMoeglichkeiten().isEmpty()) {
                        MenschAergerDichNicht.getFenster().setzeText("Bitte wähle eine der angezeigten Möglichkeiten ");
                        this.warteAufAuswahl = true;
                        this.warteAufWuerfel = false;
                    } else {
                        MenschAergerDichNicht.getSpielSteuerung().naechster();
                    }
                }
            }
        }
    }
    
    @Override
    public void istDran() {
        MenschAergerDichNicht.getFenster().setzeText("Spieler " + this.getName() + " ist dran");
        this.versuch = 1;
        // this.getFiguren().get(0).bewegeAufFeld(MenschAergerDichNicht.getFenster().getSpielFeld().getStartFelder().get(this.getId()));
        this.warteAufWuerfel = true;
        
    }
    
    public void klicke(int x, int y) {
        if (this.warteAufAuswahl) {
            
            for (Moeglichkeit m : this.getMoeglichkeiten()) {
                System.out.println("x " + m.getFeld().getPosition().getX() * MenschAergerDichNicht.getFenster().getScale() + " " + x + " " + (m.getFeld().getPosition().getX() + 1) * MenschAergerDichNicht.getFenster().getScale());
                System.out.println("y " + m.getFeld().getPosition().getY() * MenschAergerDichNicht.getFenster().getScale() + " " + y + " " + (m.getFeld().getPosition().getY() + 1) * MenschAergerDichNicht.getFenster().getScale());
                if ((m.getFeld().getPosition().getX() * MenschAergerDichNicht.getFenster().getScale() + 5) < x && ((m.getFeld().getPosition().getX() + 1) * MenschAergerDichNicht.getFenster().getScale() + 5) > x && (m.getFeld().getPosition().getY() * MenschAergerDichNicht.getFenster().getScale() + 30) < y && ((m.getFeld().getPosition().getY() + 1) * MenschAergerDichNicht.getFenster().getScale() + 30) > y) {
                    this.moeglichkeitGewaehlt(m);
                    if(this.hatGewonnen()){
                        JOptionPane.showMessageDialog(null, "Der Spieler " + this.getName()  + " hat gewonnen !");
                        MenschAergerDichNicht.getFenster().dispose();
                        System.exit(0);
                    }
                }
            }
        }
        
    }

    private void moeglichkeitGewaehlt(Moeglichkeit m) {
        MenschAergerDichNicht.getFenster().getGrafikmanager().getMoeglichkeitenManager().clearAll();
        m.getFigur().bewegeAufFeld(m.getFeld());
        this.warteAufAuswahl = false;
        if (this.getLetzteZahl() == 6) {
            this.versuch = 1;
            this.warteAufWuerfel = true;
        }else{
            MenschAergerDichNicht.getSpielSteuerung().naechster();
        }
    }
    
    @Override
    public void getStarter() {
        
    }
    
}
