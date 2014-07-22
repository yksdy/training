import javax.swing.*;
import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class TankPlay_2 extends JFrame implements ActionListener {
	public static void main(String[] arg){
		new TankPlay_2();
	}
	private JMenuBar jmb = null;
	private JMenu jm = null;
	private JMenuItem jmi1 = null;
	private JMenuItem jmi2 = null;
	private MyStartPanel msp = null;
	private MyPanel mp = null;
	TankPlay_2(){
		jmb = new JMenuBar();
		jm = new JMenu("Game");
		jm.setMnemonic('G');
		jmi1 = new JMenuItem("New game");
		jmi1.setMnemonic('N');
		jmi2 = new JMenuItem("Exit");
		jmi2.setMnemonic('E');
		msp = new MyStartPanel();
		jmi1.addActionListener(this);
		jmi1.setActionCommand("newgame");
		jmi2.addActionListener(this);
		jmi2.setActionCommand("exit");
		jm.add(jmi1);
		jm.add(jmi2);
		jmb.add(jm);
		this.add(BorderLayout.NORTH, jmb);
		this.add(BorderLayout.CENTER, msp);
		this.setSize(400,300);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("newgame")) {
			if(MyPanel.isLive == false && MyStartPanel.isLive == true){
				MyStartPanel.isLive = false;
				this.remove(msp);
				mp = new MyPanel();
				this.addKeyListener(mp);
				this.add(BorderLayout.CENTER, mp);
				this.setVisible(true);
				System.out.println("newgame");
			}
			else if(MyPanel.isLive == true && MyStartPanel.isLive == false) {
				MyPanel.isLive  = false;
				this.remove(mp);
				mp = new MyPanel();
				this.addKeyListener(mp);
				this.add(BorderLayout.CENTER, mp);
				this.setVisible(true);
				System.out.println("game new");
			}
		}
		if(e.getActionCommand().equals("exit")) {
			System.exit(0);
		}
	}
}

class MyStartPanel extends JPanel implements Runnable{
	private int time = 0;
	public static boolean isLive = false;
	MyStartPanel(){
		isLive = true;
		Thread t = new Thread(this);
		t.start();
	}
	public void paint(Graphics g){
		super.paint(g);
		if(time%2 == 0) {
			g.setFont(new Font("ËÎÌו",Font.BOLD, 30));
			g.setColor(Color.yellow);
			g.drawString("Levle 1:",100,100);
		}
	}
	public void run() {
		while(true){
			try{
				Thread.sleep(400);
				}catch (Exception e){
				}
			time++;
			this.repaint();
			if(isLive == false){
			break;
			}
		}
	}
	
}

class MyPanel extends JPanel implements KeyListener, Runnable{
	public static boolean isLive = false;
	MyTank mt = new MyTank(100,100,1); //
	EnemyTank et = new EnemyTank(50,50,2); //

	Image img1 = null;
	Image img2 = null;
	Image img3 = null;

