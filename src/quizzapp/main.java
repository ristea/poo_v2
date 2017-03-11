package quizzapp;

import GUI.GUI;

/**
 *
 * @author Lydya0103
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        GUI gui = new GUI(game);
        gui.start();
        game.setGUI(gui);
        game.beginGame();
    }
    
    
    
    
    private void a()
    {
        
//        List<Question> l = u.pickQuestions();
//        for(Question q : l)
//        {
//            System.out.println(q.toString());
//        }
//        u.addScore("gheo", (float) 26.7);
//        u.addScore("d", (float) 26.7);
//        u.addScore("d", (float) 21.7);
//        u.addScore("f", (float) 11.7);
//        u.addScore("z", (float) 25);
//        u.addScore("dsa", (float) 13);
//        u.addScore("ultimu", (float) 1);
//        u.addScore("d", (float) 26.7);
//        u.addScore("d", (float) 21.7);
//        u.addScore("f", (float) 3.7);
//        u.addScore("z", (float) 25);
//        u.addScore("dsa", (float) 11);
//        LinkedList<String> score = u.getScoreTable();
//        boolean t = u.isInTop((float) 13.8);
//        System.out.println(t);
//        System.out.println("a");
//        GUI gui;
//        gui = new GUI();
//        gui.showOnScreen("ScorePannel");
//        String[] PATHS = {"resources" + File.separator + "PC.txt",
//        "resources" + File.separator + "SDA.txt",
//        "resources" + File.separator + "POO.txt",
//        "resources" + File.separator + "CID.txt"};
//        Question question = new Question("Hey",PATHS,40);
//        gui.showQuestion(question);
//        for(int i=0;i<10;i++){
//            gui.setTimer(i);
//            Thread.sleep(1000);
//        }
//        gui.showCorrectAnswer(PATHS[1]);
//        gui.setPlayerScore((float)55);
//        gui.setIsTop(true);
    }
}
