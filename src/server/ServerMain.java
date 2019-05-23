package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ServerMain {
    private Vector<ClientHandler> clientPool = new Vector();

    public ServerMain() {
        ServerSocket serverSocket = null;
        Socket socket = null;
        {
            try {
                serverSocket = new ServerSocket(9999);
                System.out.println("Сервер запущен...");

                while (true){
                    socket = serverSocket.accept();
                    System.out.println("Клиент подключился. RSA: " + socket.getRemoteSocketAddress());
                    //clientPool.add(new ClientHandler(this,socket));
                    clientPool.add(new ClientHandler(this,socket));
                }

            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
