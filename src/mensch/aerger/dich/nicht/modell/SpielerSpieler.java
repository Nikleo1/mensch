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
import mensch.aerger.dich.nicht.MenschAergerDichNicht;

/**
 *
 * @author Administrator
 */
public class SpielerSpieler extends Spieler{

    public SpielerSpieler(int id,String name, Color farbe) {
        super(id, farbe);
        super.setName(name);
    }
    
    
    public List<Moeglichkeit> gibMoeglichkeiten(int Zahl){
        List<Moeglichkeit> felder = new LinkedList<Moeglichkeit>();
        for(Figur f : this.getFiguren()){
            Feld sf = f.getPos();
            for(int i = 0; i< Zahl;i++){
                if(sf.hatHaus() && sf.getHaus().getEigentuemer() == this.getId()){
                    sf = sf.getHaus();
                }else{
                    sf = sf.getNaechstes();
                }
            }
            if(sf.getBelegt().getEigentuemer() != this){
                felder.add(new Moeglichkeit(f,sf));
            }
        }
        
        return felder;
      
    }
    public void wuerfele(){
        this.setLetzteZahl(MenschAergerDichNicht.getFenster().getSpielFeld().getWuerfel().werfe());
        
        System.out.println("D "+ this.getLetzteZahl());
      
        MenschAergerDichNicht.getSpielSteuerung().getStarter();
       
    }
    

    @Override
    public void istDran() {
        
    }
    public void klicke(int x, int y){
        
    }

    @Override
    public void getStarter() {
       
    }

   
    
}
