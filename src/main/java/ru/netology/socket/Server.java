package ru.netology.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static final int PORT = 9999;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT);
             Socket clientSocket = serverSocket.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            System.out.println("New connection accepted");
            out.println("Write your name");

            String clientName = in.readLine();
            out.println("Are you child? (yes/no)");

            String answer = in.readLine();
            if (answer.equals("yes")) {
                out.println(String.format("Welcome to the kids area, %s! Let's play!", clientName));
            } else {
                out.println(String.format("Welcome to the adult zone, %s! "
                        + "Have a good rest, or a good working day!", clientName));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
