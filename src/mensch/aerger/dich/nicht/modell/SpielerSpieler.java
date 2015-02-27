/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mensch.aerger.dich.nicht.modell;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class SpielerSpieler extends Spieler{
    
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
}
