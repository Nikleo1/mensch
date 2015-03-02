/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensch.aerger.dich.nicht.controll;

import java.awt.event.MouseEvent;
import java.util.List;
import mensch.aerger.dich.nicht.MenschAergerDichNicht;
import mensch.aerger.dich.nicht.modell.ComputerSpieler;
import mensch.aerger.dich.nicht.modell.SpielerInfo;
import mensch.aerger.dich.nicht.modell.SpielerSpieler;
import mensch.aerger.dich.nicht.modell.Spielfelder.VierSpielerFeld;

/**
 *
 * @author janneck
 */
public class Spielsteuerung {

    private VierSpielerFeld sf;
    private int istDran;
    private boolean wuerfelnKlicked = false;
    private boolean wuerfelFrei = false;

    public void starte(List<SpielerInfo> spielerInf) {
        MenschAergerDichNicht.setSpielSteuerung(this);
        istDran = 1;
        sf = MenschAergerDichNicht.getFenster().getSpielFeld();
        for (int i = 0; i < 4; i++) {
            if (spielerInf.get(i).isComputer()) {
                sf.getSpieler().put(i + 1, new ComputerSpieler(i + 1, sf.getSpieler().get(i + 1).getFarbe()));
            } else {
                sf.getSpieler().put(i + 1, new SpielerSpieler(i + 1, spielerInf.get(i).getName(), sf.getSpieler().get(i + 1).getFarbe()));
            }
        }
        MenschAergerDichNicht.getFenster().setVisible(true);
        this.getStarter();
    }

    public int getStarter() {
        this.wuerfelFrei = true;
        

        return 1;
    }

    public void mausClick(MouseEvent evt) {
        System.out.println(sf.getWuerfel().getX() + " " + evt.getX() + " " + sf.getWuerfel().getXout());
         System.out.println(sf.getWuerfel().getY() + " " + evt.getY() + " " + sf.getWuerfel().getYout());
         System.out.println("");
        if (this.wuerfelFrei && evt.getX() > sf.getWuerfel().getX()  && evt.getY() > sf.getWuerfel().getY()  && evt.getX() < sf.getWuerfel().getXout() && evt.getY()  < sf.getWuerfel().getYout() ) {
            sf.getWuerfel().werfe();
            
        }

    }

}
