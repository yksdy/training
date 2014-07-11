import java.io.*;

public class InputStreamReaderDemo {
	public static void main(String[] arg) throws Exception{
		File f = new File("test.txt");
		Reader r = new InputStreamReader(new FileInputStream(f));
		char[] str = new char[1024];
		int len = r.read(str);
		r.close();
		System.out.print(str);
	}
}
