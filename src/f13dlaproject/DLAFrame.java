/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package f13dlaproject;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import static f13dlaproject.Particle2D.*;
import static f13dlaproject.Crystal2D.*;

/**
 *
 * @author jiig
 */
public class DLAFrame extends javax.swing.JFrame {

    /**
     * delays time by 30 units.
     */
    public int timerDelay = 30;
    /**
     *
     */
    public static boolean autoZ = true;
    /**
     *
     */
    public static int cx, cy, dx, dy = 0;
    /**
     *
     */
    public static boolean paused = true;
    /**
     * tells whether to display the individual particles moving
     */
    public static volatile boolean display = true;
    /**
     * width of the panel
     */
    public static final int WIDTH = 600;
    /**
     * height of the panel
     */
    public static final int HEIGHT = 400;
    /**
     * holds time for the moveloop
     */
    public static long time = 0;
    /**
     * Thread for the moveloop
     */
    Thread t;

    /**
     * Creates new form DLAFrame
     */
    public DLAFrame() {
        initComponents();
        //Particle p = particle();
        t = new Thread(new Moveloop());

    }

    /**
     * Loop for multi-threaded display. Moves the particle every pass through
     * the loop. Hangs the thread at the interval to paint the screen.
     */
    public class Moveloop implements Runnable {

        @Override
        public void run() {
            try {
                while (!display) {
                    particle().setAngle();
                    particle().move();
                    time++;
                    if (time % Integer.parseInt(intervalfield.getText()) == 0) {
                        Thread.sleep(50);
                        repaint();
                    }
                    //System.out.println("HELLO");
                }
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public class MyPanel extends JPanel {

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            particle().draw(g);
            crystal2D().draw(g);
        }
    }
    /**
     * Measures the time.
     *
     * @param timerDelay delays clock by 30 units.
     * @param ActionListener the current time.
     */
    public Timer clock = new Timer(timerDelay, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            tick();
        }
    });

    /**
     * Repaints at each tick. Resets the particles launched and crystal size
     * text at each tick. Also repaints the window as particles move.
     */
    public void tick() {
        launchedLabel.setText("Particles Launched: " + Particle2D.particle().getLaunched());
        sizeLabel.setText("Crystal Size: " + Crystal2D.crystal2D().getSize());
        if (display) {
            particle().setAngle();
            //System.out.println("hello");
            particle().move();
            repaint();
        }
        zoomFactor.setValue((int) crystal2D().getZoom());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new MyPanel();
        sizeLabel = new javax.swing.JLabel();
        launchedLabel = new javax.swing.JLabel();
        afield = new javax.swing.JTextField();
        alabel = new javax.swing.JLabel();
        velocitylabel = new javax.swing.JLabel();
        velocityfield = new javax.swing.JTextField();
        clearButton = new javax.swing.JButton();
        startButton = new javax.swing.JButton();
        pauseButton = new javax.swing.JButton();
        displayCheck = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        intervalfield = new javax.swing.JTextField();
        zoomCheck = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        zoomFactor = new javax.swing.JSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        setResizable(true);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        jPanel1.setBackground(new java.awt.Color(254, 254, 254));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 400));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        sizeLabel.setText("Crystal Size: 0");

        launchedLabel.setText("Particles Launched: 0");

        afield.setText("0");
        afield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afieldActionPerformed(evt);
            }
        });

        alabel.setText("a:");

        velocitylabel.setText("Velocity:");

        velocityfield.setText("0.0");
        velocityfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                velocityfieldActionPerformed(evt);
            }
        });

        clearButton.setText("Clear");
        clearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButtonActionPerformed(evt);
            }
        });

        startButton.setText("Start");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        pauseButton.setText("Pause");
        pauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseButtonActionPerformed(evt);
            }
        });

        displayCheck.setText("Display Particle");
        displayCheck.setSelected(true);
        displayCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayCheckActionPerformed(evt);
            }
        });

        jLabel1.setText("Display Interval:");

        intervalfield.setText("100");
        intervalfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                intervalfieldActionPerformed(evt);
            }
        });

        zoomCheck.setSelected(true);
        zoomCheck.setText("Auto Zoom");
        zoomCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zoomCheckActionPerformed(evt);
            }
        });

        jLabel2.setText("Zoom Level: ");

        zoomFactor.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                zoomFactorStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(zoomCheck)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addComponent(zoomFactor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(displayCheck, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(pauseButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(startButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(clearButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(47, 47, 47)
                                    .addComponent(alabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(afield, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(7, 7, 7))
                                .addComponent(launchedLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(sizeLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(intervalfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(velocitylabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(velocityfield, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clearButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pauseButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(displayCheck)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(intervalfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(zoomCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(zoomFactor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(velocitylabel)
                    .addComponent(velocityfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(alabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(afield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(launchedLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sizeLabel)
                .addGap(114, 114, 114))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void afieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afieldActionPerformed
        Particle2D.particle().setA(Double.parseDouble(afield.getText()));
    }//GEN-LAST:event_afieldActionPerformed

    private void velocityfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_velocityfieldActionPerformed
        Particle2D.particle().setVelocity(Double.parseDouble(velocityfield.getText()));
    }//GEN-LAST:event_velocityfieldActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        clock.start();
        Particle2D.particle().setVelocity(Double.parseDouble(velocityfield.getText()));
        Particle2D.particle().setA(Double.parseDouble(afield.getText()));
        paused = false;
    }//GEN-LAST:event_startButtonActionPerformed

    private void pauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseButtonActionPerformed
        clock.stop();
        paused = true;
    }//GEN-LAST:event_pauseButtonActionPerformed

    private void displayCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_displayCheckActionPerformed
        display = displayCheck.isSelected();
        if (!display) {
            clock.start();
            if (!t.isAlive()) {
                t.start();
            }
        } else {
            t.interrupt();
        }
    }//GEN-LAST:event_displayCheckActionPerformed

    private void intervalfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_intervalfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_intervalfieldActionPerformed

    private void zoomCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zoomCheckActionPerformed
        // TODO add your handling code here:
        if (autoZ) {
            autoZ = false;
        } else {
            autoZ = true;
        }

    }//GEN-LAST:event_zoomCheckActionPerformed

    private void zoomFactorStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_zoomFactorStateChanged
        // TODO add your handling code here:
        if (!autoZ) {
            crystal2D().setZoom(zoomFactor.getValue());
        }
    }//GEN-LAST:event_zoomFactorStateChanged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        // TODO add your handling code here:
        cx = evt.getX();
        cy = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        // TODO add your handling code here:
        dx = (cx - evt.getX());
        dy = (cy - evt.getY());
        // System.out.println("huh?");
    }//GEN-LAST:event_jPanel1MouseDragged

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButtonActionPerformed
        // TODO add your handling code here:
        particle().clear();
        crystal2D().clear();
    }//GEN-LAST:event_clearButtonActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(DLAFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DLAFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DLAFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DLAFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DLAFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField afield;
    private javax.swing.JLabel alabel;
    private javax.swing.JButton clearButton;
    private javax.swing.JCheckBox displayCheck;
    private javax.swing.JTextField intervalfield;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel launchedLabel;
    private javax.swing.JButton pauseButton;
    private javax.swing.JLabel sizeLabel;
    private javax.swing.JButton startButton;
    private javax.swing.JTextField velocityfield;
    private javax.swing.JLabel velocitylabel;
    private javax.swing.JCheckBox zoomCheck;
    private javax.swing.JSlider zoomFactor;
    // End of variables declaration//GEN-END:variables
}
