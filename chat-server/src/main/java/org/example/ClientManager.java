package org.example;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;


public class ClientManager implements Runnable{
    private BufferedReader reader;
    private BufferedWriter writer;
    private Socket socket;
    private String name;
    public static ArrayList<ClientManager> clients = new ArrayList<>();

    public ClientManager(Socket socket){
        try{
            this.socket = socket;
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            clients.add(this);
            name = reader.readLine();
            broadcastMassage("Server: " + name + " connected to chat.");

        }catch (Exception e){
            closeEverything(socket, writer, reader);
        }

    }

    private void broadcastMassage(String massage){
        for(ClientManager client : clients){
            try{
                if(!client.name.equals(name) && massage != null){
                    client.writer.write(massage);
                    client.writer.newLine();
                    client.writer.flush();
                }
            }catch (Exception e){
                closeEverything(socket, writer, reader);
            }
        }
    }
    private void closeEverything(Socket socket, BufferedWriter writer, BufferedReader reader){
        removeClient();
        try {
            if(writer != null){
                writer.close();
            }
            if(reader != null){
                reader.close();
            }
            if(socket != null){
                socket.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private void removeClient() {
        clients.remove(this);
        broadcastMassage("Server: " + name + " client closed chat");
    }


    @Override
    public void run() {

        String massageFromClient;
        while (socket.isConnected()){
            try{
                massageFromClient = reader.readLine();
                broadcastMassage(massageFromClient);

            }catch (Exception e){
                closeEverything(socket, writer, reader);
            }

        }
    }
}
