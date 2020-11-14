package project_01.ex01;

public class Main {
  public static void main(String[] arguments) {
    Client client = new Client(null);
    ClientData data = client.connect("192.168.0.32");
    if (data == null)
    	System.out.println("nnnnnnnnnnnnnnnnn");
    else
    	System.out.println("yyyyyyyyyyyyyyyyyyy");
    client.start();
  }
}