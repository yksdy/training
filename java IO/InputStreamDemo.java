import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
public class InputStreamDemo{
	public static void main(String[] args) throws Exception{
		File f = new File("test.txt");
		InputStream ips = null;
		ips = new FileInputStream(f);
		//byte[] b = new byte[1024];
		byte[] b = new byte[(int)f.length()];
		int len = ips.read(b);
		ips.close();
		System.out.println("len = "+len);
		System.out.println(new String(b,0,len));
	}
}
