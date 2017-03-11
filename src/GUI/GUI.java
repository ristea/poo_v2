/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.*;
import javax.swing.*;
import quizzapp.Game;
import quizzapp.Question;

/**
 *
 * @author TabacAndreina
 */
public class GUI extends Thread{
    private final Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    
    private final JFrame frame = new JFrame();

    private final JPanel cards = new JPanel(new CardLayout());
    private final MenuCard MenuCard = new MenuCard((int)dim.getWidth(), (int) dim.getHeight());
    private final ScoreCard ScoreCard = new ScoreCard((int)dim.getWidth(), (int) dim.getHeight());
    private final QuestionCard QuestionsCard = new QuestionCard((int)dim.getWidth(), (int) dim.getHeight());
    
    private final Game game;
    
    public GUI(Game _game)
    {
       game = _game;
       init();
    }
     
    @Override
     public void run()
     {
        init();
     }
     
    private void init()
    {
        shareGameWithPannels();
        MenuCard.setVisible(true);        
        ScoreCard.setVisible(true);        
        QuestionsCard.setVisible(true);
        
        cards.setVisible(true);
        cards.add(ScoreCard,"ScorePannel");        
        cards.add(QuestionsCard, "QuestionsPannel");
        cards.add(MenuCard,"MenuPannel");
        
        frame.add(cards);
        frame.setVisible(true); 
        
        frame.pack();
        frame.setSize(dim);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void shareGameWithPannels()
    {
        MenuCard.setGame(game);
        ScoreCard.setGame(game);
        QuestionsCard.setGame(game);
    }
     
    /**
     * Show on screen a certain JPanel.
     * @param card JPanel which will be shown
     */
      public void showOnScreen(String card)
    {
        CardLayout cardLayout = (CardLayout) cards.getLayout();
        cardLayout.show(cards, card);
    }
      
      /**
       * Tell to QuestionCard which question to show.
       * @param q question show on screen.
       */
      public void showQuestion(Question q)
    {
        QuestionsCard.showQuestion(q);
    }
      
      /**
       * @param secs time showed on screen
       */
      public void setTimer(int secs)
     {
        QuestionsCard.setTimer(secs);
     }
      
      /**
       * Tell to player which answer is the correct one by changing
       * background color.
       * @param correctAnswer 
       */
      public void showCorrectAnswer(String correctAnswer)
      {
           QuestionsCard.showCorrectAnswer(correctAnswer);
      }
      
      public void showScoreTable(String scoreTable){
          ScoreCard.showScoreTable(scoreTable);
      }
      
      public void setPlayerScore(float score){
          ScoreCard.setPlayerScore(score);
      }
      
      /**
       * @param isTop TRUE if player is in top, FALSE if player is not in top.
       */
      public void setIsTop(boolean isTop){
          ScoreCard.setTopPlayerScreen(isTop);
      }
      
      /**
       * Take the answer from QuestionCard. This function can be called
       * if player did not pressed ENTER.
       * @return Player Answer
       */
      public String getPlayerAnswer()
      {
          return QuestionsCard.getPlayerAnswer();
      }
}
