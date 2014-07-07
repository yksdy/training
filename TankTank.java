import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

import javax.swing.*;

public class TankTank extends JFrame implements ActionListener {
	public static void main(String[] args){
		new TankTank();
	}	
	public Point p = new Point(400,300);
	public Dimension dim = new Dimension(600,400);
	public MyStartPanel msp = null;
	public MyPanel mp = null;
	public JMenuBar jmb = null;
	public JMenu jm = null;
	public JMenuItem jmi1 = null;
	public JMenuItem jmi2 = null;
	public JMenuItem jmi3 = null;
	public Thread t = null;

	TankTank(){
		msp = new MyStartPanel();
		//Thread t=new Thread(msp);
		//t.start();
		jmb = new JMenuBar();
		jm = new JMenu("Game");
		jmi1 = new JMenuItem("New game");
		jmi2 = new JMenuItem("Continue game");
		jmi3 = new JMenuItem("exit");	
		
		jm.add(jmi1);
		jm.add(jmi2);
		jm.add(jmi3);
		jmb.add(jm);
		this.add(BorderLayout.NORTH,jmb);
		this.add(BorderLayout.CENTER,msp);

		jmi1.addActionListener(this);
		jmi1.setActionCommand("newgame");
		jmi2.addActionListener(this);
		jmi2.setActionCommand("gamenew");
		jmi3.addActionListener(this);
		jmi3.setActionCommand("exit");

		this.setTitle("TankTank");
		this.setSize(dim);
		this.setLocation(p);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("exit")){
			System.exit(0);
		}
		else if(e.getActionCommand().equals("newgame")){
			
			if(MyStartPanel.isLive == true && MyPanel.isLive == false){
				this.remove(msp);
				MyStartPanel.isLive = false;
				mp = new MyPanel();
				this.addKeyListener(mp);
				this.add(BorderLayout.CENTER,mp);
				this.setVisible(true);
				t = new Thread(mp);
				t.start();
			}
			else if(MyStartPanel.isLive == false && MyPanel.isLive == true){
				t.stop();
				this.remove(mp);
				mp = new MyPanel();
				this.addKeyListener(mp);
				this.add(BorderLayout.CENTER,mp);
				this.setVisible(true);
				t = new Thread(mp);
				t.start();
			}		
			
		}
	}
	
}

class MyStartPanel extends JPanel implements Runnable{
	private boolean a = false;
	public static boolean isLive = false;
	public int age = 0;
	MyStartPanel(){
		Thread t = new Thread(this);
		t.start();
		isLive = true;
	}
	public void paint(Graphics g){
		super.paint(g);
		g.setColor(Color.blue);
		g.setFont(new Font("ËÎÌו",Font.BOLD,30));
		if(a)
			g.drawString("Welcome",220,150);
		a = !a;
	}
	public void run(){
		while(true){
			try{
				Thread.sleep(500);
			}catch (Exception e){
				}
			repaint();
			System.out.println("MyStartPanel age is: "+ age);
			age++;
			if(isLive == false)
				break;
		}
	}
}
class MyPanel extends JPanel implements Runnable,KeyListener{
	public static boolean isLive = false;
	public int age = 0;
	public MyTank mt = null;
	
