import java.net.URL;
import java.net.URLConnection;
import java.io.InputStream;
import java.util.Scanner;

public class URLConnectionDemo {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://www.cnblogs.com/hnrainll/archive/2012/01/09/2317515.html");
		URLConnection urlCon = url.openConnection();
		System.out.println(urlCon.getContentLength());
		System.out.println(urlCon.getContentType());
	}
}
