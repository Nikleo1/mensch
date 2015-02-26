/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensch.aerger.dich.nicht.grafik;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import mensch.aerger.dich.nicht.MenschAergerDichNicht;

/**
 *
 * @author Janneck
 */
public class Feldmanager implements GrafikInterface {

    
    private static class Circle {

        final int h;
        final int x;
        final int y;
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


    private final LinkedList<Feldmanager.Circle> circles = new LinkedList<Feldmanager.Circle>();
    
    public void clearAll(){
        this.circles.clear();
        MenschAergerDichNicht.getFenster().getGrafikmanager().getZeichner().repaint();
    }
 
     public void addFeld(int x, int y, Color c) {
        
        circles.add(new Circle(MenschAergerDichNicht.getFenster().getScale()*x, MenschAergerDichNicht.getFenster().getScale()*y, (int)(MenschAergerDichNicht.getFenster().getScale()*0.9), true, c));
        MenschAergerDichNicht.getFenster().getGrafikmanager().getZeichner().repaint();

    }

    @Override
    public void repaint(Graphics g) {
        
        for (Circle c : circles) {
            g.setColor(c.color);
            g.fillOval(c.x, c.y, c.h, c.h);

        }
    }

}
