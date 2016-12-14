package westerdals.com;

import org.junit.*;
import westerdals.com.Quiz.MusicQuiz;
import westerdals.com.Quiz.Quiz;
import static junit.framework.TestCase.*;

public class QuizTest {
    private Quiz quiz;
    private MusicQuiz mq;

    @Before
    public void setUp() throws Exception {
        mq = new MusicQuiz("ARTIST", "SONG", 1);
        quiz = new Quiz();
        quiz.setCurrentMq(mq);
    }

    @Test
    public void testAskQuestion() throws Exception {
        String expected = "Which artist released the song SONG in year 1?";
        String actual = quiz.askQuestion();
        assertEquals("Answer is formatted with correct parameters", expected, actual);
    }

    @Test
    public void testAnswersCorrectly() throws Exception {
        assertTrue("Returns true if answer contains artist",
                quiz.answersCorrectly("ARTIST"));
        assertTrue("Returns false if answer contains wrong artist",
                quiz.answersCorrectly("WRONGARTIST"));
    }


    @Test
    public void testRespondToAnswer() throws Exception {
        String expectedTrue = "Correct!";
        String expectedFalse = "Wrong! The song was released by ARTIST";
        assertEquals("Response to correct answer", expectedTrue, quiz.respondToAnswer(true));
        assertEquals("Response to wrong answer", expectedFalse, quiz.respondToAnswer(false));
    }

    @Test
    public void testGetCurrentBook() throws Exception {
        assertEquals("Returns same musicQuiz", mq, quiz.getCurrentMq());
    }


    @Test
    public void testAddToScore() throws Exception {
        quiz.addToScore();
        assertEquals("Score increased", 1, quiz.getScore());
    }

    @Test
    public void testGetScore() throws Exception {
        assertEquals("Score starts at 0", 0, quiz.getScore());
    }
}