	MyPanel(){
		isLive = true;
		Thread t = new Thread(this);
		t.start();	
		try{
		img1 = ImageIO.read(new File("bomb_1.gif"));
		img2 = ImageIO.read(new File("bomb_2.gif"));
		img3 = ImageIO.read(new File("bomb_3.gif"));
			} catch(Exception e){
				}
	}
		public void run() {
			while(true){
				try {
					Thread.sleep(800);
				}catch (Exception e){
					}
				//this.repaint();
				if(this.isLive == false){
					break;
				}
			}
		}
	public void paint(Graphics g){

		super.paint(g);
		drawMyTank(mt,g);
		drawEnemyTank(et,g);
		drawBomb(g);
	}
	public synchronized void drawBomb(Graphics g) {
		int x = (int)(Math.random()*200+100);
		int y = (int)(Math.random()*100+100);
	//	synchronized(this){
	for(int i=0;i<15;i++){
		System.out.println("i="+i);	
		if(i<4){
			//	g.drawImage(image1, b.x, b.y, 30, 30, this);
				g.drawImage(img3,x,y,30,30,this);
			}
		else
			if(i<8){
				//g.drawImage(null,x,y,30,30,this);
				g.drawImage(img2,x,y,30,30,this);
			//	System.out.println("6666666");
			}
		else
			if(i<12){
				//g.drawImage(null,x,y,30,30,this);
				g.drawImage(img1,x,y,30,30,this);
			}
		//}
		}
	}
	public void drawEnemyTank(EnemyTank et, Graphics g) {
		g.setColor(Color.yellow);
		drawTank(et,g);
		drawEnemyTankBullet(et,g);
		
	}
	public void drawMyTank(MyTank mt, Graphics g){
		g.setColor(Color.blue);
		drawTank(mt,g);
		drawMyTankBullet(mt,g);
		g.fillOval(50,50,5,5); //	
	}
	public void drawMyTankBullet(Tank t, Graphics g) {
		MyTank tb = (MyTank)t;
		g.setColor(Color.green);
		for(int i = 0; i< tb.vb.size(); i++){
			if(tb.vb.get(i).isLive == true){
		//		System.out.println("--drawBullet--this.vb.size() = --------"+ tb.vb.size());
				g.fillOval(tb.vb.get(i).x,tb.vb.get(i).y, 3,3);
			}
			else {
				tb.vb.remove(i);
			}	
		}		
	}
	public void drawEnemyTankBullet(Tank t, Graphics g){
		EnemyTank tb = (EnemyTank)t;
		g.setColor(Color.red);
		for(int i = 0; i< tb.vb.size(); i++){
			if(tb.vb.get(i).isLive == true){
		//		System.out.println("--drawBullet--this.vb.size() = --------"+ tb.vb.size());
				g.fillOval(tb.vb.get(i).x,tb.vb.get(i).y, 3,3);
			}
			else {
				tb.vb.remove(i);
			}		
		}
			
	}
	public void drawTank(Tank t, Graphics g){
		//MyTank mtl = (MyTank)t;
		int x = t.x;
		int y = t.y;
		switch(t.direct){
		case 0:
			g.fill3DRect(x, y, 5, 30,false);
			g.fill3DRect(x+15,y , 5, 30,false);
			g.fill3DRect(x+5,y+5 , 10, 20,false);
			g.fillOval(x+5, y+10, 10, 10);
			g.drawLine(x+10, y+15, x+10, y);
			break;
		case 1:
			g.fill3DRect(x, y, 30, 5,false);
			g.fill3DRect(x, y+15, 30, 5, false);
			g.fill3DRect(x+5, y+5, 20, 10, false);
			g.fillOval(x+10, y+5, 10, 10);
			g.drawLine(x+15, y+10, x+30, y+10);
			break;
		case 2:
			g.fill3DRect(x, y, 5, 30,false);
			g.fill3DRect(x+15,y , 5, 30,false);
			g.fill3DRect(x+5,y+5 , 10, 20,false);
			g.fillOval(x+5, y+10, 10, 10);
			g.drawLine(x+10, y+15, x+10, y+30);
			break;
		case 3:
			g.fill3DRect(x, y, 30, 5,false);
			g.fill3DRect(x, y+15, 30, 5, false);
			g.fill3DRect(x+5, y+5, 20, 10, false);
			g.fillOval(x+10, y+5, 10, 10);
			g.drawLine(x+15, y+10, x, y+10);
			break;
			
		}
	}
	public void keyPressed(KeyEvent arg0) {
		System.out.println("--keyPressed--keyPressed --------"+KeyEvent.VK_D);
		System.out.println("--keyPressed--keyPressed --------"+arg0.getKeyCode());
		if(arg0.getKeyCode()==KeyEvent.VK_D)
		{
			this.mt.direct=1;
			this.mt.moveRight();
		}else if(arg0.getKeyCode()==KeyEvent.VK_S)
		{
			this.mt.direct=2;
			this.mt.moveDown();
		}else if(arg0.getKeyCode()==KeyEvent.VK_A)
		{
			this.mt.direct=3;
			this.mt.moveLeft();
		}	
		else if(arg0.getKeyCode()==KeyEvent.VK_W)
		{
			this.mt.direct=0;
			this.mt.moveUp();		
		}
		if(arg0.getKeyCode()==KeyEvent.VK_J)
		{
			if(mt.vb.size()<4){
				mt.Shot();
			}
		}
		
		//this.repaint();
	}
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub	
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub		
	}
}

