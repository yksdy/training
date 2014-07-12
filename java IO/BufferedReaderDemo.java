import java.io.*;
public class BufferedReaderDemo {
	public static void main(String[] arg) throws Exception{
		BufferedReader buf1 = new BufferedReader(new FileReader("test.txt"));
		BufferedReader buf2 = new BufferedReader(new InputStreamReader(System.in));
		String str1 = buf1.readLine();
		String str2 = buf2.readLine();
		System.out.println(str1 + str2);
	}
}
