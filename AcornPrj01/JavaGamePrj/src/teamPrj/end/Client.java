package teamPrj.end;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client extends Thread {
  Socket socket;
  ObjectInputStream objectInputStream;
  ObjectOutputStream objectOutputStream;
  Receiver receiver;

  public Client(Receiver receiver) {
    this.receiver = receiver;
  }

  public ClientData connect(String ip) {
    try {
      socket = new Socket();
      socket.connect(new InetSocketAddress(ip, 5001));
      objectInputStream = new ObjectInputStream(socket.getInputStream());
      objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
      return read();
    } catch (Exception e) {}
    return null;
  }

  public ClientData read() {
    try {
      return (ClientData)objectInputStream.readObject();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return null;
  }
  
  public void send(ClientData data) {
    try {
      objectOutputStream.writeObject(data);
      objectOutputStream.flush();
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public void run() {
    while (isAlive()) {
      receiver.receive(read());
    }
  }
}