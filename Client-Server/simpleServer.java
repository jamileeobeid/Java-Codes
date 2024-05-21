//importing the required imports for our server
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class simpleServer {
    public static void main(String[] args) {
        //i will use nested try/catch (meaning two try/catch inside each other)
        try (ServerSocket serverSocket = new ServerSocket(6336); //i added a port number inside the serversocket

            //i will use .accept() to wait for connection from the client
            Socket clientSocket = serverSocket.accept();
            InputStreamReader inputStream = new InputStreamReader(clientSocket.getInputStream());
            //reading input from client
            BufferedReader in = new BufferedReader(inputStream);
            //sending output to client
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            //reading input from server
            BufferedReader serverInput = new BufferedReader(new InputStreamReader(System.in))) {

            //notifying that the client is connected
            System.out.println("The client is connected.");

            Thread messageThread = new Thread(() -> { //creating a thread then using lambda :)
                try {
                    String clientmessage;
                    //the loop will go on as long as the message is not empty
                    while ((clientmessage = in.readLine()) != null) {
                        System.out.println("Client: " + clientmessage);
                        //i will break the loop when the client sends "Bye"
                        if (clientmessage.equals("Bye")) break;
                    }
                    //else (if the message is empty), i will disconnect the client
                    System.out.println("The client is disconnected.");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            messageThread.start();//the start will create and execute the thread

            String serverMessage;
            while ((serverMessage= serverInput.readLine()) != null) {
                out.println(serverMessage);
                //we will break the loop when the server send "Bye"
                if (serverMessage.equals("Bye")) break;
            }
            serverSocket.close();
            clientSocket.close();
            out.flush();
            out.close();
        } catch (IOException e) { //catching the IO exception
            e.printStackTrace();
        }
    }
}
