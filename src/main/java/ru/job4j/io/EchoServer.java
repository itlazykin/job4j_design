package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream output = socket.getOutputStream();
                     BufferedReader input = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    output.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String in = input.readLine();
                    if ("/?msg=Exit".contains(in)) {
                        System.out.println(in);
                        server.close();
                        break;
                    }
                    if (in.contains("?msg=Hello")) {
                        output.write("Hello".getBytes());
                        System.out.println(in);
                    } else {
                        output.write("What".getBytes());
                        System.out.println(in);
                    }
                    for (String string = input.readLine();
                         string != null && !string.isEmpty();
                         string = input.readLine()) {
                        System.out.println(string);
                    }
                    output.flush();
                } catch (Exception e) {
                    LOG.error("Input/output error", e);
                }
            }
        } catch (Exception e) {
            LOG.error("Server error", e);
        }
    }
}
