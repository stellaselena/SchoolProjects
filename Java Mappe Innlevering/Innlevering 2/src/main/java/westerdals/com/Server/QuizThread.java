package westerdals.com.Server;


import westerdals.com.Quiz.Quiz;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/*
* Quiz Building
* */
public class QuizThread extends Thread {

    private DataInputStream is = null;
    private DataOutputStream os = null;
    private Socket clientSocket = null;
    private final QuizThread[] threads;
    private int maxClientsCount;
    private Quiz quiz;
    private boolean continueQuiz = true;


    public QuizThread(Socket clientSocket, QuizThread[] threads) throws Exception {
        quiz = new Quiz();
        this.clientSocket = clientSocket;
        this.threads = threads;
        maxClientsCount = threads.length;
    }

    public void run() {
        int maxClientsCount = this.maxClientsCount;
        QuizThread[] threads = this.threads;

        try {
            is = new DataInputStream(clientSocket.getInputStream());
            os = new DataOutputStream(clientSocket.getOutputStream());
            os.writeUTF(welcomeMessage());
            quizSetup();
            synchronized (this) {
                for (int j = 0; j < maxClientsCount; j++) {
                    if (threads[j] == this) {
                        threads[j] = null;
                    }
                }
            }
            close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void close() throws Exception {
        is.close();
        os.close();
        clientSocket.close();
    }

    private String welcomeMessage() {
        StringBuilder string = new StringBuilder();
        return string.append("---------- WELCOME TO THE MUSIC QUIZ----------\n")
                .append("For each correct answer you will receive one point.\n")
                .append("Try to get as many correct answers as you can!\n")
                .append("Let's start!\n").toString();
    }

    private void quizSetup() {
        try {
            int numberOfQuestions = 0;
            os.writeUTF("Are you ready to begin?");
            String answer = is.readUTF();
            if ((answer.equalsIgnoreCase("yes")) || (answer.equalsIgnoreCase("y"))) {
                do {
                    numberOfQuestions++;
                    quiz.getNewMusicQuizFromList();
                    os.writeUTF(quiz.askQuestion());
                    answer = is.readUTF().toUpperCase();
                    os.writeUTF(quiz.respondToAnswer(quiz.answersCorrectly(answer)));
                    os.writeUTF("Do you want to continue?");
                    answer = is.readUTF();
                    if ((answer.equalsIgnoreCase("no")) || (answer.equalsIgnoreCase("n"))) {
                        continueQuiz = false;
                    }
                } while (continueQuiz);
            }

            os.writeUTF("User stopped the quiz");
            os.writeUTF("You got " + quiz.getScore() +
                    " out of " + numberOfQuestions + " correct answers");
            os.writeUTF("Bye!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
