import java.io.*;
public class SystemIODemo {
	public static void main(String[] arg) throws Exception{
		InputStream is = System.in;
		byte[] b = new byte[1024];
		int len = is.read(b);
		System.out.println(new String(b,0,len));
		is.close();

		OutputStream os = System.out;
		os.write("I'm System.out".getBytes());
		os.close();

		System.setOut(new PrintStream(new File("test.txt")));
		System.out.println("I'm setOut System.out");
	}
}
