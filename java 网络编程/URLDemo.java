import java.net.*;
import java.io.*;
import java.util.Scanner;
public class URLDemo {
	public static void main(String[] arg) throws Exception {
		URL url = new URL("http","www.cnblogs.com",80,"/hnrainll/archive/2012/01/09/2317515.html");
		InputStream input = url.openStream();
		Scanner scan = new Scanner(input);
		scan.useDelimiter("\n");
		while(scan.hasNext()){
			System.out.println(scan.next());
		}
	}
}
