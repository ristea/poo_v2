package quizzapp;

import GUI.GUI;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lydya0103
 */
public class Game {
    private static final int QUESTION_NUMBER = 10;
    private static final Utiles utils = new Utiles();
    private static GUI gui;
    
    private List<Question> Questions;
    
    private String UserAnswerForQuestion;
    private boolean StartGame;
    private boolean UserAnswered;
    private float PlayerScore;
    private String PlayeName;
    private int CorrectAnswers;
    private boolean Next;
    
    public Game()
    {
        init();
    }
    
    public void init()
    {
        Next = false;
        utils.loadQuestionFiles();
        if(utils.areQuestions() == false)
        {
            //aici e problema ca nu am intrebari in foldere            
        }
        utils.readScoreFile();
        utils.loadScoreTable();
        Questions = utils.pickQuestions();
    }
    
    public void setGUI(GUI _gui)
    {
        gui = _gui;
    }
    
    public void beginGame()
    {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        gui.showOnScreen("MenuPannel");
        while(true)
        {
            if(StartGame == true)
            {
                // aici sa ii arate un panou gen be ready
                for(Question question : Questions)
                {
                    putUserQuestion(question);
                }
                PlayerScore = (10 * (float) QUESTION_NUMBER) / (float) CorrectAnswers;
                if(utils.isInTop(PlayerScore) == true)
                {
                    gui.setIsTop(true);
                    gui.setPlayerScore(PlayerScore);
                    gui.showScoreTable(utils.getScoreTable());
                    gui.showOnScreen("ScorePannel");

                    waitForEnter();
                    utils.addScore(PlayeName, PlayerScore);
                    gui.showScoreTable(utils.getScoreTable());
                    waitForEnter();
                    // astept sa dea pe butonul de meniu
                }
                else
                {
                    gui.setIsTop(false);
                    gui.setPlayerScore(PlayerScore);
                    gui.showScoreTable(utils.getScoreTable());
                    gui.showOnScreen("ScorePannel");
                    waitForEnter();
                }
                resetPlayer();                
            }
            else
            {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {}
            }
        }
    }
    
    /**
     * Does everything for current question shown.
     * @param question current shown question on the screen.
     */
    private void putUserQuestion(Question question)
    {
        gui.showQuestion(question);
        gui.showOnScreen("QuestionsPannel");
        waitForUserAnswer(question.getTime());
        if(question.getCorrectAnswer().equals(UserAnswerForQuestion) == true)
        {
            CorrectAnswers++;
            gui.showCorrectAnswer(question.getCorrectAnswer());
            waitForEnter();
        }
        else
        {
            gui.showCorrectAnswer(question.getCorrectAnswer());
            waitForEnter();
        }
    }
    
    /**
     * Wait for an answer from GUI (UserAnswered to be true). Counts each second
     * and tell to GUI to repaint the timer.
     * Ends when user answer or time is elapsed.
     * @param QuestionTime is the current question`s time for answer.
     */
    private void waitForUserAnswer(int QuestionTime)
    {
        long questionTime = QuestionTime * 1000;
        long startQuestionTime = System.currentTimeMillis();
        long lastTime = startQuestionTime;
        while(UserAnswered == false)
        {
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {}
            if(System.currentTimeMillis() - lastTime > 980)
            {
                gui.setTimer(QuestionTime--);
                lastTime = System.currentTimeMillis();
            }
            if(System.currentTimeMillis() - startQuestionTime > questionTime + 2000)
            {
                System.out.println("a");
                UserAnswerForQuestion = gui.getPlayerAnswer();
                break;
            } 
        }
        UserAnswered = false;
    }
    
    /**
     * reset all variables for player who just finished the test.
     */
    private void resetPlayer()
    {
        PlayerScore = 0;
        PlayeName = "";
        CorrectAnswers = 0;
        UserAnswerForQuestion = "";
        StartGame = false;
    }
    
    public void sendAnswer(String answer)
    {
        UserAnswered = true;
        UserAnswerForQuestion = answer;        
    }
    
    public void startGame()
    {
        StartGame = true;
    }
    
    /**
     * Called when user pressed ENTER
     * @param EnterPressed TRUE if user pressed enter, FALSE if not.
     */
    public void next(boolean EnterPressed)
    {
        Next = EnterPressed;
    }
    
    private void waitForEnter()
    {
        while(Next == false)
        {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Next = false;
    }
    
    public void setPlayerName(String playerName)
    {
        PlayeName = playerName;
    }
}
