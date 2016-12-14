package westerdals.com.Quiz;

import westerdals.com.Database.DBHandler;
import westerdals.com.Database.DBService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class Quiz {

    private int score;
    private List<MusicQuiz> musicQuizList;
    private MusicQuiz currentMq;
    private DBService dbService;

    public Quiz() throws Exception {
        try {
            HashMap<String, String> config = DBHandler.readProperties();
            dbService = DBHandler.dbLogin(
                    config.get("dbpassword"),
                    config.get("dbuser"),
                    config.get("hostname"),
                    config.get("dbname"),
                    config.get("port"));
            setMusicQuizList(dbService);
            this.score = 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            dbService.releaseConnection();

        }
    }

    public String askQuestion() {
        String string = "Which artist released the song " +  getCurrentMq().getSong() +
                " in year " +  getCurrentMq().getYear() +  "?";
        return string;
    }

    public boolean answersCorrectly(String answer) {
        return answer.contains(getCurrentMq().getArtist().toUpperCase());
    }

    public String respondToAnswer(boolean answersCorrectly) {
        if (answersCorrectly) {
            addToScore();
            return "Correct!";
        } else {
            return "Wrong! The song was released by "
                    + getCurrentMq().getArtist();
        }
    }

    public void setMusicQuizList(DBService dbService) throws SQLException {
        this.musicQuizList = dbService.createMusicQuizList("musicquiz");
    }

    public void getNewMusicQuizFromList() {
        int count = getMq().size();
        setCurrentMq(getMq().get((int) (Math.random() * count)));
    }

    public void setCurrentMq(MusicQuiz currentMq) {
        this.currentMq = currentMq;
    }

    public MusicQuiz getCurrentMq() {
        return currentMq;
    }

    public List<MusicQuiz> getMq() {
        return musicQuizList;
    }

    public int addToScore() {
        return (score++);
    }

    public int getScore() {
        return score;
    }

}
