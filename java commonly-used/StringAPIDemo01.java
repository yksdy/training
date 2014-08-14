
/**
char[] to String   public String (char[] value)   public String(char[] value , int offset , int count)
String to char[]    public char[] toCharArray()
*/
public class StringAPIDemo01 {
	public static void main(String[] args){
		String str1 = "Hello, world";
		char a[] = str1.toCharArray();
		for(char x: a){
			System.out.print(" "+x);
		}
		System.out.println(" ");
		String str2 = new String(a); 
		System.out.println("str2 = "+ str2);
		String str3 = new String(a, 2,5);
		System.out.println("str3 = "+ str3);
	}
}
