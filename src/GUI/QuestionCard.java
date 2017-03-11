/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import quizzapp.Game;
import quizzapp.Question;

/**
 *
 * @author eu
 */
public class QuestionCard extends JPanel {
    private String subject = "SDA";
    private javax.swing.JTextArea LabelA;
    private javax.swing.JTextArea LabelB;
    private javax.swing.JTextArea LabelC;
    private javax.swing.JTextArea LabelD;
    private javax.swing.JLabel TimerLabel;
    private javax.swing.JLabel TitleLabel;
    private javax.swing.JTextArea QuestionLabel;
    
    private Game game;
    private String PlayerAnswer;
    private boolean HasAnswered;

    public int width;
    public int height;
    
     public QuestionCard(int _width,int _height)
     {
        width=_width;
        height=_height;
        initComponents();        
    }

     public void showQuestion(Question q)
     {
        setDefaultColor();
        QuestionLabel.setText(q.getQuestionText());
        //System.lineSeparator() + " A) " + 
        LabelA.setText(q.getAnswers()[0]);
        LabelB.setText(q.getAnswers()[1]);
        LabelC.setText(q.getAnswers()[2]);
        LabelD.setText(q.getAnswers()[3]);
     }
     
     public void setTimer(int secs)
     {
        TimerLabel.setText(Integer.toString(secs));
     }
     
     //label urile au ceva in plus, trb sa modific
     public void showCorrectAnswer(String correctAnswer)
     {
         if(LabelA.getText().equals(correctAnswer)==true)
             LabelA.setBackground(new Color(100, 100, 100));
         else if(LabelB.getText().equals(correctAnswer)==true)
             LabelB.setBackground(new Color(100, 100, 100));
         else if(LabelC.getText().equals(correctAnswer)==true)
             LabelC.setBackground(new Color(100, 100, 100));
         else  
             LabelD.setBackground(new Color(100, 100, 100));
     }
     
     private void setDefaultColor(){
         LabelA.setBackground(new Color(200, 150, 180));
         LabelB.setBackground(new Color(200, 150, 180));
         LabelC.setBackground(new Color(200, 150, 180));
         LabelD.setBackground(new Color(200, 150, 180));
     }
     
     private void initComponents() 
     {
        HasAnswered = false;
        PlayerAnswer = "";         
        startKeyboardListener();
        
        TitleLabel = new javax.swing.JLabel();
        TimerLabel = new javax.swing.JLabel();
        QuestionLabel = new javax.swing.JTextArea();
        LabelA = new javax.swing.JTextArea();
        LabelB = new javax.swing.JTextArea();
        LabelC = new javax.swing.JTextArea();
        LabelD = new javax.swing.JTextArea();

        this.setLayout(null);

        TimerLabel.setFont(new java.awt.Font("Gill Sans MT", 1, 40));
        TimerLabel.setLocation((width)*92/100,height*5/100);
        TimerLabel.setSize(90,50);
        
        TitleLabel.setFont(new java.awt.Font("Gill Sans MT", 1, 40)); // NOI18N
        TitleLabel.setText(subject); // ?????????????????????????????????????????????
        TitleLabel.setLocation((width-90)/2,height/200);
        TitleLabel.setSize(90,50);
//        Color bgnd = TitleLabel.getBackground();
        
        QuestionLabel.setEditable(false);
        QuestionLabel.setBackground(TitleLabel.getBackground());
        QuestionLabel.setLineWrap(true);
        QuestionLabel.setFont(new java.awt.Font("Gill Sans MT", 0, 23)); // NOI18
        QuestionLabel.setLocation((width-1000)/2, height/8);
        QuestionLabel.setSize(1000,150);
        
        //LabelA.setOpaque(false);
        LabelA.setEditable(false);
        LabelA.setBackground(new Color(200, 150, 180));
        LabelA.setLineWrap(true);
        LabelA.setFont(new java.awt.Font("Gill Sans MT", 0, 20)); // NOI18N
        LabelA.setLocation((width-900)/2,2*height/5);
        LabelA.setSize(400,150);
        
        //LabelB.setOpaque(false);
        LabelB.setEditable(false);
        LabelB.setBackground(new Color(200, 150, 180));
        LabelB.setLineWrap(true);
        LabelB.setFont(new java.awt.Font("Gill Sans MT", 0, 20)); // NOI18N
        LabelB.setLocation(LabelA.getX()+ 500, 2*height/5);
        LabelB.setSize(400,150);
        
       // LabelC.setOpaque(false);
        LabelC.setEditable(false);
        LabelC.setBackground(new Color(200, 150, 180));
        LabelC.setLineWrap(true);
        LabelC.setFont(new java.awt.Font("Gill Sans MT", 0, 20)); // NOI18N
        LabelC.setLocation((width-900)/2, LabelA.getY()+220);
        LabelC.setSize(400,150);
        
       //LabelD.setOpaque(false);
        LabelD.setEditable(false);
        LabelD.setBackground(new Color(200, 150, 180));
        LabelD.setLineWrap(true);
        LabelD.setFont(new java.awt.Font("Gill Sans MT", 0, 20)); // NOI18N
        LabelD.setLocation(LabelA.getX()+ 500, LabelA.getY()+220);
        LabelD.setSize(400,150);
      
        this.add(TitleLabel);
        this.add(QuestionLabel);
        this.add(LabelA);
        this.add(LabelB);
        this.add(LabelC);
        this.add(LabelD);
        this.add(TimerLabel);
    }
     
     public void setGame(Game _game)
    {
        game = _game;
    }
    
     //se apeleaza o functie pe game pentru a nu mai lasa playerul sa selecteze alte raspunsuri
    private void startKeyboardListener() {
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_NUM_LOCK, 0, false), "NL pressed");
        this.getActionMap().put("NL pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                PlayerAnswer = LabelA.getText();
                setDefaultColor();
                LabelA.setBackground(new Color(0,0,0));
            }
        });
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DIVIDE, 0, true), "/ pressed");
        this.getActionMap().put("/ pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                PlayerAnswer = LabelB.getText();
                setDefaultColor();
                LabelB.setBackground(new Color(0,0,0));
            }
        });
        
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_MULTIPLY, 0, false), "* pressed");
        this.getActionMap().put("* pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                PlayerAnswer = LabelC.getText();
                setDefaultColor();
                LabelC.setBackground(new Color(0,0,0));
            }
        });
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, 0, true), "- pressed");
        this.getActionMap().put("- pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                PlayerAnswer = LabelD.getText();
                setDefaultColor();
                LabelD.setBackground(new Color(0,0,0));
            }
        });
        
        this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0, false), "ENTER pressed");
        this.getActionMap().put("ENTER pressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(HasAnswered == false)
                {
                    game.sendAnswer(PlayerAnswer); 
                    HasAnswered = true;
                }
                else
                {
                    game.next(true);
                    HasAnswered = false;
                }                                   
            }
        });
    }
    
    public String getPlayerAnswer()
    {
        HasAnswered = true;
        return PlayerAnswer;
    } 
}
