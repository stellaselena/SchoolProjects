package westerdals.com.Server;

import westerdals.com.Quiz.Quiz;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

public class Server {

    private static ServerSocket serverSocket = null;
    private static Socket clientSocket = null;
    private static final int maxClientsCount = 10;
    private static final QuizThread[] threads = new QuizThread[maxClientsCount];
    private static int portNumber;
    private static DataOutputStream os;


    public static void main(String args[]) {

        serverConnect();
        while (true) {
            clientConnect();
        }
    }
    /*
    * Establishing Server connection
    * */
    public static void serverConnect() {
        setPort(2222);
        System.out.println("Server: Now using port number: " + getPort());

        try {
            serverSocket = new ServerSocket(getPort());

            System.out.println("Clients can now connect");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    /*
     * Establishing Client connection
     * */
    public static void clientConnect() {
        try {
            clientSocket = serverSocket.accept();
            int i = 0;
            for (i = 0; i < maxClientsCount; i++) {
                if (threads[i] == null) {
                    os = new DataOutputStream(clientSocket.getOutputStream());
                    (threads[i] = new QuizThread(clientSocket, threads)).start();
                    os.writeUTF("Connected");
                    break;
                }
            }
            if (i == maxClientsCount) {
                os.writeUTF("Server too busy.");
                os.close();
                clientSocket.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void setPort(int port) {
        portNumber = port;
    }

    public static int getPort() {
        return portNumber;
    }

}
