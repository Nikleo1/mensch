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
        System.out.println("C " + this.getLetzteZahl());

        new Thread() {

            @Override
            public void run() {
                try {
                    Thread.sleep(MenschAergerDichNicht.getSleepTime());
                    MenschAergerDichNicht.getSpielSteuerung().getStarter();
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }

            }
        }.start();

    }

    @Override
    public void istDran() {
        if (!this.hatGewonnen()) {
            this.versuch = 1;
            MenschAergerDichNicht.getFenster().setzeText(this.getName() + " ist dran");
            final ComputerSpieler cS = this;
            new Thread() {

                @Override
                public void run() {
                    try {
                        cS.wuerfele();
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }

                }
            }.start();
        }else{
            
                MenschAergerDichNicht.getSpielSteuerung().naechster();
        }

    }

    public void wuerfele() throws InterruptedException {
        Thread.sleep(MenschAergerDichNicht.getSleepTime());
        this.setLetzteZahl(MenschAergerDichNicht.getFenster().getSpielFeld().getWuerfel().werfe());
        this.refreshMoeglichkeiten(this.getLetzteZahl());
        Thread.sleep(MenschAergerDichNicht.getSleepTime());
        this.waehleMoeglichkeit();
    }

    public void waehleMoeglichkeit() throws InterruptedException {
        if ((this.isVorhausVoll() || this.isHausAufegraumt()) && this.versuch < 3 && this.getMoeglichkeiten().isEmpty()) {
            this.versuch++;
            MenschAergerDichNicht.getFenster().setzeText("Bitte würfele erneut " + this.getName());
            this.wuerfele();

        } else {
            if (!this.getMoeglichkeiten().isEmpty()) {
                Moeglichkeit m = MenschAergerDichNicht.getSpielSteuerung().getTaktikManager().getMoeglichkeit(this.getMoeglichkeiten());
                m.getFigur().bewegeAufFeld(m.getFeld());
                if (this.getLetzteZahl() == 6) {
                    this.versuch = 1;
                    this.wuerfele();
                }else{
                    MenschAergerDichNicht.getSpielSteuerung().naechster();
                }
            } else {
                MenschAergerDichNicht.getSpielSteuerung().naechster();
            }
        }
    }

}
