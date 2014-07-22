import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TankPlay extends JFrame implements ActionListener {
	public static void main(String[] args){
		new TankPlay();
	}
	Point p = new Point(200,200);
	Dimension dim = new Dimension(400,300);
	JMenuBar jmb = null;
	JMenu jm = null;
	JMenuItem jmi1 = null;
	JMenuItem jmi2 = null;
	JMenuItem jmi3 = null;

	TankPlay(){
		jmi1 = new JMenuItem("new game");
		jmi2 = new JMenuItem("con game");
		jmi3 = new JMenuItem("exit");
		jm = new JMenu("TankPlay");
		jmb = new JMenuBar();

		jm.add(jmi1);
		jm.add(jmi2);
		jm.add(jmi3);
		jmb.add(jm);
		jmi1.addActionListener(this);
		jmi1.setActionCommand("newgame");
		jmi2.addActionListener(this);
		jmi2.setActionCommand("gamenew");
		jmi3.addActionListener(this);
		jmi3.setActionCommand("exit");
		this.add(BorderLayout.NORTH, jmb);

		this.setVisible(true);
		this.setTitle("TankWar");
		this.setLocation(p);
		this.setSize(dim);
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
