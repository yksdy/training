import java.io.File;
import java.io.IOException;
public class FolderCreate{
	public static void main(String[] args){
		File f = new File("test");//create floder
		f.mkdir();
		if(f.isDirectory())
			System.out.println("Directory");
		else
			System.out.println("Not Derectory");
		
		//File f1 = new File("F:\\");
		File f1 = new File("F:"+File.separator+"java_test"); //separator  pathSeparator
		/*
		String[] str = f1.list();   //list file 
		for (int i =0; i< str.length;i++){
			System.out.println(str[i]);
		}
		
		File[] file = f1.listFiles(); //list file add path
		for(int i =0; i<file.length; i++){
			System.out.println(file[i]);
		}
		*/
		fprint(f1);
	}
	public static void  fprint(File f){
		if(f.isDirectory()){
			if(f.listFiles()!=null){
				for(int i=0; i<f.listFiles().length; i++)
					fprint((f.listFiles())[i]);
				System.out.println(f);
					
			}
		}
		else{
			System.out.println(f);
		}
	}
}
