import java.io.File;
import java.io.FileOutputStream;
import java.io.DataOutputStream;

public class DataOutputStreamDemo {
	public static void main(String[] arg) throws Exception{
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File("test.txt")));
		String[] names = {"shirt","pants","shoes"};
		float[] prices = {7.9f, 8.2f, 9,4f};
		int[] nums = {2,2,2};
		for(int i = 0; i < names.length; i++){
			dos.writeChars(names[i]);
			dos.writeChar('\t');
			//dos.writeFloat(prices[i]);
			dos.writeFloat(23.1f);
			dos.writeChar('\t');
			//dos.writeInt(nums[i]);
			dos.writeInt(3);
			dos.writeChar('\n');
		}
		dos.close();
	}
}
