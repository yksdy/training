import java.io.File;
import java.io.Reader;
import java.io.FileReader;
public class ReaderDemo {
	public static void main(String[] arg) throws Exception{
		File f = new File("test.txt");
		Reader r = null;
		r = new FileReader(f);
		char[] c = new char[1024];
		int len = r.read(c);
		r.close();
		System.out.println(new String(c,0,len));
	}
}
