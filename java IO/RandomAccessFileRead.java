import java.io.File;
import java.io.RandomAccessFile;
public class RandomAccessFileRead {
	public static void main(String[] args)throws Exception{
		RandomAccessFile raf = new RandomAccessFile("test.txt","rw");

		String name = null;
		int age = 0;
		byte[] b = new byte[8];

		raf.read(b);
		System.out.println(new String(b));
		raf.skipBytes(8);
		System.out.println(raf.readInt());

		raf.close();
	}
}
