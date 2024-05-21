import java.io.*;
import java.net.*;

public class MetroTrain {
    public static void main(String[] args) {
        try {
            // Connect to metro station on localhost and port 12345
            Socket stationSocket = new Socket("localhost", 12345);

            // Set up input stream to receive messages from metro station
            BufferedReader stationIn = new BufferedReader(new InputStreamReader(stationSocket.getInputStream()));

            // Set up output stream to send messages to metro station
            PrintWriter stationOut = new PrintWriter(stationSocket.getOutputStream(), true);

            // Request passengers from the metro station
            stationOut.println("REQUEST_PASSENGERS");

            // Receive response from metro station
            String response = stationIn.readLine();
            if (response.equals("PASSENGERS_READY")) {
                System.out.println("Passengers ready. Departing from the station...");
            }

            // Close resources
            stationIn.close();
            stationOut.close();
            stationSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}