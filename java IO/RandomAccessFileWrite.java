import java.io.File;
import java.io.RandomAccessFile;
public class RandomAccessFileWrite{
	public static void main(String[] args)throws Exception{
		RandomAccessFile raf = new RandomAccessFile("test.txt","rw");
		String name = null;
		int age = 0;

		name = "zhangsan";
		age = 20;
		raf.writeBytes(name);
		raf.writeInt(age);
		name = "lisi";
		age = 24;
		raf.writeBytes(name);
		raf.writeInt(age);
		name = "wangwu";
		age = 32;
		raf.writeBytes(name);
		raf.writeInt(age);

		raf.close();
	}
}
