import java.io.File;
import java.io.Writer;
import java.io.FileWriter;
public class WriterDemo {
	public static void main(String[] arg) throws Exception{
		File f = new File("test.txt");
		Writer w = null;
		w = new FileWriter(f,true);
		//w = new FileWriter(f);
		w.write("\rI'm /n\n\n\nwriter hahaha");
		w.flush();
	//	w.close(); //使用缓存,不关闭不输出
	}
}
