import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TankGame extends JFrame implements ActionListener {
	public static void main(String[] args){
		new TankGame();
	}
	Point p = new Point(200,200);
	Dimension dim = new Dimension(400,300);
	JMenuBar jmb = null;
	JMenu jm = null;
	JMenuItem jmi1 = null;
	JMenuItem jmi2 = null;
	JMenuItem jmi3 = null;
	MyStartPanel msp = null;
	MyPanel mp = null;
	StartMusic sm = new StartMusic();
	TankGame(){
		jmb = new JMenuBar();
		jm = new JMenu("Game");
		jmi1 = new JMenuItem("newgame");
		jmi2 = new JMenuItem("gamenew");
		jmi3 = new JMenuItem("exit");
		msp = new MyStartPanel();
		sm.start();
		jmb.add(jm);
		jm.add(jmi1);
		jm.add(jmi2);
		jm.add(jmi3);
		this.add(BorderLayout.NORTH, jmb);
		this.add(BorderLayout.CENTER, msp);
		jmi1.addActionListener(this);
		jmi2.addActionListener(this);
		jmi3.addActionListener(this);
		jmi1.setActionCommand("newgame");
		jmi2.setActionCommand("gamenew");
		jmi3.setActionCommand("exit");
		this.setTitle("TankGame");
		this.setLocation(p);
		this.setSize(dim);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("newgame")){
			System.out.println("newgame");
		}
		else if(e.getActionCommand().equals("gamenew")){
			System.out.println("gamenew");
		}
		else if(e.getActionCommand().equals("exit")){
			System.out.println("exit");
			System.exit(0);
		}
	}
	
	
	
}
class StartMusic extends Thread{
	String fileName = null;
	StartMusic(Sting fileName){
		this.fileName = fileName;
	}
	public void run(){
		while(true){
		}
	}
}
class MyStartPanel extends JPanel implements Runnable{
	static boolean isLive = false;
	boolean flash = false;

	MyStartPanel(){
		isLive = true;
		Thread t = new Thread(this);
		t.start();
	}

	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.yellow);
		g.setFont(new Font("ËÎÌו",Font.BOLD, 30));
		if(flash == false){
			g.drawString("Welcom to Tank World ",30,100);
		}
		flash = !flash;
	}
	public void run(){
		while(true){
			try{
				Thread.sleep(500);
				}
			catch (Exception e){
				}
			repaint();
			if(isLive == false)
				break;
		}
	}
}
class MyPanel extends JPanel{
}
class Tank{
	int x;
	int y;
	int type;
	int direct;
	int speed;
	boolean isLive = false;
}


