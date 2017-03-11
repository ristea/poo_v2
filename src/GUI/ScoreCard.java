/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;
import java.util.LinkedList;
import quizzapp.Game;

/**
 *
 * @author TabacAndreina
 */
public class ScoreCard extends JPanel{
    
    private javax.swing.JButton addScoreButton;
    private javax.swing.JLabel skillLabel;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JLabel scoreLabel2;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JLabel isNOT_top10Label;
    private javax.swing.JLabel is_top10Label;
    private javax.swing.JLabel top10Label;
    private javax.swing.JLabel letterLabel;
    private JTextField addNameTextField;
    private javax.swing.JScrollPane scoreScrollPane;
    private javax.swing.JTextArea scoreTextArea;
    
    private Game game;
    
    private static String playerName="";    
    private LinkedList<String> KeyList = new LinkedList<>();

    public int width;
    public int height;
    
     public ScoreCard(int _width,int _height)
     {
        width=_width;
        height=_height;
        initComponents();        
    }

     public void showScoreTable(String scoreTable)
     {
         scoreTextArea.setText(scoreTable);
     }
     
     public void setDefaultLabels() //seteaza labelurile care se schimba not visible
     {
        is_top10Label.setVisible(false);
        nameLabel.setVisible(false);
        scoreLabel2.setVisible(false);
        addScoreButton.setVisible(false);
        addNameTextField.setVisible(false);
        scoreLabel.setVisible(false);
        isNOT_top10Label.setVisible(false);
     }
    
    //funcite pt scor->tot ce tine de scor intra aici
     
     public void setPlayerScore(float score) //reseteaza labelurile not visible si schimba scorul
     {
         setDefaultLabels();                                      //intai se trimite scorul,apoi isTop
         
         if(score<50){
            skillLabel.setText("O-OH!You didn't pass.");
            skillLabel.setLocation((3*width/5-550)/2,height/4);
            skillLabel.setSize(550,60);
        }else if(score<70){
            skillLabel.setText("Your score is ok...");
            skillLabel.setLocation((3*width/5-430)/2,height/4);
            skillLabel.setSize(430,60);
        }else if(score<90){
            skillLabel.setText("Good job!");
            skillLabel.setLocation((3*width/5-240)/2,height/4);
            skillLabel.setSize(240,60);
        }else{
            skillLabel.setText("Congratulations!You rock!");
            skillLabel.setLocation((3*width/5-630)/2,height/4);
            skillLabel.setSize(630,60);
        }
         scoreLabel.setText("Your score is : " + score);
         scoreLabel2.setText("Your score is : " + score);
     }
     
     public void setTopPlayerScreen(boolean isTop)  //face asezarea in ecran in functie de tipul de winner
     {
         if(isTop==true)
         {
            is_top10Label.setVisible(true);
            nameLabel.setVisible(true);
            scoreLabel2.setVisible(true);
            addScoreButton.setVisible(true);
            addNameTextField.setVisible(true);
         }else
         {
            scoreLabel.setVisible(true);
            isNOT_top10Label.setVisible(true);
         }
         
     }
     
     public void setGame(Game _game)
    {
        game = _game;
    }
     
