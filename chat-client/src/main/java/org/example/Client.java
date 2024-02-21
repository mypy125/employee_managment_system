package org.example;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private BufferedReader reader;
    private BufferedWriter writer;
    private Socket socket;
    private final String name;


    public Client(String name,Socket socket) {
        this.name = name;
        this.socket = socket;

        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            closeEverything(socket, writer, reader);
        }
    }

    public void listenForMassage(){
        new Thread(new Runnable() {
            @Override
            public void run() {

                String massage;
                while(socket.isConnected()){
                    try{

                        massage = reader.readLine();
                        System.out.println(massage);

                    }catch (Exception e){
                        closeEverything(socket, writer, reader);
                    }
                }
            }
        }).start();
    }

    public void sendMassage(){
        try{
            writer.write(name);
            writer.newLine();
            writer.flush();

            Scanner scanner = new Scanner(System.in);
            while (socket.isConnected()){
                String massage = scanner.nextLine();
                writer.write(name+": "+massage);

                writer.newLine();
                writer.flush();

            }
        }catch (Exception e){
            closeEverything(socket, writer, reader);
        }

    }

    private void closeEverything(Socket socket, BufferedWriter writer, BufferedReader reader){
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


}