	MyPanel(){
		isLive = true;
		mt = new MyTank(200,100);
	//	Thread t = new Thread(this);
	//	t.start();
	}
	public void paint(Graphics g){
		super.paint(g);
		paintMyTank(mt,g);
	}
	public void paintMyTank(MyTank mt, Graphics g){
		paintTank(mt.x,mt.y,g,mt.direct,mt.type);
		g.setColor(Color.red);
		if(mt.vb!=null){
			for(int i = 0; i< mt.vb.size(); i++){
				mt.b = mt.vb.get(i);
				if(mt.b.isLive == true){
					g.fillOval(mt.b.x,mt.b.y,3,3);
				}
				else{
					mt.vb.remove(i);
				}
			}
		}
	}
	public void paintTank(int x,int y,Graphics g,int direct,int type)
	{
		switch(type)
		{
		case 0:
			g.setColor(Color.cyan);
			break;
		case 1:
			g.setColor(Color.yellow);
			break;
		}
		
		switch(direct)
		{
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
	public void run(){
		while(true){
			try{
				Thread.sleep(300);
			}catch (Exception e){
				}
			System.out.println("MyPanel age is ::"+ age);
			age++;
			this.repaint();
			if(isLive == false)
				break;
		}
	}		
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode()==KeyEvent.VK_W)
		{
			this.mt.setDirect(0);
			this.mt.moveUp();
			
		}else if(arg0.getKeyCode()==KeyEvent.VK_D)
		{
			this.mt.setDirect(1);
			this.mt.moveRight();
		}else if(arg0.getKeyCode()==KeyEvent.VK_S)
		{
			this.mt.setDirect(2);
			this.mt.moveDown();
		}else if(arg0.getKeyCode()==KeyEvent.VK_A)
		{
			this.mt.setDirect(3);
			this.mt.moveLeft();
		}
		
		if(arg0.getKeyCode()==KeyEvent.VK_J)
		{
			if(mt.vb==null)
			{
				this.mt.shotEnemy();
			}else if(this.mt.vb.size()<=4)
			{
				this.mt.shotEnemy();
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
	public int x;
	public int y;
	public int type;
	public int speed;
	public int direct;
	public boolean isLive;
	public int bulletNum;
	//public Vector<Bullet> vb = null;
	//public Bullet b = null;
	public void setDirect(int direct){
		this.direct = direct;
	}
}

class MyTank extends Tank {
	Vector<Bullet> vb=new Vector<Bullet>();
	Bullet b=null;

	MyTank(int x, int y){
		this.x = x;
		this.y =y;
		this.speed = 3;
		this.type = 0;
		this.direct =0;
	}
	MyTank(int x, int y, int speed, int direct ){
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.direct = direct;
		this.type = 0;
	}
	public void shotEnemy()
	{	
		switch(this.direct)
		{
		case 0:
			b=new Bullet(x+10,y,0);
			vb.add(b);
			break;
		case 1:
			b=new Bullet(x+30,y+10,1);
			vb.add(b);
			break;
		case 2:
			b=new Bullet(x+10,y+30,2);
			vb.add(b);
			break;
		case 3:
			b=new Bullet(x,y+10,3);
			vb.add(b);
			break;
			
		}
		//Thread t=new Thread(b);
		//t.start();
		
	}
	public void moveUp(){
		this.y -= speed;
	}
	public void moveDown(){
		this.y += speed;
	}
	public void moveRight(){
		this.x += speed;
	}
	public void moveLeft(){
		this.x -= speed;
	}
}

class Bullet implements Runnable{
	int age = 1;
	public int x ;
	public int y;
	public int direct;
	public int speed;
	public boolean isLive;
	Bullet(int x, int y){
		this.x = x;
		this.y = y;
		this.direct = 0;
		this.speed = 2;
		this.isLive = true;
		//Thread t = new Thread(this);
		//t.start();
	}
	Bullet(int x, int y, int direct){
		this.x = x;
		this.y = y;
		this.direct = direct;
		this.speed = 5;
		this.isLive = true;
		Thread t = new Thread(this);
		t.start();
	}
	public void run(){
		while(true){
			try{
				Thread.sleep(200);
			}catch (Exception e){
				}
			switch(direct){
			case 0:
				this.y -= this.speed;
				break;
			case 1:
				this.x += this.speed;
				break;
			case 2:
				this.y += this.speed;
				break;
			case 3:
				this.x -= this.speed;
				break;
			}
			age++;
			System.out.println("Bullet age "+age);
			if(this.x>600||this.x<0||this.y<0||this.y>400)
				this.isLive = false;
			if(this.isLive == false)
				break;
		}
	}
}

