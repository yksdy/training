import java.io.File;
import java.io.FileInputStream;
import java.io.DataInputStream;
import java.io.PrintStream;
import java.io.*;
public class DataInputStreamDemo {
	public static void main(String[] arg) throws Exception {
		DataInputStream dis = new DataInputStream(new FileInputStream(new File("test.txt")));
		String name = null;
		float price = 0.0f;
		int num = 0;
		char[] temp = null;
		char c = 0;
		int len = 0;
		PrintStream ps = System.out;
		//try{
			//while(true){
				//while((c=dis.readChar())!= '\t'){
				//	temp[len] = c;
				//	len++;
				//}
				c=dis.readChar();
				name = new String(temp,0,len);
				price = dis.readFloat();
				dis.readChar();
				num = dis.readInt();
				dis.readChar();
				ps.printf("name = %c price = %f num = %d", c, price, num);
			//}
		//}catch(Exception e){}
		System.out.printf("name = %s price = %f num = %d", name, price, num);
		dis.close();
	ps.close();
	}
}
