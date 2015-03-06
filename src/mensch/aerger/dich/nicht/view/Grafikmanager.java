/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mensch.aerger.dich.nicht.view;

/**
 *
 * @author janneck
 */
public class Grafikmanager {
    private LinesComponent lc;
    private Wuerfelmanager wuerfelManager;
    private Feldmanager feldManager;
    private FigurenManager figurenManager;
    private MoeglichkeitenManager moeglichkeitenManager;

    public Grafikmanager(LinesComponent lc) {
        this.lc = lc;
        wuerfelManager = new Wuerfelmanager();
        feldManager = new Feldmanager();
        figurenManager = new FigurenManager();
        moeglichkeitenManager = new MoeglichkeitenManager();
        lc.addInterface(wuerfelManager);
        lc.addInterface(feldManager);
        lc.addInterface(figurenManager);
        lc.addInterface(moeglichkeitenManager);
    }

    public Wuerfelmanager getWuerfelManager() {
        return wuerfelManager;
    }

    public MoeglichkeitenManager getMoeglichkeitenManager() {
        return moeglichkeitenManager;
    }
    

    public Feldmanager getFeldManager() {
        return feldManager;
    }

    public LinesComponent getZeichner() {
        return lc;
    }

    public FigurenManager getFigurenManager() {
        return figurenManager;
    }
    
    
    
}
