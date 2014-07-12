import java.io.*;

public class JavaIOTest {
	public static void main(String[] arg) throws Exception{
		new Menu();
	}
}

class Menu {
	Menu() throws Exception{
		while(true){
			show();
		}
	}
	public void show() throws Exception{
		System.out.println("---------Xxx System------");
		System.out.println("---------[1] Add data------");
		System.out.println("---------[2] Delete data------");
		System.out.println("---------[3] Update data------");
		System.out.println("---------[4] find data------");

		//BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		//int i = Integer.parseInt(buf.readLine());
		InputData input = new InputData();
		int i = input.getInt("Please input Number:","not number");

		switch(i){
		case 1:
			Operate.add();
			break;
		case 2:
			Operate.delect();
			break;
		case 3:
			Operate.update();
			break;
		case 4:
			Operate.find();
			break;
		default:
			System.out.println("illegel input");
			break;
		}
	}
}
class Operate {
	public static void add(){
		System.out.println("----add data");
	}
	public static void delect(){
		System.out.println("----delect data");
	}
	public static void update(){
		System.out.println("----update data");
	}
	public static void find(){
		System.out.println("----find data");
	}
}
class InputData {
	private BufferedReader buf = null;
	InputData() throws Exception{
		buf = new BufferedReader(new InputStreamReader(System.in));
	}
	public String getString(String input) throws Exception{
		System.out.println(input);
		return buf.readLine();
	}
	public int getInt(String input, String err) throws Exception{
		int t = 0;
		String str = null;
		boolean flag = true;
		while(flag){
			str = getString(input);
			if(str.matches("^\\d+$")){
				t = Integer.parseInt(str);
				flag = false;
			}else{
			System.out.println(err);
			}
		}
		return t;
	}
}
