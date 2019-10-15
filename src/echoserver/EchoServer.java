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
                InputStream input = client.getInputStream();
                OutputStream output = client.getOutputStream();

                int line;
                while ((line = input.read()) != -1) {
                    output.write(line);
                    System.out.println("Passed through here: " + line);
                }

                //writer.println(new java.util.Date().toString());

                client.shutdownOutput();
                System.out.flush();
                client.close();
            }
        }
        catch (IOException ioe) {
            System.out.println("We caught an unexpected exception");
            System.err.println(ioe);
        }
    }
}