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
import java.awt.Graphics;
import java.util.LinkedList;


import javax.swing.JComponent;

public class LinesComponent extends JComponent {
    private LinkedList<GrafikInterface> interfaces;

    public LinesComponent() {
        interfaces = new LinkedList<GrafikInterface>();
    }
    public void addInterface(GrafikInterface g){
        this.interfaces.add(g);
    }
    public void removeInterface(GrafikInterface g){
        this.interfaces.remove(g);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(GrafikInterface gI : interfaces){
            gI.repaint(g);
        }
       
    }

}
