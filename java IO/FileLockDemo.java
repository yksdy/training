import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class FileLockDemo {
	public static void main(String[] arg) throws Exception {
		File file = new File("test.txt");
		FileChannel fcout = (new FileOutputStream(file,true)).getChannel();
		FileLock lock = fcout.tryLock();
		if(lock!=null){
			System.out.println(file.getName() + " file lock 5 sec");
			Thread.sleep(5000);
			lock.release();
			System.out.println(file.getName() + " file release ");
		}
		fcout.close();
	}
}
