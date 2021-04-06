package ru.netology.socket;

import java.io.*;
import java.net.Socket;

public class Client {

    public static final String HOST = "netology.homework";

    public static void main(String[] args) {
        try (Socket clientSocket = new Socket(HOST, Server.PORT);
             BufferedReader readerOfClientMessage = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            getServerAnswer(in);

            getClientMessage(readerOfClientMessage, out);

            getServerAnswer(in);

            getClientMessage(readerOfClientMessage, out);

            getServerAnswer(in);
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void getServerAnswer(BufferedReader reader) throws IOException {
        String serverAnswer = reader.readLine();
        System.out.println(serverAnswer);
    }
    public static void getClientMessage(BufferedReader reader, PrintWriter writer) throws IOException {
        String clientAnswer = reader.readLine();
        writer.println(clientAnswer);
    }
}
