import java.util.*;
public class ScannerDemo {
	public static void main(String[] arg) throws Exception {
		Scanner scan = new Scanner(System.in);
		//scan.useDelimiter("\n");
		//String str = scan.next();
		//System.out.println(str);
		if(scan.hasNextInt()){
			System.out.println(scan.nextInt());
		}
		if(scan.hasNextFloat()){
			System.out.println(scan.nextFloat());
		}
	}
}
