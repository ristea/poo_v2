/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;
import quizzapp.Game;

/**
 *
 * @author TabacAndreina
 */
public class MenuCard extends JPanel {
    
    private javax.swing.JButton pcButton;
    private javax.swing.JButton sdaButton;
    private javax.swing.JButton pooButton;
    private javax.swing.JButton cidButton;
    private javax.swing.JLabel helloLabel;
    private javax.swing.JLabel selectionLabel;
    private JLabel PressEnter;
    private Game game;

    public int width;
    public int height;
    
    public MenuCard(int _width,int _height)
     {
        width=_width;
        height=_height;
        initComponents();        
    }

    private void initComponents() 
     {
        startKeyboardListener();
        
        helloLabel = new javax.swing.JLabel();
        selectionLabel = new javax.swing.JLabel();
        PressEnter = new javax.swing.JLabel();
        pcButton = new javax.swing.JButton();
        sdaButton = new javax.swing.JButton();
        pooButton = new javax.swing.JButton();
        cidButton = new javax.swing.JButton(); 

        this.setLayout(null);

        helloLabel.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        helloLabel.setText("to the DCAE Quizz!");
        helloLabel.setLocation((width-205)/2,30*height/100);
        helloLabel.setSize(205,50);
         
        selectionLabel.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        selectionLabel.setText("Please select your discipline in order to get to work...");
        selectionLabel.setLocation((width-535)/2,5*height/10);
        selectionLabel.setSize(535,50);
        
        PressEnter.setFont(new java.awt.Font("Gill Sans MT", 0, 24));
        PressEnter.setText("Press Enter to start");
        PressEnter.setLocation((width-200)/2, 75*height/100);
        PressEnter.setSize(200,50);
        
        pcButton.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        pcButton.setText("PC");
        pcButton.setLocation((width-550)/2, 60*height/100);
        pcButton.setSize(100,50);
        
        sdaButton.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        sdaButton.setText("SDA");
        sdaButton.setLocation((width-250)/2, 60*height/100);
        sdaButton.setSize(100,50);
        
        pooButton.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        pooButton.setText("POO");
        pooButton.setLocation(sdaButton.getX()+150,  60*height/100);
        pooButton.setSize(100,50);
        
        cidButton.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        cidButton.setText("CID");
        cidButton.setLocation(pooButton.getX()+150,  60*height/100);
        cidButton.setSize(100,50);
      
        this.add(helloLabel);
        this.add(selectionLabel);
        this.add(PressEnter);
        this.add(pcButton);
        this.add(sdaButton);
        this.add(pooButton);
        this.add(cidButton);
    }
    
    public void setGame(Game _game)
    {
        game = _game;
    }
    
    private void startKeyboardListener() {   // aici trebuie modificat pentru tastele noastre     
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), "ENTER pressed");
        this.getActionMap().put("ENTER pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.startGame();
            }
        });
    }
}