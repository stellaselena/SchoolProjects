package westerdals.com.Client;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements Runnable {

    private static Socket clientSocket = null;
    private static DataOutputStream os = null;
    private static DataInputStream is = null;
    private static BufferedReader inputLine = null;
    private static boolean closed = false;
    private static int portNumber = 2222;
    private static String host = "localhost";


    public static void main(String[] args) {


        if (host != null && portNumber > 1000) {
            System.out.println("Client using host: " + host + ", portNumber: " + portNumber);
        } else {
            System.out.println("Please provide correct host and port to connect to.");
        }

        startClient();
    }

    public static void startClient() {
        try {
            clientSocket = new Socket(host, portNumber);
            inputLine = new BufferedReader(new InputStreamReader(System.in));
            os = new DataOutputStream(clientSocket.getOutputStream());
            is = new DataInputStream(clientSocket.getInputStream());
        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Couldn't get I/O for the connection to the host "
                    + host);
        }

        if (clientSocket != null && os != null && is != null) {
            try {

                new Thread(new Client()).start();
                while (!closed) {
                    os.writeUTF(inputLine.readLine().trim());
                }

                closeClient();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void closeClient() throws IOException {
        os.close();
        is.close();
        clientSocket.close();
    }

    public void run() {

        String responseLine;
        try {
            while (((responseLine = is.readUTF()) != null)) {
                System.out.println(responseLine);
                if (responseLine.equalsIgnoreCase("Bye!")) {
                    break;
                }
            }
            closed = true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}