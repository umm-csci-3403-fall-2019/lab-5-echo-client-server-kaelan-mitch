package echoserver;

import java.io.*;
import java.net.*;

public class EchoClient {
    public static final int portNum = 6013;

    public static void main(String[] args) throws IOException {
        String server;

        if (args.length == 0) {
            server = "127.0.0.1";
        }
        else {
            server = args[0];
        }


        try {

            Socket socket = new Socket(server, portNum);

            OutputStream out = socket.getOutputStream();

            InputStream in = socket.getInputStream();

            int line;
            while ((line = System.in.read()) != -1) {
                out.write(line);
                int newLine = in.read();
                System.out.write(newLine);
            }

//            InputStream input = socket.getInputStream();
//            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

//            String line;
//            while ((line = reader.readLine()) != null) {
//
//                System.out.println(line);
//            }
            socket.shutdownOutput();
            System.out.flush();
            socket.close();
        }
        catch (ConnectException ce) {
            System.out.println("We were unable to connect to " + server);
            System.out.println("You should make sure the server is running.");
        } catch (IOException ioe) {
            System.out.println("We caught an unexpected exception");
            System.err.println(ioe);
        }
    }
}