/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensch.aerger.dich.nicht.modell;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import mensch.aerger.dich.nicht.MenschAergerDichNicht;

/**
 *
 * @author Administrator
 */
public class ComputerSpieler extends Spieler {

    public ComputerSpieler(int id, Color farbe) {
        super(id, farbe);
        super.setName("Computer" + id);
    }

    @Override
    public void getStarter() {
        
            this.setLetzteZahl(MenschAergerDichNicht.getFenster().getSpielFeld().getWuerfel().werfe());
            System.out.println("C "+ this.getLetzteZahl());
            
            
            new Thread() {

                @Override
                public void run() {
                    try {
                        Thread.sleep(1500);
                        MenschAergerDichNicht.getSpielSteuerung().getStarter();
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }

                }
            }.start();
       

    }

}
