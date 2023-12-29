package org.example.chat;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    private String username;

    public ChatClient(String username) {
        this.username = username;
    }

    public void start(String serverAddress, int serverPort) {
        try (
                Socket socket = new Socket(serverAddress, serverPort);
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                Scanner scanner = new Scanner(System.in)
        ) {

            Thread incomingThread = new Thread(() -> handleIncomingMessages(inputStream));
            incomingThread.start();

            // Send messages to the server
            while (true) {
                System.out.print("Enter message: ");
                String content = scanner.nextLine();
                ChatMessage message = new ChatMessage(username, content);
                outputStream.writeObject(message);
                outputStream.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handleIncomingMessages(ObjectInputStream inputStream) {
        try {
            while (true) {
                ChatMessage message = (ChatMessage) inputStream.readObject();
                System.out.println(message.getSender() + ": " + message.getContent());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
