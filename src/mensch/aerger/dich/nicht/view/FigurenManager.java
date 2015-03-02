/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensch.aerger.dich.nicht.view;

import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map.Entry;
import mensch.aerger.dich.nicht.MenschAergerDichNicht;
import mensch.aerger.dich.nicht.modell.Figur;



/**
 *
 * @author Janneck
 */
public class FigurenManager implements GrafikInterface {

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

    private final HashMap<Figur, FigurenManager.Circle> figuren = new HashMap<Figur, FigurenManager.Circle>();

    public void clearAll() {
        this.figuren.clear();
        MenschAergerDichNicht.getFenster().getGrafikmanager().getZeichner().repaint();
    }

    public void addFigur(Figur f) {

        figuren.put(f,
                new Circle(MenschAergerDichNicht.getFenster().getScale() * f.getPos().getPosition().getX()
                        + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.1),
                        MenschAergerDichNicht.getFenster().getScale() * f.getPos().getPosition().getY()
                        + (int) (MenschAergerDichNicht.getFenster().getScale() * 0.1),
                        (int) (MenschAergerDichNicht.getFenster().getScale() * 0.7),
                        true, f.getEigentuemer().getFarbe()));
        MenschAergerDichNicht.getFenster().getGrafikmanager().getZeichner().repaint();

    }

    public void updateSpieler() {
        for (Entry<Figur, Circle> s : figuren.entrySet()) {
            s.getValue().x = MenschAergerDichNicht.getFenster().getScale() * s.getKey().getPos().getPosition().getX();
            s.getValue().y = MenschAergerDichNicht.getFenster().getScale() * s.getKey().getPos().getPosition().getY();
        }
        MenschAergerDichNicht.getFenster().getGrafikmanager().getZeichner().repaint();
    }

    @Override
    public void repaint(Graphics g) {

        for (Circle c : figuren.values()) {
            g.setColor(c.color);
            g.fillOval(c.x, c.y, c.h, c.h);

        }
    }

}
