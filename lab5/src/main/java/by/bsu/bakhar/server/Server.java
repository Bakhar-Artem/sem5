package by.bsu.bakhar.server;

import by.bsu.bakhar.listener.ServerListener;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Server {
    public static final int PORT = 8080;
    public static LinkedList<ServerListener> serverList = new LinkedList<>(); // список всех нитей


    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = server.accept();
                try {
                    serverList.add(new ServerListener(socket));
                    System.out.println("connected");
                } catch (IOException e) {
                    socket.close();
                }
            }
        }
    }
}