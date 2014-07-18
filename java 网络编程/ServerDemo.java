import java.net.*;
import java.io.*;
public class ServerDemo {
	public static void main(String[] arg) throws Exception {
		ServerSocket server = new ServerSocket(8888);
		Socket client = server.accept();
		PrintStream out = new PrintStream(client.getOutputStream());
		out.println("I'm server , are you client? what art you doing?");
		BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
		for (int i =0; i<6; i++){
			if(buf.readLine()!="\n"){
				System.out.println("echo: "+ buf.readLine());
			}
		}
		buf.close();
		client.close();
		server.close();
	}
}
