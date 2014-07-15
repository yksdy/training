import java.net.*;
import java.io.*;
public class ClientDemo {
	public static void main(String[] arg) throws Exception {
		Socket client = new Socket("localhost",8888);
		BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
		System.out.println(buf.readLine());
		buf.close();
		client.close();
	}
}
