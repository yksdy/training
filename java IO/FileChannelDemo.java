import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;

public class FileChannelDemo {
	public static void main(String[] arg) throws Exception {
		String[] info = {"flip","slice","allocate","hasRemaining","put","get","position","linit","capacity"};
		//FileChannel fch = (new FileOutputStream(new File("test.txt"))).getChannel();
		FileChannel fin = (new FileInputStream(new File("test.txt"))).getChannel(); ////11111
		FileChannel fout = (new FileOutputStream(new File("a.txt"))).getChannel();   ///111111
		ByteBuffer bbuf = ByteBuffer.allocate(1024);
		for(int i = 0; i< info.length; i++){
			bbuf.put(info[i].getBytes());
			bbuf.put(" ".getBytes());
			bbuf.put((byte)' ');
		}
		bbuf.clear(); ////1111
		int temp = 0 ;
		while((temp = fin.read(bbuf))!=-1){
			bbuf.flip();
			fout.write(bbuf);
			bbuf.clear();
		}
		//bbuf.flip(); 
		//fch.write(bbuf); 
		//fch.close();
		fin.close();
		fout.close();
		
	}
}
