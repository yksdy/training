import java.io.*;

public class ByteArrayOutputStreamInputStreamDemo {
	public static void main(String[] arg){
		String str = "BYTEARRAYOUTPUTSTREAMDEMO";
		String in =null;

		OutputStream bos = new ByteArrayOutputStream();
		InputStream  bis = new ByteArrayInputStream(str.getBytes());
		int temp = 0;
		try{
		while((temp = bis.read())!= -1){
			char c = (char)temp;
			bos.write(Character.toLowerCase(c));
		}
		in = new String(bos.toString());
		
			bos.close();
			bis.close();
		}catch (IOException e){
		e.printStackTrace();
		}
		System.out.println(in);
	}
}

