import java.io.*;
import java.net.*;

public class MetroStation {
    public static void main(String[] args) {
        try {
            // Create a server socket listening on port 12345
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Metro station server started. Waiting for a train...");

            // Accept train connection
            Socket trainSocket = serverSocket.accept();
            System.out.println("Train connected.");

            // Set up input stream to receive messages from train
            BufferedReader trainIn = new BufferedReader(new InputStreamReader(trainSocket.getInputStream()));

            // Set up output stream to send messages to train
            PrintWriter trainOut = new PrintWriter(trainSocket.getOutputStream(), true);

            // Wait for train to request passengers
            String request = trainIn.readLine();
            if (request.equals("REQUEST_PASSENGERS")) {
                // Provide passengers to the train
                System.out.println("Sending passengers to the train...");
                trainOut.println("PASSENGERS_READY");
            }

            // Close resources
            trainIn.close();
            trainOut.close();
            trainSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
