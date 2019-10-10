package echoserver;

import java.net.*;
import java.io.*;

public class EchoServer {
    public static final int portNum = 6013;

    public static void main(String[] args) {
        try {
            ServerSocket sock = new ServerSocket(portNum);

            while (true) {
                Socket client = sock.accept();
                System.out.println("Request accepted");

                PrintWriter writer = new PrintWriter(client.getOutputStream(), true);

                //writer.println(new java.util.Date().toString());


                client.close();
            }
        }
        catch (IOException ioe) {
            System.out.println("We caught an unexpected exception");
            System.err.println(ioe);
        }
    }
}