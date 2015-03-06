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
import mensch.aerger.dich.nicht.modell.Figur;
import mensch.aerger.dich.nicht.modell.Spieler;
import mensch.aerger.dich.nicht.modell.SpielerInfo;
import mensch.aerger.dich.nicht.modell.SpielerSpieler;
import mensch.aerger.dich.nicht.modell.Spielfelder.VierSpielerFeld;

/**
 *
 * @author janneck
 */
public class Spielsteuerung implements Runnable {

    private VierSpielerFeld sf;
    private int istDran;
    private boolean getStarter;

    private boolean starter = true;

    public void starte(List<SpielerInfo> spielerInf) {
        MenschAergerDichNicht.setSpielSteuerung(this);
        istDran = 0;
        sf = MenschAergerDichNicht.getFenster().getSpielFeld();
        for (int i = 1; i <= 4; i++) {
            List<Figur> fig = sf.getSpieler().get(i).getFiguren();
            Spieler s;
            if (spielerInf.get(i - 1).isComputer()) {
               s = new ComputerSpieler(i, sf.getSpieler().get(i).getFarbe());
                // sf.getSpieler().put(i, new ComputerSpieler(i, sf.getSpieler().get(i).getFarbe()));
            } else {
                s = new SpielerSpieler(i, spielerInf.get(i - 1).getName(), sf.getSpieler().get(i).getFarbe());
            }
            s.setFiguren(fig);
            sf.getSpieler().put(i, s);
        }
        System.out.println(sf.getSpieler().size());
        getStarter = true;
    }

    public void getStarter() {
        if (this.istDran < sf.getSpielerZahl()) {
            this.istDran++;

            MenschAergerDichNicht.getFenster().setzeText("Bitte würfele " + sf.getSpieler().get(this.istDran).getName());
            MenschAergerDichNicht.getFenster().repaint();

            sf.getSpieler().get(istDran).getStarter();

        } else {
            this.istDran = 0;
            getStarter = false;
            this.starteSpiel();
        }

    }

    public void starteSpiel() {
       // MenschAergerDichNicht.getFenster().setzeText("START");
        int startSpieler = 0;
        int zahl = 0;
        for(Spieler s : sf.getSpieler().values()){
            if(s.getLetzteZahl() > zahl){
                zahl = s.getLetzteZahl();
                startSpieler = s.getId();
            }
        }
        MenschAergerDichNicht.getFenster().setzeText("Spieler " + sf.getSpieler().get(startSpieler).getName() + " beginnt");
        this.istDran = startSpieler;
        
         sf.getSpieler().get(this.istDran).istDran();
    }
    public void naechster(){
        if(this.istDran < 4){
            this.istDran++;
        }else{
            this.istDran = 1;
        }
         sf.getSpieler().get(this.istDran).istDran();
    }
    

    public void mausClick(MouseEvent evt) {

        if (evt.getX() > sf.getWuerfel().getX() && evt.getY() > sf.getWuerfel().getY() && evt.getX() < sf.getWuerfel().getXout() && evt.getY() < sf.getWuerfel().getYout()) {
            if (sf.getSpieler().get(this.istDran) instanceof SpielerSpieler) {
                ((SpielerSpieler) sf.getSpieler().get(this.istDran)).wuerfele();
            }

        } else if (sf.getSpieler().get(this.istDran) instanceof SpielerSpieler) {
            
            ((SpielerSpieler) sf.getSpieler().get(this.istDran)).klicke(evt.getX(), evt.getY());
        }

    }

    @Override
    public void run() {
        MenschAergerDichNicht.getFenster().setVisible(true);
        this.getStarter();

    }

}
