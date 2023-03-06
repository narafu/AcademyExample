

public class Main implements Receiver {
  public static void main(String[] arguments) {
    Client client = new Client(new Main());
    ClientData data = client.connect("192.168.0.32");
    data.print();
    client.start();
    client.send(data);
  }

  public void receive(ClientData data) {
    data.print();
  }
}