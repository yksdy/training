import java.net.*;
import java.io.*;
public class ServerDemo {
	public static void main(String[] arg) throws Exception {
		ServerSocket server = new ServerSocket(8888);
		Socket client = server.accept();
		PrintStream out = new PrintStream(client.getOutputStream());
		out.println("I'm server , are you client? what art you doing?");
		client.close();
		server.close();
	}
}
