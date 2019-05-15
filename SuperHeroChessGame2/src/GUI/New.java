package GUI;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class New extends JFrame{
	ImageIcon lol ;
	JLabel l;
	JLabel m;
	JButton b ;
	public New ()
	{
		setSize(1000,800);
		//setLayout(new FlowLayout());
		
		setLayout(null);

		lol = new ImageIcon ("lol.jpeg");
		l = new JLabel (lol);
		l.setBounds(0,0,1000,800);
		this.add(l);
		m=new JLabel ();
		m.setBounds(100,200,200,300);
		m.setText("A7aaaaaa");
		add(m);
		b=new JButton ();
		m.setBounds(100,100,200,300);
		b.setBounds(100,300,100,50);
		add(b);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public static void main (String [] args)
	{
		New n = new New ();
		n.setVisible(true);

	}
	
	
	

}
