/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensch.aerger.dich.nicht.modell;

import java.util.List;

/**
 *
 * @author Janna
 */
public abstract interface SpielTaktik {
    
    public List<Moeglichkeit> getPoints(List<Moeglichkeit> moeglichkeiten);
        
    
    
}
