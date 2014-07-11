import java.io.*;

public class OutputStreamWriterDemo {
	public static void main(String[] arg) throws Exception{
		File f = new File("test.txt");
		Writer w = new OutputStreamWriter(new FileOutputStream(f));
		w.write("I'm OutputStreamWriter");
		w.close();
	}
}
