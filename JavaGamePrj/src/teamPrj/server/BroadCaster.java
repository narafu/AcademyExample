package teamPrj.server;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class BroadCaster extends Thread {
    int player;
    ObjectInputStream objectInputStream;
    LinkedList<ObjectOutputStream> objectOutputStreams;

    public BroadCaster(int player, ObjectInputStream objectInputStream, LinkedList<ObjectOutputStream> objectOutputStreams) {
      this.player = player;
      this.objectInputStream = objectInputStream;
      this.objectOutputStreams = objectOutputStreams;
    }

    public void run() {
      try {
        while (true) {
          ClientData clientData = (ClientData)objectInputStream.readObject();
          System.out.printf("received a message from player %d\n", player);
          for (ObjectOutputStream objectOutputStream: objectOutputStreams) {
            objectOutputStream.writeObject(clientData);
            objectOutputStream.flush();
          }
        }
      } catch (IOException | ClassNotFoundException e) {
        System.out.println(e.getMessage());
      }
    }
  }