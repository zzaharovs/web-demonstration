package ru.zzaharovs.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class Server {


    final int port;
    ExecutorService threadPool;
    final List<String> validPaths;

    public Server(List<String> validPaths, int port, ExecutorService threadPool) {

        this.validPaths = validPaths;
        this.port = port;
        this.threadPool = threadPool;


    }

    public void start() {

        try {
            final var serverSocket = new ServerSocket(port);
            while (true) {
                var socket = serverSocket.accept();
                connectionProcess();
                threadPool.execute(new Connection(validPaths, socket));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void connectionProcess() {
        System.out.println("Запрос обработан");
    }


}
