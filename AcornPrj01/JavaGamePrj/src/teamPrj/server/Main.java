package teamPrj.server;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class Main {
  static final int playerCount = 3;

  public static void sendClientData(ObjectOutputStream objectOutputStream, int player, int x, int y) throws IOException, InterruptedException {
    ClientData clientData = new ClientData();
    clientData.player = player;
    clientData.x = x;
    clientData.y = y;
    objectOutputStream.writeObject(clientData);
    objectOutputStream.flush();
  }

  public static void main(String[] main) throws IOException, InterruptedException {
    ServerSocket serverSocket = new ServerSocket();		
    serverSocket.bind(new InetSocketAddress(InetAddress.getLocalHost().getHostAddress(), 5001));
    
    LinkedList<Socket> sockets = new LinkedList<Socket>();
    LinkedList<ObjectInputStream> objectInputStreams = new LinkedList<ObjectInputStream>();
    LinkedList<ObjectOutputStream> objectOutputStreams = new LinkedList<ObjectOutputStream>();
    System.out.println("waiting for three players...");
    for (int i = 0; i < 3; i++) {
      Socket socket = serverSocket.accept();
      sockets.add(socket);
      objectOutputStreams.add(new ObjectOutputStream(socket.getOutputStream()));
      objectInputStreams.add(new ObjectInputStream(socket.getInputStream()));
      sendClientData(objectOutputStreams.getLast(), i+1, 0, 0);
      System.out.println("player " + i + " has connected.");
    }
    System.out.println("game has started.");

    LinkedList<BroadCaster> broadCasters = new LinkedList<BroadCaster>();
    for (int i = 0; i < 3; i++)
      broadCasters.add(new BroadCaster(i + 1, objectInputStreams.get(i), objectOutputStreams));
    for (BroadCaster broadCaster: broadCasters)
      broadCaster.start();
    for (ObjectOutputStream objectOutputStream: objectOutputStreams)
      sendClientData(objectOutputStream, 0, 0, 0);
    for (BroadCaster broadCaster: broadCasters)
      broadCaster.join();
    
    for (InputStream inputStream: objectInputStreams)
      inputStream.close();
    for (OutputStream outputStream: objectOutputStreams)
      outputStream.close();
    for (Socket socket: sockets)
      socket.close();
    serverSocket.close();
  }
}