class Tank {
	int x;
	int y;
	int direct;
	int speed;
//	int type = 0;
	Vector<Bullet> vb = new Vector<Bullet>();
	Bullet b = null;
	Tank(){
		}
	Tank(int x, int y) {
		this.x = x;
		this.y = y;
	}
	Tank(int x, int y, int direct) {
		this.x = x;
		this.y = y;
		this.direct = direct;
	}
}
class EnemyTank extends Tank implements Runnable {
	Vector<Bullet> vb = new Vector<Bullet>();
	Bullet b = null;
	EnemyTank(int x, int y) {
		this.x = x;
		this.y = y;
		this.speed =3;
	//	this.type = 1;
		Thread t = new Thread(this);
		t.start();
	}
	EnemyTank(int x, int y, int direct) {
		this.x = x;
		this.y = y;
		this.direct = direct;
		this.speed =3;
		//this.type = 1;
		Thread t = new Thread(this);
		t.start();
	}
	public void run(){
		while(true) {
			int n = (int)(Math.random()*5);
			//System.out.println("----n = --------"+n);
			//System.out.println("----direct = --------"+direct);
			//System.out.println("----this.vb.size() = --------"+this.vb.size());
			
			switch(this.direct){
				case 0:
					if(this.vb.size()<4 && n < 3){
						System.out.println("----b = new Bullet(x+10,y+15,0);--------");
						b = new Bullet(x+10,y+15,0);
						this.vb.add(b);
					}
					for(int i = 0; i< (int)(Math.random()*70);i++){
						if(this.y>10){
							this.y -= this.speed;
						}
						try {
							Thread.sleep(40);
							}catch (Exception e){
								}
					}
					break;
				case 1:
					if(this.vb.size()<4 && n < 3){
						b = new Bullet(x+15,y+10,1);
						this.vb.add(b);
					}
					for(int i = 0; i< (int)(Math.random()*70);i++){
						if(this.x<380){
							this.x += this.speed;
						}
						try {
							Thread.sleep(40);
							}catch (Exception e){
								}
					}
					break;
				case 2:
					if(this.vb.size()<4 && n < 3){
						b = new Bullet(x+10,y+15,2);
						this.vb.add(b);
					}
					for(int i = 0; i< (int)(Math.random()*70);i++){
						if(this.y<280){
							this.y += this.speed;
						}
						try {
							Thread.sleep(40);
							}catch (Exception e){
								}
					}
					break;
				case 3:
					if(this.vb.size()<4 && n < 3){
						b = new Bullet(x+15,y+10,3);
						this.vb.add(b);
					}
					for(int i = 0; i< (int)(Math.random()*70);i++){
						if(this.x>20){
							this.x -= this.speed;
						}
						try {
							Thread.sleep(40);
							}catch (Exception e){
								}
					}
					break;
			}
			this.direct = (int)(Math.random()*4);
		}
	}
}
class MyTank extends Tank {
	Vector<Bullet> vb = new Vector<Bullet>();
	Bullet b = null;
	MyTank(int x, int y) {
		this.x = x;
		this.y = y;
		this.speed = 3;
	//	this.type =0;
	}
	MyTank(int x, int y, int direct){
		this.x = x;
		this.y = y;
		this.direct = direct;
		this.speed =3;
	//	this.typw = 0;
	}
	public void Shot() {
		switch(direct){
			case 0:
				b = new Bullet(this.x+10,this.y+15,0);
				vb.add(b);
				break;
			case 1:
				b= new Bullet(this.x+15,this.y+10,1);
				vb.add(b);
				break;
			case 2:
				b = new Bullet(this.x+10,this.y+15,2);
				vb.add(b);
				break;
			case 3:
				b = new Bullet(this.x+15,this.y+10,3);
				vb.add(b);
				break;
			}
	}
	public void moveUp(){
		if(this.y>=0)
		this.y -= this.speed;
	}
	public void moveDown(){
		if(this.y<=400)
		this.y += this.speed;
	}
	public void moveLeft(){
		if(this.x>=0)
		this.x -= this.speed;
	}
	public void moveRight() {
		if(this.x<=300)
		this.x += this.speed;
	}
		
}

class Bullet implements Runnable {
	int x;
	int y;
	int direct;
	int speed = 3;
	boolean isLive = false;
	Bullet(int x, int y, int direct){
		this.x = x;
		this.y = y;
		this.direct = direct;
		isLive = true;
		Thread t = new Thread(this);
		t.start();
	}
	public void run() {
		while(true){
			try{
				Thread.sleep(30);
				}
			catch (Exception e){
				}
			switch(this.direct)
				{
				case 0:
					//if(y>0)
						y -= speed;
					break;
				case 1:
					//if(x<400)
						x += speed;
					break;
				case 2:
					//if(y<300)
						y += speed;
					break;
				case 3:
					//if(x>0)
						x -= speed;
					break;
				}
			if(y>300||y<0||x>400||x<0){
				this.isLive = false;
			}
		}
	}
}

