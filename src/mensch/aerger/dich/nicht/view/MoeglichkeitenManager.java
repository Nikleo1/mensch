/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensch.aerger.dich.nicht.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import mensch.aerger.dich.nicht.MenschAergerDichNicht;
import mensch.aerger.dich.nicht.modell.Figur;
import mensch.aerger.dich.nicht.modell.Position;



/**
 *
 * @author Janneck
 */
public class MoeglichkeitenManager implements GrafikInterface {

    private static class Circle {

        final int h;
        int x;
        int y;
        final boolean filled;
        final Color color;

        public Circle(int x, int y, int h, boolean filled, Color color) {
            this.h = h;
            this.x = x;
            this.y = y;
            this.filled = filled;
            this.color = color;
        }
    }

    private final HashMap<Position, MoeglichkeitenManager.Circle> moeglichkeiten = new HashMap<Position, MoeglichkeitenManager.Circle>();

    public void clearAll() {
        this.moeglichkeiten.clear();
        MenschAergerDichNicht.getFenster().getGrafikmanager().getZeichner().repaint();
    }

    public void addMoeglichkeit(Position p, boolean schlagen) {
        System.out.println("Moeg");
        Color c;
        if (schlagen){
            c = Color.pink;
        }else{
            c = Color.cyan;
        }
        moeglichkeiten.put(p,
                new Circle(MenschAergerDichNicht.getFenster().getScale() * p.getX(),
                        MenschAergerDichNicht.getFenster().getScale() * p.getY(),
                        (int) (MenschAergerDichNicht.getFenster().getScale() * 0.9),
                        true, c));
        MenschAergerDichNicht.getFenster().getGrafikmanager().getZeichner().repaint();

    }

    

    @Override
    public void repaint(Graphics g) {

        for (Circle c : moeglichkeiten.values()) {
            g.setColor(c.color);
            g.fillOval(c.x, c.y, c.h, c.h);

        }
    }

}
