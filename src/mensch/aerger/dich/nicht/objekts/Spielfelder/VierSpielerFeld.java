/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensch.aerger.dich.nicht.objekts.Spielfelder;

import java.awt.Color;
import java.util.LinkedList;
import mensch.aerger.dich.nicht.objekts.Feld;
import mensch.aerger.dich.nicht.objekts.Position;
import mensch.aerger.dich.nicht.objekts.Spieler;
import mensch.aerger.dich.nicht.objekts.Spielfeld;
import mensch.aerger.dich.nicht.objekts.Wuerfel;
import mensch.aerger.dich.nicht.objekts.stat.FeldType;

/**
 *
 * @author Janneck
 */
public class VierSpielerFeld extends Spielfeld {

    public VierSpielerFeld() {
        super(new Wuerfel(6, 6), 4);
        
    }

    @Override
    protected void baueAuf() {
        this.getSpieler().put(1, new Spieler(1,Color.RED));
        this.getSpieler().put(2, new Spieler(2,Color.YELLOW));
        this.getSpieler().put(3, new Spieler(3,Color.GREEN));
        this.getSpieler().put(4, new Spieler(4,Color.BLUE));
        
        for(int i = 1; i<=  4 ; i++){
            this.getHausFelder().put(i, new LinkedList<Feld>());
        }
        int xPos = 1;
        int yPos = 5;
        int xPosH = xPos;
        int yPosH = yPos;
        int Spieler = 1;
        Feld f1;
        Feld f2;
        Feld f3;

        f1 = new Feld(new Position(xPos, yPos), FeldType.Start);
        f1.setEigentuemer(Spieler);
        this.getStartFelder().put(Spieler, f1);
        for (int i = 1; i <= 4; i++) {
            xPos++;
            f2 = new Feld(new Position(xPos, yPos), FeldType.NORMAL);
            f1.setNaechstes(f2);
            f1 = f2;
        }
        for (int i = 1; i <= 4; i++) {
            yPos--;
            f2 = new Feld(new Position(xPos, yPos), FeldType.NORMAL);
            f1.setNaechstes(f2);
            f1 = f2;
        }
        xPos++;
        f2 = new Feld(new Position(xPos, yPos), FeldType.NORMAL);
       
        f1.setNaechstes(f2);
        f1 = f2;
        
        yPosH = yPos;
        for (int i = 1; i <= 4; i++) {
            yPosH++;
            f3 = new Feld(new Position(xPos, yPosH), FeldType.HAUS);
            f3.setEigentuemer(Spieler + 1 );
            f2.setHaus(f3);
            f2 = f3;
        }
         xPos++;
      Spieler++;
        
        f2 = new Feld(new Position(xPos, yPos), FeldType.Start);
        f2.setEigentuemer(Spieler);
        f1.setNaechstes(f2);
        f1 = f2;
        this.getStartFelder().put(Spieler, f1);
        for (int i = 1; i <= 4; i++) {
            yPos++;
            f2 = new Feld(new Position(xPos, yPos), FeldType.NORMAL);
            f1.setNaechstes(f2);
            f1 = f2;
        }
        for (int i = 1; i <= 4; i++) {
            xPos++;
            f2 = new Feld(new Position(xPos, yPos), FeldType.NORMAL);
            f1.setNaechstes(f2);
            f1 = f2;
        }
        yPos++;
        f2 = new Feld(new Position(xPos, yPos), FeldType.NORMAL);
      
        f1.setNaechstes(f2);
        f1 = f2;
        xPosH = xPos;
        for (int i = 1; i <= 4; i++) {
            xPosH--;
            f3 = new Feld(new Position(xPosH, yPos), FeldType.HAUS);
            f3.setEigentuemer(Spieler+1);
            f2.setHaus(f3);
            f2 = f3;
        }
           yPos++;
        Spieler++;
        
        f2 = new Feld(new Position(xPos, yPos), FeldType.Start);
        f2.setEigentuemer(Spieler);
        f1.setNaechstes(f2);
        f1 = f2;
        this.getStartFelder().put(Spieler, f1);
        for (int i = 1; i <= 4; i++) {
            xPos--;
            f2 = new Feld(new Position(xPos, yPos), FeldType.NORMAL);
            f1.setNaechstes(f2);
            f1 = f2;
        }
        for (int i = 1; i <= 4; i++) {
            yPos++;
            f2 = new Feld(new Position(xPos, yPos), FeldType.NORMAL);
            f1.setNaechstes(f2);
            f1 = f2;
        }
        xPos--;
        f2 = new Feld(new Position(xPos, yPos), FeldType.NORMAL);
        f1.setNaechstes(f2);
        f1 = f2;
        
        yPosH = yPos;
        for (int i = 1; i <= 4; i++) {
            yPosH--;
            f3 = new Feld(new Position(xPos, yPosH), FeldType.HAUS);
            f3.setEigentuemer(Spieler + 1);
            f2.setHaus(f3);
            f2 = f3;
        }
       xPos--;
        Spieler++;
        
        f2 = new Feld(new Position(xPos, yPos), FeldType.Start);
        f2.setEigentuemer(Spieler);
        f1.setNaechstes(f2);
        f1 = f2;
        this.getStartFelder().put(Spieler, f1);
        for (int i = 1; i <= 4; i++) {
            yPos--;
            f2 = new Feld(new Position(xPos, yPos), FeldType.NORMAL);
            f1.setNaechstes(f2);
            f1 = f2;
        }
        for (int i = 1; i <= 4; i++) {
            xPos--;
            f2 = new Feld(new Position(xPos, yPos), FeldType.NORMAL);
            f1.setNaechstes(f2);
            f1 = f2;
        }
        yPos--;
        f2 = new Feld(new Position(xPos, yPos), FeldType.NORMAL);
        System.out.println(xPos + " " + yPos);
        
        f1.setNaechstes(f2);
        f1 = f2;
        xPosH = xPos;
        for (int i = 1; i <= 4; i++) {
            xPosH++;
            f3 = new Feld(new Position(xPosH, yPos), FeldType.HAUS);
            f3.setEigentuemer(1);
            f2.setHaus(f3);
            f2 = f3;
        }
        f1.setNaechstes(this.getStartFelder().get(1));
        
        
        
        Spieler = 1;
        for(int i1 = 0 ; i1 <2; i1++){
            for(int i2 = 0 ; i2 <2; i2++){
                f1 = new Feld(new Position(1 + i1, 1 + i2), FeldType.HAUS);
                f1.setEigentuemer(Spieler);
                this.getHausFelder().get(Spieler).add(f1);
               
            }
        }
        Spieler++;
        for(int i1 = 0 ; i1 <2; i1++){
            for(int i2 = 0 ; i2 <2; i2++){
                f1 = new Feld(new Position(10 + i1, 1 + i2), FeldType.HAUS);
                f1.setEigentuemer(Spieler);
                this.getHausFelder().get(Spieler).add(f1);
            }
        }
        Spieler++;
        for(int i1 = 0 ; i1 <2; i1++){
            for(int i2 = 0 ; i2 <2; i2++){
                f1 = new Feld(new Position(10 + i1, 10 + i2), FeldType.HAUS);
                f1.setEigentuemer(Spieler);
                this.getHausFelder().get(Spieler).add(f1);
            }
        }
        Spieler++;
        for(int i1 = 0 ; i1 <2; i1++){
            for(int i2 = 0 ; i2 <2; i2++){
                f1 = new Feld(new Position(1 + i1, 10 + i2), FeldType.HAUS);
                f1.setEigentuemer(Spieler);
                this.getHausFelder().get(Spieler).add(f1);
            }
        }

        
        }

    }
