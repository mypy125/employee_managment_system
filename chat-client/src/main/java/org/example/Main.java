package org.example;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("next on name.");
        String name = scanner.nextLine();
        InetAddress address = InetAddress.getLocalHost();

        Socket socket = new Socket(address, 4300);
        Client client = new Client(name, socket);

        InetAddress inetAddress = socket.getInetAddress();
        String remoteIp = inetAddress.getHostAddress();
        System.out.println("inetAddress: "+ inetAddress +"\n " +
                "remoteIp: "+ remoteIp + "\n LocalPort: "+ socket.getLocalPort());

        client.listenForMassage();
        client.sendMassage();

    }
}