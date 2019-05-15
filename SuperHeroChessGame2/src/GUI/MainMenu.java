  package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class MainMenu  extends JFrame implements ActionListener{
	JButton start = new JButton ();
	JLabel Image ;
	JLabel p1 =new JLabel();
	JLabel p2 = new JLabel ();
	JLabel name1 = new JLabel ();
	static JTextField nameBar= new JTextField ();
	static	JTextField nameBar2 = new JTextField();
	JTextField nameofgame = new JTextField ();
	JPanel nameframe = new JPanel () ;
	JTextField Error ;
	String c ;
	static String  y = nameBar.getText();
	JLabel l = new JLabel ();
	//JLabel bg=new JLabel(new ImageIcon("E:\\The GAME\\SHC_M2\\mmg.jpg"));
	Icon bg = new ImageIcon ("gg.jpg");
	Icon st = new ImageIcon ("play.png");
	

	 static String n = nameBar.getText();;
	public MainMenu () {
		
		setLayout(null);
		setTitle("WorldofWarcraftChess");

		setSize(800,600);
		Image = new JLabel (bg);
		Image.setBounds(0,0,800,600);
		this.add(Image);
		
	
		//setResizable(true);
	//setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//setLayout(new FlowLayout());
		//add(bg);
		//bg.setVisible(true);
		
		p1.setText("Player1:");
		p1.setBounds(400,200,175,50);
		p1.setFont(new Font(Font.MONOSPACED, Font.BOLD,28));
		p1.setForeground(Color.yellow);
		Image.add(p1);
		p2.setText("Player2:");
		p2.setFont(new Font(Font.MONOSPACED, Font.BOLD,28));
		p2.setForeground(Color.yellow);

		p2.setBounds(400,300,175,50);
		Image.add(p2);
	
		start.setBounds(410,450,325,50);
		start.addActionListener(this);
		start.setText("Start Game");
		start.setIcon(st);
		Image.add(start);
		
		nameBar.setBounds(550,215,100,30);
		nameBar.setEditable(true);
		nameBar2.setBounds(550,315,100,30);
		
		Image.add(nameBar2);		
		Image.add(nameBar);	
		l.setText("Please Write Your Name ! ");
		l.setForeground((Color.RED));
		l.setFont(new Font(Font.MONOSPACED, Font.BOLD,28));
		l.setBounds(350,350,450,75);
		Image.add(l);
		l.setVisible(false);
		setVisible(true);

	}
	

	//Music
	public static void music(){
		
		AudioPlayer MGP =AudioPlayer.player;
		AudioStream BGM;
		AudioData MD;
		ContinuousAudioDataStream loop=null;
		
		try{
			BGM= new AudioStream(new FileInputStream("Kalimba.wav"));
		MD=BGM.getData();
		loop= new ContinuousAudioDataStream(MD);
		//MGP.player.start("Kalimba.wav");
		
		}catch(IOException error){
			MGP.start(loop);
		}
	
	
	}









	
	
	
	
	
	
	
	
	
	
	public static void main (String []args)
	{
	MainMenu m= new MainMenu ();
	
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource()==start)
		{
			if(nameBar.getText().equals("")||nameBar2.getText().equals(""))
			{
				
				l.setVisible(true);
			
			}
			else
			{
			final Board b = new Board ();
			this.dispose();
			}
	}
	}

}
