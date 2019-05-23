package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientHandler {
    private Socket socket;
    private ServerMain server;

    public ClientHandler(ServerMain server,Socket socket) {
        this.socket = socket;
        this.server = server;
    }

    DataInputStream in;
    DataOutputStream out;

    {
        try {
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        try {
                            System.out.println(in.readUTF());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();




        } catch (IOException e) {
            e.printStackTrace();
        }
    }






}
