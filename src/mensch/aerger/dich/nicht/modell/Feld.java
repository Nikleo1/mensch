/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensch.aerger.dich.nicht.modell;

/**
 *
 * @author Administrator
 */
public class Feld {

    Feld naechstes;
    Feld haus;
    Figur f;
    Position p;
    int eigentuemer;
    int Type;

    public Feld(Position p, int Type) {

        this.p = p;
        this.Type = Type;
        this.eigentuemer = 0;
    }
    public boolean istBelegt(){
        return f !=null;
    }
    public boolean hatHaus(){
        return (haus != null);
    }
    public void leeren(){
        f = null;
    }
    public Figur getBelegt(){
        return f;
    }
    public void belege(Figur f){
        this.f = f;
        
    }

    public Position getPosition() {
        return p;
    }

    public Feld getNaechstes() {
        return naechstes;
    }

    public void setNaechstes(Feld naechstes) {
        this.naechstes = naechstes;
    }

    public Feld getHaus() {
        return haus;
    }

    public void setHaus(Feld haus) {
        this.haus = haus;
    }

    public int getEigentuemer() {
        return eigentuemer;
    }

    public void setEigentuemer(int eigentuemer) {
        this.eigentuemer = eigentuemer;
    }

    public int getType() {
        return Type;
    }

    public void setType(int Type) {
        this.Type = Type;
    }
    

}
