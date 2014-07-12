import java.io.*;
public class PrintStreamDemo {
	public static void main(String[] arg) throws Exception{
		PrintStream ps = new PrintStream(new FileOutputStream(new File("test.txt")));
		ps.printf("I'm PrintStream");
		ps.close();
	}
}
