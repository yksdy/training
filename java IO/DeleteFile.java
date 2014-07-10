import java.io.File;
import java.io.IOException;
public class DeleteFile{
	public static void main(String[] args){
		File f = new File("testt.txt");
		if(f.exists()){
			f.delete();
		}else{
			try{
				System.out.println("createNewFile");
				f.createNewFile();
				System.out.println(f);
				}catch (Exception e){
				 e.printStackTrace();
				}
		}
	}
}
