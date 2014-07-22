import java.io.*;
public class PipedInputStreamOutputStream {
	public static void main(String[] arg) throws Exception{
		Send s = new Send();
		Reciver r = new Reciver();
		s.getPos().connect(r.getPis());
	//	r.getPis().connect(s.getPos());
		new Thread(s).start();
		new Thread(r).start();
		
	}
}
class Send implements Runnable{
	private PipedOutputStream pos = null;
	Send(){
		this.pos = new PipedOutputStream();
	}
	public PipedOutputStream getPos(){
		return this.pos;
	}
	public void run(){
		try{
			String s = "I'm Piped Input/Output Stream";
			this.pos.write(s.getBytes());
			pos.close();
		}
		catch (IOException e){
			e.printStackTrace();
		}
	}
}
class Reciver implements Runnable{
	private PipedInputStream pis = null;
	Reciver(){
		this.pis = new PipedInputStream();
	}
	public PipedInputStream getPis(){
		return this.pis;
	}
	public void run(){
		try{
			byte[] b = new byte[1024];
			int len = pis.read(b);
			pis.close();
			System.out.println(new String(b,0,len));
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	
}
