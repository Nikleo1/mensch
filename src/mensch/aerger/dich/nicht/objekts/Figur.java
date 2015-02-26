/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensch.aerger.dich.nicht.objekts;

/**
 *
 * @author Administrator
 */
public class Figur {
    int eigentuemer;
    Feld pos;

    public Figur(int eigentuemer, Feld pos) {
        this.eigentuemer = eigentuemer;
        this.pos = pos;
    }

    public int getEigentuemer() {
        return eigentuemer;
    }

    public void setEigentuemer(int eigentuemer) {
        this.eigentuemer = eigentuemer;
    }

    public Feld getPos() {
        return pos;
    }

    public void setPos(Feld pos) {
        this.pos = pos;
    }
    public boolean isOwn(){
        return pos.getNaechstes().getEigentuemer() == this.getEigentuemer();
    }
    public boolean kannInsHaus(){
        if(pos.getHaus() != null) {
            return pos.getHaus().getEigentuemer() == this.getEigentuemer();
        }else{
           return false;
        }
    }
    
    
    
}
