import java.io.File;
import java.io.OutputStream;
import java.io.FileOutputStream;

public class OutputStreamDemo{
	public static void main(String[] arg)throws Exception{
		File f = new File("test.txt");
		OutputStream ops = null;
		//ops = new FileOutputStream(f); //cover ,  don't  append
		ops = new FileOutputStream(f,true); //  append
		String str = "\r\nappend FileOutputStream";
		byte[] b = str.getBytes();
		ops.write(b);
		ops.close(); //没使用缓存, 不关闭也可输出
	}
}
