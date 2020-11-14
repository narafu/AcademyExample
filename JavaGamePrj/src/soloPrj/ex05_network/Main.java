package soloPrj.ex05_network;
public class Main {
  public static void main(String[] arguments) {
    Client client = new Client(null);
    ClientData data = client.connect("192.168.0.32");
    client.start();
  }
}