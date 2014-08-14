
import java.net.*;
import java.io.*;
public class ClientDemo {
	public static void main(String[] arg) throws Exception {
		Socket client = new Socket("localhost",8888);
		BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
		PrintStream out = new PrintStream(client.getOutputStream());
		System.out.println(buf.readLine());
		byte[] b = new byte[1024];
		for(int i=0; i<6; i++){
			(System.in).read(b);
			//String str = new String(b);
			out.println(new String(b));
		}
		buf.close();
		client.close();
	}
}