     private void initComponents()
     {
        addKeysToKeyList();
        startKeyboardListener();
        
        letterLabel = new javax.swing.JLabel();        
        skillLabel = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();
        scoreLabel2 = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        isNOT_top10Label = new javax.swing.JLabel();
        is_top10Label = new javax.swing.JLabel();
        top10Label = new javax.swing.JLabel();
        addScoreButton = new javax.swing.JButton();
        addNameTextField = new JTextField();
        scoreScrollPane = new javax.swing.JScrollPane();
        scoreTextArea = new javax.swing.JTextArea();
        
        this.setLayout(null);
        
        letterLabel.setOpaque(true);
        letterLabel.setBackground(new Color(100,200,100));
        letterLabel.setFont(new java.awt.Font("Gill Sans MT", 0, 50));
        letterLabel.setText(KeyList.getFirst());
        letterLabel.setLocation(width*17/100, 9*height/12);
        letterLabel.setSize(37,50);
        
        scoreTextArea.setEditable(false);
        scoreTextArea.setColumns(20);
        scoreTextArea.setRows(5);
        scoreScrollPane.setViewportView(scoreTextArea);
        scoreScrollPane.setLocation(3*width/5, (height-500)/2);
        scoreScrollPane.setSize(400,500);
        
        skillLabel.setFont(new java.awt.Font("Gill Sans MT", 1, 50));
       
        scoreLabel.setFont(new java.awt.Font("Gill Sans MT", 0, 40));
        scoreLabel.setLocation((3*width/5-380)/2, 3*height/5);
        scoreLabel.setSize(380,50);
        
        isNOT_top10Label.setFont(new java.awt.Font("Gill Sans MT", 0, 25));
        isNOT_top10Label.setText("You didn't make it in the top 10");
        isNOT_top10Label.setLocation((3*width/5-330)/2, 3*height/9);
        isNOT_top10Label.setSize(330,50);
        
        top10Label.setFont(new java.awt.Font("Gill Sans MT", 1, 30)); 
        top10Label.setText("TOP 10");
        top10Label.setLocation((3*width/5), height/10);
        top10Label.setSize(120,50);
    
        //if( isTop==true)
            is_top10Label.setFont(new java.awt.Font("Gill Sans MT", 0, 25));
            is_top10Label.setText("You made it in the top 10");
            is_top10Label.setLocation((3*width/5-270)/2, 3*height/9);     
            is_top10Label.setSize(270,50);
           
            nameLabel.setFont(new java.awt.Font("Gill Sans MT", 0, 35)); 
            nameLabel.setText("Your name : ");
            nameLabel.setLocation((3*width/5-500)/2, 9*height/14 );
            nameLabel.setSize(200,35);
            
            scoreLabel2.setFont(new java.awt.Font("Gill Sans MT", 0, 40));
            scoreLabel2.setLocation((3*width/5-380)/2, 3*height/6);
            scoreLabel2.setSize(380,50);
            
            addScoreButton.setFont(new java.awt.Font("Gill Sans MT", 1, 20));
            addScoreButton.setText("Add your score");
            addScoreButton.setLocation((3*width/5-200)/2, 9*height/12);
            addScoreButton.setSize(200,50);
       
            addNameTextField.setFont(new java.awt.Font("Gill Sans MT", 0, 30));
            addNameTextField.setLocation(nameLabel.getX()+210, 9*height/14);
            addNameTextField.setSize(300,35);
        
        this.add(letterLabel);
        this.add(addNameTextField);
        this.add(skillLabel);
        this.add(scoreLabel);
        this.add(scoreLabel2);
        this.add(nameLabel);
        this.add(isNOT_top10Label);
        this.add(is_top10Label);
        this.add(top10Label);
        this.add(addScoreButton);
        this.add(scoreScrollPane);
    }
     
     private void addKeysToKeyList()
     {
         KeyList.add("A");
         KeyList.add("B");
         KeyList.add("C");
         KeyList.add("D");
         KeyList.add("E");
         KeyList.add("F");
         KeyList.add("G");
         KeyList.add("H");
         KeyList.add("I");
         KeyList.add("J");
         KeyList.add("K");
         KeyList.add("L");
         KeyList.add("M");
         KeyList.add("N");
         KeyList.add("O");
         KeyList.add("P");
         KeyList.add("R");
         KeyList.add("S");
         KeyList.add("T");
         KeyList.add("U"); 
         KeyList.add("V");
         KeyList.add("W");
         KeyList.add("X"); 
         KeyList.add("Y");
         KeyList.add("Z"); 
     }
     
     private void showNextLetter()
     {
         int index = KeyList.indexOf(letterLabel.getText());
         if(index == KeyList.size() - 1)
             letterLabel.setText(KeyList.getFirst());
         else
             letterLabel.setText(KeyList.get(index + 1));
     }
     
     private void showPreviousLetter()
     {
         int index = KeyList.indexOf(letterLabel.getText());
         if(index == 0)
             letterLabel.setText(KeyList.getLast());
         else
             letterLabel.setText(KeyList.get(index - 1));
     }
     
     private void startKeyboardListener() {   // aici trebuie modificat pentru tastele noastre     
        Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_NUM_LOCK, true);
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD8, 0, false), "8 pressed");
        this.getActionMap().put("8 pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              showNextLetter();
            }
        });
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD2, 0, false), "2 pressed");
        this.getActionMap().put("2 pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                showPreviousLetter();
            }
        });
        
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD5, 0, false), "5 pressed");
        this.getActionMap().put("5 pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                playerName = playerName + letterLabel.getText();
                addNameTextField.setText(playerName);
            }
        });
        
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DECIMAL, 0, false), "delete pressed");
        this.getActionMap().put("delete pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(playerName.equals("") == false)
                {
                    playerName = playerName.substring(0, playerName.length() - 1);
                    addNameTextField.setText(playerName);
                }
            }
        });
        
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), "ENTER pressed");
        this.getActionMap().put("ENTER pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.setPlayerName(playerName);
            }
        });
        
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUM_LOCK, 0, false), "NL pressed");
        this.getActionMap().put("NL pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Toolkit.getDefaultToolkit().setLockingKeyState(KeyEvent.VK_NUM_LOCK, true);
                // cautam si alta solutie aici
            }
        });
    }
}