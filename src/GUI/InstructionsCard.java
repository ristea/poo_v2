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

/**
 *
 * @author TabacAndreina
 */
public class InstructionsCard extends JPanel {
    
    private JButton enterButton;
    private JLabel titleLabel;
    private JLabel pressEnterLabel;
    private JLabel selectAnswerLabel;
    private JLabel selectLetter;
    private JLabel addScore;
    private JLabel pressEnterAgain;

    public int width;
    public int height;
    
    public InstructionsCard(int _width,int _height)
     {
        width=_width;
        height=_height;
        initComponents();        
    }

    private void initComponents() 
     {
        startKeyboardListener();
        
        titleLabel = new javax.swing.JLabel();
        pressEnterLabel = new javax.swing.JLabel();
        selectAnswerLabel = new javax.swing.JLabel();
        selectLetter = new javax.swing.JLabel();
        addScore = new javax.swing.JLabel();
        pressEnterAgain = new javax.swing.JLabel();
        enterButton = new javax.swing.JButton() ;

        this.setLayout(null);

        titleLabel.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        titleLabel.setText("to the DCAE Quizz!");
        titleLabel.setLocation((width-205)/2,30*height/100);
        titleLabel.setSize(205,50);
         
        pressEnterLabel.setFont(new java.awt.Font("Gill Sans MT", 0, 24)); // NOI18N
        pressEnterLabel.setText("Please select your discipline in order to get to work...");
        pressEnterLabel.setLocation((width-535)/2,5*height/10);
        pressEnterLabel.setSize(535,50);
        
        selectAnswerLabel.setFont(new java.awt.Font("Gill Sans MT", 0, 24));
        selectAnswerLabel.setText("Press Enter to start");
        selectAnswerLabel.setLocation((width-200)/2, 75*height/100);
        selectAnswerLabel.setSize(200,50);
        
        selectLetter.setFont(new java.awt.Font("Gill Sans MT", 0, 24));
        selectLetter.setText("Press Enter to start");
        selectLetter.setLocation((width-200)/2, 75*height/100);
        selectLetter.setSize(200,50);
        
        addScore.setFont(new java.awt.Font("Gill Sans MT", 0, 24));
        addScore.setText("Press Enter to start");
        addScore.setLocation((width-200)/2, 75*height/100);
        addScore.setSize(200,50);
        
        pressEnterAgain.setFont(new java.awt.Font("Gill Sans MT", 0, 24));
        pressEnterAgain.setText("Press Enter to start");
        pressEnterAgain.setLocation((width-200)/2, 75*height/100);
        pressEnterAgain.setSize(200,50);
        
        enterButton.setFont(new java.awt.Font("Gill Sans MT", 0, 24));
        enterButton.setText("Press Enter to start");
        enterButton.setLocation((width-200)/2, 75*height/100);
        enterButton.setSize(200,50);
        
        
      
        this.add(titleLabel);
        this.add(pressEnterLabel);
        this.add(selectAnswerLabel);
        this.add(selectLetter);
        this.add(addScore);
        this.add(pressEnterAgain);
        this.add(enterButton);
    }
    
    private void startKeyboardListener() {   // aici trebuie modificat pentru tastele noastre     
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), "ENTER pressed");
        this.getActionMap().put("ENTER pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //apeleaza functie pe game
            }
        });
    }
}