package westerdals.com;

import org.junit.Before;
import org.junit.Test;
import westerdals.com.Quiz.MusicQuiz;
import static org.junit.Assert.*;

public class MusicQuizTest {
    private MusicQuiz mq;

    @Before
    public void setUp() {

        mq = new MusicQuiz("Stella", "Mysong", 1991);
    }

    @Test
    public void testGetArtist() throws Exception {
        assertEquals("Stella", mq.getArtist());
    }

    @Test
    public void testGetSong() throws Exception {
        assertEquals("Mysong", mq.getSong());
    }

    @Test
    public void testGetYear() throws Exception {
        assertEquals(1991, mq.getYear());
    }

}
