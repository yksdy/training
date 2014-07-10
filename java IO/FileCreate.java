import java.io.File;
import java.io.IOException;
public class FileCreate {
	public static void main(String[] args){
		//File file = new File("C:\\Users\\sky042449\\Documents\\GitHu\\training\\java IO\\test.txt"); //Error
		//File file = new File("testt.txt");  //ok
		//File file = new File("F:\\test.txt");  //ok
		//File file = new File("\\a\\testt.txt"); //Error
		try{
			file.createNewFile();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}