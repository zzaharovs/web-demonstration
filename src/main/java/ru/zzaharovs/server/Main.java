package ru.zzaharovs.server;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static final int NUMBER_THREADS = 64;
    public static final int PORT = 8080;


    public static void main(String[] args) throws IOException {

        final var validPaths = List.of("/index.html",
                "/spring.svg", "/spring.png", "/resources.html", "/styles.css", "/app.js",
                "/links.html", "/forms.html", "/classic.html", "/events.html", "/events.js");

        ExecutorService threadPool = Executors.newFixedThreadPool(NUMBER_THREADS);
        Server server = new Server(validPaths, PORT, threadPool);
        server.start();


    }

}
