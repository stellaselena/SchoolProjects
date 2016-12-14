package westerdals.com.Quiz;

public class MusicQuiz {
    private String artist;
    private String song;
    private int year;

    public MusicQuiz(String artist, String song, int year) {
        this.artist = artist;
        this.song = song;
        this.year = year;
    }

    public String getArtist() {
        return artist;
    }

    public String getSong() {
        return song;
    }

    public int getYear() {
        return year;
    }


    @Override
    public String toString() {
        return "MusicQuiz{" +
                "artist='" + artist + '\'' +
                ", song='" + song + '\'' +
                ", year=" + year +
                '}';
    }
}
