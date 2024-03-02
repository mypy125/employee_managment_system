package org.example;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;


public class ClientManager implements Runnable{
    private BufferedReader reader;
    private BufferedWriter writer;
    private Socket socket;
    private String name;
    public static HashMap<String, ClientManager> clients = new HashMap<>();

    public ClientManager(Socket socket){
        try{
            this.socket = socket;
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            name = reader.readLine();
            clients.put(name,this);
            System.out.println("Server: " + name + " connected to chat..");
            broadcastMassage("Server: " + name + " connected to chat.");

        }catch (Exception e){
            closeEverything(socket, writer, reader);
        }

    }

    private void broadcastMassage(String massage){
        for(ClientManager client : clients.values()){
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
        clients.remove(name,this);
        broadcastMassage("Server: " + name + " client closed chat");
    }


    @Override
    public void run() {

        String massageFromClient;
        while (socket.isConnected()){
            try{
                massageFromClient = reader.readLine();
                String[] msg = massageFromClient.split("\\s+");
                if(msg[1].startsWith("@")){
                    ClientManager client = (ClientManager) searchNameFromMassage(massageFromClient,clients);
                    if(client != null)privateMessageClient(client,massageFromClient);

                }else {
                    // Отправка данных всем слушателям
                    broadcastMassage(massageFromClient);
                }

            }catch (Exception e){
                closeEverything(socket, writer, reader);
            }

        }
    }

    private static Object searchNameFromMassage(String message, HashMap<?, ?> clients) {
        Object client = null;
        if (message != null ) {
            String[] names = message.split("\\s+");
            for (String name : names) {
                if (clients.containsKey(name)) {
                    client = clients.get(name);
                    break;
                }
            }
        }
        return client;
    }

    private Object equalsNameFromMap(String s, HashMap<?, ?> clients){
        Object clientManager = null;
        if(s != null && clients.containsKey(s)){
            clientManager = clients.get(s);
        }
        return clientManager;
    }

    private void privateMessageClient(ClientManager client, String message){
        ClientManager privatMassage = client;
        try {
            privatMassage.writer.write(message);
            privatMassage.writer.newLine();
            privatMassage.writer.flush();

        } catch (Exception e) {
            closeEverything(socket, writer, reader);
        }

    }
}
