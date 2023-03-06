package soloPrj.ex05_network;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client extends Thread {
	Socket socket;
	InputStream inputStream;
	OutputStream outputStream;
	Receiver receiver;

	public Client(Receiver receiver) {
		this.receiver = receiver;
	}

	public ClientData connect(String ip) {
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress(ip, 5001));
			inputStream = socket.getInputStream();
			outputStream = socket.getOutputStream();
			byte[] bytes = new byte[65535];
			inputStream.read(bytes);
			ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
			ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
			return (ClientData) objectInputStream.readObject();
		} catch (Exception e) {
		}
		return null;
	}

	public void send(ClientData data) {
		try {
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
			objectOutputStream.writeObject(data);
			byte[] bytes = byteArrayOutputStream.toByteArray();
			outputStream.write(bytes);
			outputStream.flush();
		} catch (Exception e) {
		}
	}

	public void run() {
		try {
			while (isAlive()) {
				byte[] bytes = new byte[100];
				inputStream.read(bytes);
				ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
				ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
				ClientData data = (ClientData) objectInputStream.readObject();
				receiver.receive(data);
			}
		} catch (Exception e) {
		}
	}
}