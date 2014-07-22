import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.Writer;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.Scanner;

public class JavaIOReview {
	public static void main(String[] arg) throws Exception {
			file();
		}	
	public static void file() throws Exception{	
		File f3 = new File("e.txt");
		File f4 = new File("test");
		File f5 = new File(f3,"abc.txt");
		File f1 = new File(f4,"test.txt");  //separator
		File f2 = new File(f4,"testt.txt"); //separator
		f3.mkdir();
		if(f1.exists() && f2.exists()){
			f1.delete();
			f2.delete();
			}
		else{
			f1.createNewFile();
			f2.createNewFile();
			}
		if(f3.isDirectory())
			// f3.delete();  //delete folder
			f5.createNewFile();
		File[] list = f4.listFiles();
		String[] str = f3.list();
		for(int i = 0; i<list.length; i++){
			System.out.println(list[i]);
		}
		for(int i = 0; i<str.length; i++){
			System.out.println(str[i]);
		}
		
		//RandomAccessFile 
	}
	public static void a(){
	}	
}