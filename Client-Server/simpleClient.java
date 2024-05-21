//importing the required imports for our client
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class simpleClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 6336); //naming the host and giving a port number
            //reading input from client
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //sending output to server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            //reading input from client
            BufferedReader clientinput = new BufferedReader(new InputStreamReader(System.in))) {

            //we will tell the client that they successfully connected to the server
            System.out.println("You are connected to server.");

            Thread messageThread = new Thread(() -> { //creating a thread then using lambda :)
                try {
                    String servermessage;
                    //the loop will go on as long as the message is not empty
                    while ((servermessage = in.readLine()) != null) {
                        System.out.println("Server: " + servermessage);
                        //i will break the loop when the server sends "Bye"
                        if (servermessage.equals("Bye")) break;
                    }
                    //else (if the message is empty), i will disconnect the server
                    System.out.println("The server disconnected.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            messageThread.start(); //the start will create and execute the thread

            String clientMessage;
            while ((clientMessage = clientinput.readLine()) != null) {
                out.println(clientMessage);
                //I will break the loop when the client send "Bye"
                if (clientMessage.equals("Bye")){
                    break;
                }
            }
            socket.close();
            out.flush();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
