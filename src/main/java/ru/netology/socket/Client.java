package ru.netology.socket;

import java.io.*;
import java.net.Socket;

public class Client {

    public static final String HOST = "localhost";

    public static void main(String[] args) throws IOException {
        Socket clientSocket = new Socket(HOST, Server.PORT);
        BufferedReader readerOfClientMessage = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        System.out.println("Напишите сообщение для отправки на сервер:");
        String message = readerOfClientMessage.readLine();
        out.write(message + "\n");
        out.flush();
        String serverAnswer = in.readLine();
        System.out.println("Ответ сервера: " + serverAnswer);
        clientSocket.close();
        readerOfClientMessage.close();
        in.close();
        out.close();
    }
}
