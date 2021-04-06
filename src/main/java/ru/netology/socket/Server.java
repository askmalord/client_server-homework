package ru.netology.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final int PORT = 9999;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket clientSocket = serverSocket.accept();
        System.out.println("New connection accepted");

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        
        String clientName = in.readLine();

        out.write(String.format("Hi %s, your port is %d\n", clientName, clientSocket.getPort()));
        out.flush();
        clientSocket.close();
        serverSocket.close();
        in.close();
        out.close();
    }
}
