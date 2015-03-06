/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mensch.aerger.dich.nicht.view;

import java.awt.Color;
import java.awt.Dimension;
import java.util.logging.Level;
import java.util.logging.Logger;
import mensch.aerger.dich.nicht.MenschAergerDichNicht;
import mensch.aerger.dich.nicht.modell.Spielfelder.VierSpielerFeld;
import mensch.aerger.dich.nicht.view.Grafikmanager;
import mensch.aerger.dich.nicht.view.LinesComponent;

/**
 *
 * @author Administrator
 */
public class MainGUI extends javax.swing.JFrame {

    /**
     * Creates new form MainGUI
     */
    private LinesComponent comp;
    private Grafikmanager grafikManager;
    private int scale = 50;
   
    public MainGUI() {
        initComponents();

        comp = new LinesComponent();
        comp.setPreferredSize(new Dimension(1920, 1080));
         getContentPane().setBounds(0, 0, -1, -1);
      //  comp.addMouseListener(this);

        getContentPane().add(comp,  new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
// new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1)
        getContentPane().setBackground(Color.WHITE);

        this.setSize(new Dimension(1024, 785));
        grafikManager = new Grafikmanager(comp);
        setExtendedState(MAXIMIZED_BOTH);

    }
    private VierSpielerFeld spielFeld;
 public void sleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MainGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void starte() {
        //Wuerfel w = new Wuerfel(6,6);
        //w.werfe();
        spielFeld = new VierSpielerFeld();
    }
    
    public void setzeText(String text){
        this.jLabel1.setText(text);
    }

    public VierSpielerFeld getSpielFeld() {
        return spielFeld;
    }

    public Grafikmanager getGrafikmanager() {
        return grafikManager;
    }

    public int getScale() {
        return scale;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mensch ärgere Dich nicht");
        setBackground(new java.awt.Color(255, 0, 0));
        setForeground(java.awt.Color.white);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Wilkommen");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 340, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if(MenschAergerDichNicht.getSpielSteuerung()!= null){
            MenschAergerDichNicht.getSpielSteuerung().mausClick(evt);
        }
    }//GEN-LAST:event_formMouseClicked
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StartGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MenschAergerDichNicht.setFenster(new MainGUI());
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
