import java.net.URLEncoder;
import java.net.URLDecoder;

public class CodeDemo {
	public static void main(String[] arg) throws Exception {
		String str = "√…≥Ø—Ù";
		String encode = URLEncoder.encode(str,"UTF-8");
		System.out.println("encode :"+ encode);
		System.out.println("decode :"+ URLDecoder.decode(encode,"UTF-8"));
		
	}
}