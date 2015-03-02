/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensch.aerger.dich.nicht.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import mensch.aerger.dich.nicht.MenschAergerDichNicht;




/**
 *
 * @author Janneck
 */
public class Wuerfelmanager implements GrafikInterface {

    
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

    private static class RoundedRect {

        final int x;
        final int y;
        final int width;
        final int heigh;
        final int round;
        final Color color;

        public RoundedRect(int x, int y, int width, int heigh, int round, Color color) {

            this.x = x;
            this.y = y;
            this.heigh = heigh;
            this.width = width;
            this.round = round;
            this.color = color;
        }
    }
    private final LinkedList<Wuerfelmanager.Circle> circles = new LinkedList<Wuerfelmanager.Circle>();
    private final LinkedList<Wuerfelmanager.RoundedRect> rr = new LinkedList<Wuerfelmanager.RoundedRect>();
    public void clearAll(){
        this.circles.clear();
        this.rr.clear();
        MenschAergerDichNicht.getFenster().getGrafikmanager().getZeichner().repaint();
    }
    public void addWuerfel(int x, int y, int h, int round, Color color) {
        rr.add(new RoundedRect(x, y, h, h, round, color));
        MenschAergerDichNicht.getFenster().getGrafikmanager().getZeichner().repaint();

    }
     public void addAuge(int x, int y) {
        circles.add(new Circle(x, y, (int)(MenschAergerDichNicht.getFenster().getScale() * 0.2), true, Color.BLACK));
        MenschAergerDichNicht.getFenster().getGrafikmanager().getZeichner().repaint();

    }

    @Override
    public void repaint(Graphics g) {
        for (RoundedRect r : rr) {
            g.setColor(r.color);
            g.drawRoundRect(r.x, r.y, r.width, r.heigh, r.round, r.round);
            

        }
        for (Circle c : circles) {
            g.setColor(c.color);
            g.fillOval(c.x, c.y, c.h, c.h);

        }
    }

}
