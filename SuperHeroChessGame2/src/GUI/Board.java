package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import exceptions.InvalidPowerDirectionException;
import exceptions.InvalidPowerTargetException;
import exceptions.OccupiedCellException;
import exceptions.PowerAlreadyUsedException;
import exceptions.UnallowedMovementException;
import exceptions.WrongTurnException;
import model.game.Direction;
import model.game.Game;
import model.game.Player;
import model.pieces.Piece;
import model.pieces.heroes.ActivatablePowerHero;
import model.pieces.heroes.Armored;
import model.pieces.heroes.Medic;
import model.pieces.heroes.Ranged;
import model.pieces.heroes.Speedster;
import model.pieces.heroes.Super;
import model.pieces.heroes.Tech;
import model.pieces.sidekicks.SideKick;

public class Board extends JFrame implements ActionListener{
	//InputStream input = classLoader.getResourceAsStream("oval.jpg");
	Icon background = new ImageIcon ("hhh.jpg");
	Icon Armor1 = new ImageIcon ("fordring.jpg");
	Icon Armor1down = new ImageIcon ("fordring.jpg");
	Icon Armor2 = new ImageIcon ("lichking.jpg");
	Icon Armor2down = new ImageIcon ("lichking.jpg");
	Icon Speed1=new ImageIcon("maiev.jpg");
	Icon Speed2 = new ImageIcon ("ill.jpg");
	Icon Medic1=new ImageIcon("ando.jpg");
	Icon Medic2=new ImageIcon("kel.jpg");
	Icon tech1=new ImageIcon("archmage.jpg");
	Icon tech2=new ImageIcon("guldan.jpg");
	Icon Super1=new ImageIcon("deathwing.jpg");
	Icon Super2=new ImageIcon("alextraza.jpg");
	Icon Ranged1=new ImageIcon("rex.jpg");
	Icon Ranged2=new ImageIcon("sylvya.jpg");
	Icon sk1 = new ImageIcon ("infernal.jpg");
	Icon sk2 = new ImageIcon ("waterelemental.jpg");
	
	Icon dsk = new ImageIcon ("dinfernal.jpg");
	Icon dsk2 = new ImageIcon ("dsk2.jpg");
	Icon dArmor1 = new ImageIcon ("dfordring.jpg");
	Icon dArmor1down = new ImageIcon ("dfordring.jpg");
	Icon dArmor2 = new ImageIcon ("dlichking.jpg");
	Icon dArmor2down = new ImageIcon ("dlichking.jpg");
	Icon dSpeed1=new ImageIcon("dmaiev.jpg");
	Icon dSpeed2 = new ImageIcon ("dill.jpg");
	Icon dMedic1=new ImageIcon("dmedic1.jpg");
	Icon dMedic2=new ImageIcon("dkel.jpg");
	Icon dtech1=new ImageIcon("darchmage.jpg");
	Icon dtech2=new ImageIcon("dguldan.jpg");
	Icon dSuper1=new ImageIcon("ddeathwing.jpg");
	Icon dSuper2=new ImageIcon("dalextraza.jpg");
	Icon dRanged1=new ImageIcon("drex.jpg");
	Icon dRanged2=new ImageIcon("dsylvya.jpg");
	//Icon Medic1=new ImageIcon("");
	
	// Image lich = ImageIO.read(getClass().getResource("lich.png"));
	private JProgressBar RP ;
	private JProgressBar LP ;
	JTextField nameBar;
	JLabel Gyname1= new JLabel();
	JLabel Gyname2= new JLabel();
	//Icon ta7t=new ImageIcon("down.jpeg");
	//Icon G2p=new ImageIcon("G2.jpeg");
	//Icon fo2=new ImageIcon("up.jpeg");
	Icon fo2=new ImageIcon("up.png");
	Icon yemeen=new ImageIcon("right.png");
	Icon shemal=new ImageIcon("left.png");
	Icon ta7t=new ImageIcon("down.png");
	//Icon yemeen=new ImageIcon("right.jpeg");
	//Icon shemal=new ImageIcon("left.jpeg");
	Icon uright=new ImageIcon("uprightt.png");
	Icon uleft=new ImageIcon("upleftt.png");
	Icon dright=new ImageIcon("downrightt.png");
	Icon dleft=new ImageIcon("downleftt.png");
	Icon upower=new ImageIcon("lol.jpg");
	Icon ok= new ImageIcon("go2.jpg");
	

	
	JPanel control;
	JButton tile;
	JButton test;
	JPanel ChessBoard;
	JButton up = new JButton ();
	JButton down = new JButton ();
	JButton right = new JButton ();
	JButton left = new JButton ();
	JButton upright = new JButton ();
	JButton upleft = new JButton ();
	JButton downleft = new JButton ();
	JButton downright = new JButton ();
private	JButton usepower = new JButton ();
	JButton yala = new JButton ();
	String s = "";
	JButton deadchar=new JButton("Graveyard");
	 ArrayList<JButton> btnsArray = new ArrayList();
	 ArrayList<JButton> controlbuttons = new ArrayList();
	 ArrayList<Piece> piecesArray = new ArrayList();
	 ArrayList<JButton> Gy1Buttons = new ArrayList();
	 ArrayList<JButton> Gy2Buttons = new ArrayList();
	 MainMenu m;

	 Piece techPiece;
		
	int	TselectedPieceIndex ;
	 Direction r;
		Piece selectedPiece;
		String nameDisplay;
	
		int selectedButtonIndex;
	String p1 = m.nameBar.getText();
	String p2 = m.nameBar2.getText();
	Game k=new Game(new Player(p1),new Player(p2));
	JLabel Gy1 ;
	JLabel Gy2 ;
	 int Revindex ;
	 JButton deadcell;
	 JButton deadcell2;
		 Piece RevivedPiece;
		 Piece TselectedPiece;
	 Point Destination ; 
	JButton techButton;
	JButton newLocationButton;
	private JButton[][] arrayofButtons= new JButton[7][6] ;
	
	boolean isUsePowerClicked= false;	
	Icon bg = new ImageIcon ("aa.jpg");
	JLabel master = new JLabel (bg);
	Icon wow = new ImageIcon("ht.jpg");
	JLabel pic = new JLabel();
	

	

	JTextField nameBar2 = new JTextField();
String nameDisplay2 = "";

		public Board()
	{

		setLayout(null);
		setSize(1430,1000);
		master.setBounds(0,0,1500,1000);
		this.add(master);
		pic.setBounds(800	,745,500,300);
		pic.setVisible(true);
		master.add(pic);
		setResizable(false);
		setTitle("World of Warcraft Chess");
	//	setBackground(Color.gray);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		nameBar= new JTextField();
		nameBar.setFont(new Font(Font.MONOSPACED, Font.BOLD, 14));
		nameBar.setBounds(0,0,1500,25);
		nameBar2.setBounds(0,0,1500,25);

		nameBar.setEditable(false);
		
		if(k.getCurrentPlayer()==k.getPlayer1())
		{
		nameDisplay="Player1: "+p1;
		nameBar.setText(nameDisplay);
		nameBar.setBackground(Color.green);

		}
	else{
		if(k.getCurrentPlayer()==k.getPlayer2()){
		nameDisplay2="Player2: "+p2;
		nameBar2.setText(nameDisplay);
		nameBar2.setBackground(Color.blue);
		}}
		
		if(nameBar.getText()==nameDisplay)
		{
			nameBar.setBackground(Color.green);

		}
		else
		{
			if(nameBar.getText()==nameDisplay2)
				nameBar.setBackground(Color.blue);
		}

		
		master.add(nameBar);

	
	Gyname1.setText( p1 +" 's GraveYard" );
	//Gyname1.setEditable(false);
	Gyname1.setBounds(1250,25,150,25);
	Gyname1.setForeground(Color.GREEN);
	master.add(Gyname1);
	
	Gyname2.setText( p2 +" 's GraveYard" );

	Gyname2.setBounds(40,25,150,25);
	master.add(Gyname2);
	Gyname2.setForeground(Color.blue);
	
	
		upleft.addActionListener(this);
		master.add(upleft);
		upleft.setIcon(uleft);
		controlbuttons.add(upleft);
		upleft.setBounds(610,750,75,50);
		upleft.setVisible(true);
		
		master.add(up);
		up.setBounds(680,750,75,50);
		up.addActionListener(this);
		controlbuttons.add(up);
		up.setIcon(fo2);
		
		master.add(upright);
		upright.setBounds(750,750,75,50);
		upright.addActionListener(this);
		controlbuttons.add(upright);
		upright.setIcon(uright);
		
		
		master.add(left);
		left.setBounds(610,800,75,50);
		
		left.setIcon(shemal);
		left.addActionListener(this);
		controlbuttons.add(left);
		
		
		master.add(yala);
		yala.setIcon(ok);
		yala.setBounds(680,800,75,50);
		controlbuttons.add(yala);
		yala.addActionListener(this);
		
		master.add(right);
		right.setBounds(750,800,75,50);
		right.setIcon(yemeen);
	//	control.add(right);
		right.addActionListener(this);
		controlbuttons.add(right);
		
		
		master.add(downleft);
		downleft.setBounds(610,850,75,50);
		downleft.setIcon(dleft);
		downleft.addActionListener(this);
		controlbuttons.add(downleft);
		
		master.add(down);
		down.setBounds(680,850,75,50);
		down.setIcon(ta7t);
	//	control.add(down);
		down.addActionListener(this);
		controlbuttons.add(down);
		master.add(downright);
		downright.setBounds(750,850,75,50);
		downright.setIcon(dright);
	//	control.add(downright);
		downright.addActionListener(this);
		controlbuttons.add(downright);
		
		master.add(usepower);
		usepower.setBounds(825,750,100,150);;
		usepower.setIcon(upower);
	//	control.add(usepower);
		usepower.addActionListener(this);
		controlbuttons.add(usepower);
		//usepower.setBounds(50,950,150,50);
		
		
	
	//control.setLayout(new GridLayout(9, 2));
	
	Gy1=new JLabel();
	Gy1.setLayout(new GridLayout(10,4));
	Gy1.setBounds(1200,50,200,1000);	
	//Gy1.setBackground(Color.gray);
	master.add(Gy1);
	Gy1.removeAll();
	Gy1Buttons.clear();

		for(int j=0;j<k.getPlayer1().getDeadCharacters().size();j++) {
		deadcell=new JButton();
		deadcell.addActionListener(this);
		deadcell.setText(k.getCurrentPlayer().getDeadCharacters().get(j).toString());
		deadcell.setVisible(true);
		Gy1.add(deadcell);	
		Gy1Buttons.add(deadcell);

		}
		
	
		
		
	Gy2=new JLabel();
	Gy2.setBounds(25,50,200,1000);
	Gy2.setLayout(new GridLayout(10,1));
	//Gy2.setBackground(Color.GREEN);
	master.add(Gy2);
	Gy2.removeAll();
	Gy2Buttons.clear();
	
	for(int j=0;j<k.getPlayer1().getDeadCharacters().size();j++) {
		deadcell2=new JButton();
		deadcell2.setPreferredSize(new Dimension(50,100));
		deadcell2.addActionListener(this);
		deadcell2.setText(k.getCurrentPlayer().getDeadCharacters().get(j).toString());
		deadcell2.setVisible(true);
		Gy2.add(deadcell2);	
		Gy2Buttons.add(deadcell2);

		}
		Gy2.setVisible(true);

	
	
	
		 LP=new JProgressBar(LP.VERTICAL,0,6);
		 
		 LP.setForeground(Color.blue);
		 LP.setBounds(0,25,25,1000);
		 LP.setValue(6);
		 master.add(LP);
		 LP.setVisible(true);

		 
		 
		 RP=new JProgressBar(RP.VERTICAL,0,6);
		 RP.setForeground(Color.green);
		 
		 RP.setBounds(1400,25,27,1000);
		 RP.setValue(6);
		 master.add(RP);
		 RP.setVisible(true);
		
		 ChessBoard = new JPanel();
		 ChessBoard.setBounds(242,25,940,720);
		 ChessBoard.setLayout(new GridLayout(0,6));
		 
		 master.add(ChessBoard);
		
	 

	
	 for(int i=0;i<7;i++){
		 for(int j=0;j<6;j++){
			 Piece p = k.getCellAt(i, j).getPiece();
 
			 
			 if(p==null){
			  tile = new JButton(); 
			  tile.addActionListener(this);
			  tile.setIcon(background);
			  piecesArray.add(p);
			  btnsArray.add(tile);
			 ChessBoard.add(tile);
			 arrayofButtons[i][j]=tile;
			 
			 
			 }else{
				 tile= new JButton();
				 tile.addActionListener(this);	 
				 
				 arrayofButtons[i][j]=tile;
				 
				 
				 s = "";
				 
				 if(p.getOwner()==k.getPlayer1()){
					 if(p instanceof SideKick)
					 { 
						 tile.setIcon(sk1);
						 s=p.getName() +"-----"+ "Player:"+ k.getPlayer1().getName()+"------"+ "Type:SideKick";
					 }
					 if(p instanceof Armored)
					 {
						 if(((Armored) p).isArmorUp()==true)
						 {
							 s= p.getName()+"-----" +"Type:Armored" + "-----" + "Player:"+ k.getPlayer1().getName() +"-----" +"Armour Up " ;
							 tile.setIcon(Armor1);
							 
						 }
						 else{
							 tile.setIcon(Armor1down);
							 s= p.getName()+"-----" +"Type:Armored" + "-----" + "Player:"+ k.getPlayer1().getName() +"-----" +"Armour Down " ;
						 }
					 }
					 if(p instanceof Speedster)
					 {
						 tile.setIcon(Speed1);
						 s= p.getName() +"-----" + "Type:Speedster" + "Player:"+ k.getPlayer1().getName();
						 

					 }
					 if(p instanceof ActivatablePowerHero )
					 {
						 if(((ActivatablePowerHero) p).isPowerUsed()==false)
						 {
							 if(p instanceof Medic)
							 { tile.setIcon(Medic1);
							 s= p.getName() + "----- "+ "Type:Medic"+  "-----Player:"+k.getPlayer1().getName() +"-----" + "PowerUsed:No " 
							 +" -------" +"  Special Ability : Resurrects an eliminated friendly" ;
							 }
							 
								 if(p instanceof Super){
									 tile.setIcon(Super1);
								 s= p.getName() +"------" + "Type:Super"+"------"+"Player:"+k.getPlayer1().getName()+"------"+ "PowerUsed:No"+ "---- "
									 +"Special Ability: Super Smashes two adjacent cells in the specified direction, eliminating any enemy pieces within them"; ;
								 }
							 
								 if(p instanceof Ranged){
									 tile.setIcon(Ranged1);
								 s= p.getName() +"-----"+ "Type:Ranged"+"----- "+"Player:"+k.getPlayer1().getName()+"-----"+"PowerUsed:No"+
									 " -----"+ "Special Ability : Eliminates the first enemy piecethat is encountered in the specified direction "; ;
								 }
							 if(p instanceof Tech){
								 tile.setIcon(tech1);
								 s= p.getName() +"-----" + "Type:Tech" + "Player:"+k.getPlayer1().getName() + "-------"+ "PowerUsed:No"+ " ----"+ 
								 " Special Ability : Can do one of the following abilities : Teleporting a friendly piece / Hacking an enemy hero piece / Restoring the ability of another friendly piece" ;	;	
								 }
						}
							 
							 		 
						 
						 else
						 {
							 if(p instanceof Medic){
								 tile.setIcon(Medic1);
								 s= p.getName() +"------" + "Type:Medic" + "Player:"+k.getPlayer1().getName()+"------"+ "PowerUsed:yes"
										 +" -------" +"  Special Ability : Resurrects an eliminated friendly" ;;
								 }
								
									 if(p instanceof Super){
										 tile.setIcon(Super1);
										 s= p.getName() +
									 "\n" + 
											 "Type:Super" + "------"+ "Player:"+k.getPlayer1().getName()+"------"+"PowerUsed:yes"+"-"
											 +"Special Ability: Super Smashes two adjacent cells in the specified direction, eliminating any enemy pieces within them"; ;

									 }
								 
									 if(p instanceof Ranged){
										 tile.setIcon(Ranged1);
										 s= p.getName() +"-----" +"Type:Ranged" +"-----" + "Player:"+k.getPlayer1().getName()+ "------" + "PowerUsed:yes" 
												+ " -----"+ "Special Ability : Eliminates the first enemy piecethat is encountered in the specified direction "; ;;
									 }
								
									 if(p instanceof Tech){
										 tile.setIcon(tech1);
									 s= p.getName() +"------" + "Type:Tech" +"-----"+"Player:"+k.getPlayer1().getName() + "-----" + "PowerUsed:yes" + " ----"+
										 " Special Ability : Can do one of the following abilities : Teleporting a friendly piece / Hacking an enemy hero piece / Restoring the ability of another friendly piece" ;	;	
									 }
								 }
								 }
						 
					 
					 tile.setToolTipText(s + "" );
					 btnsArray.add(tile);
					 piecesArray.add(k.getCellAt(i, j).getPiece());
					 ChessBoard.add(tile);
					 arrayofButtons[i][j]=tile;
					
					
				 }
				 
				 else									
				 {
						 if(p instanceof SideKick)
						 {  tile.setIcon(sk2);
							 s=p.getName() + "-"+"Player:"+ k.getPlayer2().getName()+"-----"+ "Type:SideKick";
						 }
						 if(p instanceof Armored)
						 {
							 if(((Armored) p).isArmorUp()==true)
							 {
								 s= p.getName()+"-----"+"Type:Armored" +"-----"+ "Player:"+ k.getPlayer2().getName()+"----" + "Armour is Up";
								 tile.setIcon(Armor2);
							 }
							 else
							 {
								 s= p.getName() +"-"+ "Type:Armored" +  "-" +"Player:"+ k.getPlayer2().getName() +"-" + "Armour is Down " ;
								 tile.setIcon(Armor2down);
							 }
						 }
						 if(p instanceof Speedster)
						 {
							 s= p.getName() +"-" + "Type:Speedster" + "-" + "Player:"+k.getPlayer2().getName();
							 tile.setIcon(Speed2);
						 }
						 if(p instanceof ActivatablePowerHero )
						 {
							 if(((ActivatablePowerHero) p).isPowerUsed()==false)
							 {
								 if(p instanceof Medic){
									 tile.setIcon(Medic2);
								 s= p.getName() +"-" + "Type:Medic"+  "Player:"+ k.getPlayer2().getName() +"-" + "PowerUsed:No"+" -------" +"  Special Ability : Resurrects an eliminated friendly" ;
								 }
								  
									 if(p instanceof Super){
										 tile.setIcon(Super2);
									 s= p.getName() +"-" + "Type:Super" + "-"+"Player:"+k.getPlayer2().getName() + "-" + "PowerUsed:No"+ "---- "+"Special Ability: Super Smashes two adjacent cells in the specified direction, eliminating any enemy pieces within them"; 
									 }
								 
									 if(p instanceof Ranged){
										 tile.setIcon(Ranged2);
									 s= p.getName() +"-" + "Type:Ranged" + "-----"+ "Player:"+ k.getPlayer2().getName() +"-----" + "PowerUsed:No" + " -----"+ "Special Ability : Eliminates the first enemy piecethat is encountered in the specified direction ";
									 }
								
									 if(p instanceof Tech)
									 {
										 tile.setIcon(tech2);
									 s= p.getName() +"-" + "Type:Tech" + "-----"+"Player:"+ k.getPlayer2().getName()+"-----"+"PowerUsed:No " 
										 + " ----"+ " Special Ability : Can do one of the following abilities : Teleporting a friendly piece / Hacking an enemy hero piece / Restoring the ability of another friendly piece" ;	
									 }
								 }
						 	
							 
							 
						 
				 			
						 if(((ActivatablePowerHero) p).isPowerUsed()==true)
							 {
								 if(p instanceof Medic){
									 tile.setIcon(Medic2);
									 s= p.getName() +"-" + "Type:Medic" + "-----"+"Player:"+ k.getPlayer2().getName() +"-----"+ "PowerUsed:yes" +"-" + "PowerUsed:No"+" -------" +"  Special Ability : Resurrects an eliminated friendly" ;
									 }
									 
										 if(p instanceof Super){
											 tile.setIcon(Super2);
										 s= p.getName() +"-" + "Type:Super" + "-----"+"Player: " + k.getPlayer2().getName() + "-----" + "PowerUsed:yes"+ "-" + "PowerUsed:No"+ "---- "+"Special Ability: Super Smashes two adjacent cells in the specified direction, eliminating any enemy pieces within them"; 
										 }
									 
										 if(p instanceof Ranged){
											 tile.setIcon(Ranged2);
											 s= p.getName() +"-----" + "Type:Ranged" + k.getPlayer2().getName() +"-----" + "PowerUsed:yes " + " -----"+ "Special Ability : Eliminates the first enemy piecethat is encountered in the specified direction ";;
										 }
									
										 if(p instanceof Tech){
											 tile.setIcon(tech2);
										 s= p.getName() +"-----" + "Type:Tech" + k.getPlayer2().getName()+ "-----" + "PowerUsed:yes "+ " ----"+ " Special Ability : Can do one of the following abilities : Teleporting a friendly piece / Hacking an enemy hero piece / Restoring the ability of another friendly piece" ;	
										 }
						
									 	}
									 
								 
								 
						 }
					 
					 tile.setToolTipText(s);
					// tile.setText(k.getCellAt(i, j).getPiece().toString());
					 btnsArray.add(tile);
					 piecesArray.add(k.getCellAt(i, j).getPiece());
					 ChessBoard.add(tile);
					 arrayofButtons[i][j]=tile;
					 
				 }
					 
				 }
			 }
			 LP.setValue(k.getPlayer2().getPayloadPos());
			 RP.setValue(k.getPlayer1().getPayloadPos());
				ChessBoard.setVisible(true);
				setVisible(true);

				if(k.checkWinner()==true)
				{
					if(LP.getValue()==6){
					JOptionPane.showMessageDialog(null,"Congratulations ! ,The Winner is " + p1);
					this.dispose();
					}
					else{
						JOptionPane.showMessageDialog(null,"Congratulations ! ,The Winner is " + p2);
					setVisible(false);
					this.dispose();
					}
				}
			 
		 
	 }

	 
	
	

	
	}	

		int destinationIndex;
		Piece teleportingLoc;
		int xco;
		int yco;
		int x=0;
		
		public static void main (String [] args){
			Board x = new Board ();
			//k.switchTurns();
			//x.setVisible(true);

		}

		
		
		public Point getPoint(JButton x){
			for(int i=0;i<k.getBoardHeight();i++){
				for(int j=0;j<k.getBoardWidth();j++){
					if(arrayofButtons[i][j]==x){
						Point y=new Point(i,j);
					return y;
						
						
					}
				}
			}
	return null;
		
		}
		

		public void actionPerformed(ActionEvent event) {
			JButton selectedButton= (JButton) event.getSource();
			if(btnsArray.contains(selectedButton))
			{
			 selectedButtonIndex= btnsArray.indexOf(selectedButton);
			 selectedPiece= piecesArray.get(selectedButtonIndex);
		//	 JOptionPane.showMessageDialog(null,"selected piece is now tech");
			 
		if(selectedPiece instanceof Tech && isUsePowerClicked==false&& ((Tech) selectedPiece).isPowerUsed()==false){
			techPiece=piecesArray.get(selectedButtonIndex);
			JOptionPane.showMessageDialog(null,"Click on usepower to activate special ability or on Direction to move");
		}
			 
		//teleporting
		if(selectedPiece==null && isUsePowerClicked==true ){
			
			newLocationButton=(JButton) event.getSource();
			destinationIndex= btnsArray.indexOf(newLocationButton);
			teleportingLoc=piecesArray.get(destinationIndex);
			
		//	xco=teleportingLoc.getPosI();
		//	yco=teleportingLoc.getPosJ();
			Destination=getPoint(newLocationButton);
			x=1;
			JOptionPane.showMessageDialog(null,"Please select a friendly hero to teleport");
		//	JOptionPane.showMessageDialog(null,teleportingLoc.toString());
			
		}
		
		try{
		
		if((selectedPiece instanceof ActivatablePowerHero||selectedPiece instanceof Armored) && isUsePowerClicked==true && x==0){
			((ActivatablePowerHero) techPiece).usePower(null,selectedPiece,null);
			isUsePowerClicked=false;
			JOptionPane.showMessageDialog(null,"Your target is now hacked/restored");
			
			
			
		}
		//teleport this piece
		if(selectedPiece instanceof Piece && isUsePowerClicked==true && x==1){
		//	JOptionPane.showMessageDialog(null,"5od");
			((ActivatablePowerHero) techPiece).usePower(null,selectedPiece,Destination);
			isUsePowerClicked=false;
			x=0;
			
			
			
		}
		}catch(Exception ex){
			

			if(ex instanceof NullPointerException)
				JOptionPane.showMessageDialog(null,"Complete your action yabeh");
			if(ex instanceof PowerAlreadyUsedException){
			isUsePowerClicked=false;
				JOptionPane.showMessageDialog(null," PowerAlready used yabeh");
			
			}
			if(ex instanceof InvalidPowerDirectionException)
				JOptionPane.showMessageDialog(null," There is no one to attack yabeh");
			if(ex instanceof InvalidPowerTargetException)
				JOptionPane.showMessageDialog(null," Invalid power target ");
			
			if(ex instanceof WrongTurnException)
				isUsePowerClicked=false;
				JOptionPane.showMessageDialog(null," Wrong turn ya  yabeh");
			
			
		}
		
		
		
			}
			else 
			{
			if(selectedButton==up) 
				r=Direction.UP;
			
			 if(selectedButton==down) 
				r=Direction.DOWN;
			 if(selectedButton==left) 
				r=Direction.LEFT;
			 if(selectedButton==right) 
				r=Direction.RIGHT;
			
			 if(selectedButton==upright) 
				r=Direction.UPRIGHT;
			
			 if(selectedButton==upleft) 
				r=Direction.UPLEFT;
			if(selectedButton==downleft) 
				r=Direction.DOWNLEFT;
			 if(selectedButton==downright) 
				r=Direction.DOWNRIGHT;

			}
				if(selectedButton==yala) 
				{
			
				try {
					
					selectedPiece.move(r);
					
				}
		
				catch(Exception e) 
				{
					
					if(e instanceof NullPointerException)
					JOptionPane.showMessageDialog(null,"nullpointer");
					if(e instanceof WrongTurnException)
						JOptionPane.showMessageDialog(null,"Wrong turn ya beh");
					
					if(e instanceof OccupiedCellException)
						JOptionPane.showMessageDialog(null,"El cell feeha 7ad ya beh");
					
					if(e instanceof UnallowedMovementException)
						JOptionPane.showMessageDialog(null,"Your "+selectedPiece+" cannot move in this direction");
					
				}
				}
			
			else {
				
				
				if(selectedPiece instanceof ActivatablePowerHero){
					
					
					 
					
					if (selectedPiece instanceof Medic)
					 {
						 
						 if(k.getCurrentPlayer()==k.getPlayer1())
						 {
							 if(Gy1Buttons.contains(selectedButton))
							 {
								  Revindex = Gy1Buttons.indexOf(selectedButton);
								 RevivedPiece = k.getPlayer1().getDeadCharacters().get(Revindex);

							 }
						 }
						 if(k.getCurrentPlayer()==k.getPlayer2())
						 {
							 
						 	if(Gy2Buttons.contains(selectedButton))
							 {
								 Revindex = Gy2Buttons.indexOf(selectedButton);
								 RevivedPiece = k.getPlayer2().getDeadCharacters().get(Revindex);
							 }

						 }
					 }
				
				
				//	}
					
					if(selectedButton==usepower) {
						
					
						try {
							 if(selectedPiece instanceof ActivatablePowerHero && (!(selectedPiece instanceof Tech))&&r!=null)
							 {
									((ActivatablePowerHero) selectedPiece).usePower(r, RevivedPiece, null);

							 }
							 else{
								 
								 if((selectedPiece instanceof Tech) && isUsePowerClicked==false){
									 JOptionPane.showMessageDialog(null,"Select a target to hack/restore or a location to teleport a friendly character");
									 isUsePowerClicked=true;		 
								 }
								 
							 	 }
							 
								 }
						
						
					catch(Exception e){
						
						if(e instanceof NullPointerException)
							JOptionPane.showMessageDialog(null,"Complete your action yabeh");
						if(e instanceof PowerAlreadyUsedException)
							JOptionPane.showMessageDialog(null," PowerAlready used yabeh");
						if(e instanceof InvalidPowerDirectionException)
							JOptionPane.showMessageDialog(null," Invalid Power Direction yabeh");
						if(e instanceof InvalidPowerTargetException)
							JOptionPane.showMessageDialog(null," Invalid power target ");
						
						if(e instanceof WrongTurnException)
							JOptionPane.showMessageDialog(null," Wrong turn ya  yabeh");
						
						
						
						
					}		
					}
					}
				}
	
		
					// All the Method can See this code 
						if(k.getCurrentPlayer()==k.getPlayer1())
						{
							nameDisplay="Player1: "+p1;
							nameBar.setBackground(Color.green);
						}
						else{ nameDisplay="Player2: "+p2;
								nameBar.setBackground(Color.blue);
						}
						nameBar.setText(nameDisplay);
						ChessBoard.setVisible(false);
						ChessBoard.removeAll();
						piecesArray.removeAll(piecesArray);
						btnsArray.removeAll(btnsArray);
						
						
						for(int i=0;i<7;i++){
							 for(int j=0;j<6;j++){
								 
								 Piece p = k.getCellAt(i, j).getPiece();
								 tile = new JButton(); 
								  tile.addActionListener(this);

								 if(p==null){
								  piecesArray.add(p);
								  btnsArray.add(tile);
								 ChessBoard.add(tile);
								 arrayofButtons[i][j]=tile;
								 tile.setIcon(background);
								 
								 }else{
									 tile= new JButton();
									 tile.addActionListener(this);	 
									 
									 arrayofButtons[i][j]=tile;
									 s = "";
									 
									 
									 if(p.getOwner()==k.getPlayer1()){
										 if(p instanceof SideKick)
										 { 
											 tile.setIcon(sk1);
											 s=p.getName() +"-----"+ "Player:"+ k.getPlayer1().getName()+"------"+ "Type:SideKick";
										 }
										 if(p instanceof Armored)
										 {
											 if(((Armored) p).isArmorUp()==true)
											 {
												 s= p.getName()+"-----" +"Type:Armored" + "-----" + "Player:"+ k.getPlayer1().getName() +"-----" +"Armour Up " ;
												 tile.setIcon(Armor1);
												 
											 }
											 else{
												 tile.setIcon(Armor1down);
												 s= p.getName()+"-----" +"Type:Armored" + "-----" + "Player:"+ k.getPlayer1().getName() +"-----" +"Armour Down " ;
											 }
										 }
										 if(p instanceof Speedster)
										 {
											 tile.setIcon(Speed1);
											 s= p.getName() +"-----" + "Type:Speedster" + "Player:"+ k.getPlayer1().getName();
											 

										 }
										 if(p instanceof ActivatablePowerHero )
										 {
											 if(((ActivatablePowerHero) p).isPowerUsed()==false)
											 {
												 if(p instanceof Medic)
												 { tile.setIcon(Medic1);
												 s= p.getName() + "----- "+ "Type:Medic"+  "-----Player:"+k.getPlayer1().getName() +"-----" + "PowerUsed:No " 
												 +" -------" +"  Special Ability : Resurrects an eliminated friendly" ;
												 }
												 
													 if(p instanceof Super){
														 tile.setIcon(Super1);
													 s= p.getName() +"------" + "Type:Super"+"------"+"Player:"+k.getPlayer1().getName()+"------"+ "PowerUsed:No"+ "---- "
														 +"Special Ability: Super Smashes two adjacent cells in the specified direction, eliminating any enemy pieces within them"; ;
													 }
												 
													 if(p instanceof Ranged){
														 tile.setIcon(Ranged1);
													 s= p.getName() +"-----"+ "Type:Ranged"+"----- "+"Player:"+k.getPlayer1().getName()+"-----"+"PowerUsed:No"+
														 " -----"+ "Special Ability : Eliminates the first enemy piecethat is encountered in the specified direction "; ;
													 }
												 if(p instanceof Tech){
													 tile.setIcon(tech1);
													 s= p.getName() +"-----" + "Type:Tech" + "Player:"+k.getPlayer1().getName() + "-------"+ "PowerUsed:No"+ " ----"+ 
													 " Special Ability : Can do one of the following abilities : Teleporting a friendly piece / Hacking an enemy hero piece / Restoring the ability of another friendly piece" ;	;	
													 }
											}
												 
												 		 
											 
											 else
											 {
												 if(p instanceof Medic){
													 tile.setIcon(Medic1);
													 s= p.getName() +"------" + "Type:Medic" + "Player:"+k.getPlayer1().getName()+"------"+ "PowerUsed:yes"
															 +" -------" +"  Special Ability : Resurrects an eliminated friendly" ;;
													 }
													
														 if(p instanceof Super){
															 tile.setIcon(Super1);
															 s= p.getName() +
														 "\n" + 
																 "Type:Super" + "------"+ "Player:"+k.getPlayer1().getName()+"------"+"PowerUsed:yes"+"-"
																 +"Special Ability: Super Smashes two adjacent cells in the specified direction, eliminating any enemy pieces within them"; ;

														 }
													 
														 if(p instanceof Ranged){
															 tile.setIcon(Ranged1);
															 s= p.getName() +"-----" +"Type:Ranged" +"-----" + "Player:"+k.getPlayer1().getName()+ "------" + "PowerUsed:yes" 
																	+ " -----"+ "Special Ability : Eliminates the first enemy piecethat is encountered in the specified direction "; ;;
														 }
													
														 if(p instanceof Tech){
															 tile.setIcon(tech1);
														 s= p.getName() +"------" + "Type:Tech" +"-----"+"Player:"+k.getPlayer1().getName() + "-----" + "PowerUsed:yes" + " ----"+
															 " Special Ability : Can do one of the following abilities : Teleporting a friendly piece / Hacking an enemy hero piece / Restoring the ability of another friendly piece" ;	;	
														 }
													 }
													 }
											 
										 
										 
								 
										 
										 tile.setToolTipText(s + "" );
										 // tile.setText(k.getCellAt(i, j).getPiece().toString());
										 btnsArray.add(tile);
										 piecesArray.add(k.getCellAt(i, j).getPiece());
										 ChessBoard.add(tile);
										 arrayofButtons[i][j]=tile;
									 }
										
										
							 
								 
								 else									
								 {
										 if(p instanceof SideKick)
										 {  tile.setIcon(sk2);
											 s=p.getName() + "-"+"Player:"+ k.getPlayer2().getName()+"-----"+ "Type:SideKick";
										 }
										 if(p instanceof Armored)
										 {
											 if(((Armored) p).isArmorUp()==true)
											 {
												 s= p.getName()+"-----"+"Type:Armored" +"-----"+ "Player:"+ k.getPlayer2().getName()+"----" + "Armour is Up";
												 tile.setIcon(Armor2);
											 }
											 else
											 {
												 s= p.getName() +"-"+ "Type:Armored" +  "-" +"Player:"+ k.getPlayer2().getName() +"-" + "Armour is Down " ;
												 tile.setIcon(Armor2down);
											 }
										 }
										 if(p instanceof Speedster)
										 {
											 s= p.getName() +"-" + "Type:Speedster" + "-" + "Player:"+k.getPlayer2().getName();
											 tile.setIcon(Speed2);
										 }
										 if(p instanceof ActivatablePowerHero )
										 {
											 if(((ActivatablePowerHero) p).isPowerUsed()==false)
											 {
												 if(p instanceof Medic){
													 tile.setIcon(Medic2);
												 s= p.getName() +"-" + "Type:Medic"+  "Player:"+ k.getPlayer2().getName() +"-" + "PowerUsed:No"+" -------" +"  Special Ability : Resurrects an eliminated friendly" ;
												 }
												  
													 if(p instanceof Super){
														 tile.setIcon(Super2);
													 s= p.getName() +"-" + "Type:Super" + "-"+"Player:"+k.getPlayer2().getName() + "-" + "PowerUsed:No"+ "---- "+"Special Ability: Super Smashes two adjacent cells in the specified direction, eliminating any enemy pieces within them"; 
													 }
												 
													 if(p instanceof Ranged){
														 tile.setIcon(Ranged2);
													 s= p.getName() +"-" + "Type:Ranged" + "-----"+ "Player:"+ k.getPlayer2().getName() +"-----" + "PowerUsed:No" + " -----"+ "Special Ability : Eliminates the first enemy piecethat is encountered in the specified direction ";
													 }
												
													 if(p instanceof Tech)
													 {
														 tile.setIcon(tech2);
													 s= p.getName() +"-" + "Type:Tech" + "-----"+"Player:"+ k.getPlayer2().getName()+"-----"+"PowerUsed:No " 
														 + " ----"+ " Special Ability : Can do one of the following abilities : Teleporting a friendly piece / Hacking an enemy hero piece / Restoring the ability of another friendly piece" ;	
													 }
												 }
										 	
											 
											 
										 
								 			
										 if(((ActivatablePowerHero) p).isPowerUsed()==true)
											 {
												 if(p instanceof Medic){
													 tile.setIcon(Medic2);
													 s= p.getName() +"-" + "Type:Medic" + "-----"+"Player:"+ k.getPlayer2().getName() +"-----"+ "PowerUsed:yes" +"-" + "PowerUsed:No"+" -------" +"  Special Ability : Resurrects an eliminated friendly" ;
													 }
													 
														 if(p instanceof Super){
															 tile.setIcon(Super2);
														 s= p.getName() +"-" + "Type:Super" + "-----"+"Player: " + k.getPlayer2().getName() + "-----" + "PowerUsed:yes"+ "-" + "PowerUsed:No"+ "---- "+"Special Ability: Super Smashes two adjacent cells in the specified direction, eliminating any enemy pieces within them"; 
														 }
													 
														 if(p instanceof Ranged){
															 tile.setIcon(Ranged2);
															 s= p.getName() +"-----" + "Type:Ranged" + k.getPlayer2().getName() +"-----" + "PowerUsed:yes " + " -----"+ "Special Ability : Eliminates the first enemy piecethat is encountered in the specified direction ";;
														 }
													
														 if(p instanceof Tech){
															 tile.setIcon(tech2);
														 s= p.getName() +"-----" + "Type:Tech" + k.getPlayer2().getName()+ "-----" + "PowerUsed:yes "+ " ----"+ " Special Ability : Can do one of the following abilities : Teleporting a friendly piece / Hacking an enemy hero piece / Restoring the ability of another friendly piece" ;	
														 }
										
													 	}
													 
												 
												 
										 }
									 
										 
										 tile.setToolTipText(s);
										// tile.setText(k.getCellAt(i, j).getPiece().toString());
										 btnsArray.add(tile);
										 piecesArray.add(k.getCellAt(i,j).getPiece());
										 ChessBoard.add(tile);
										 arrayofButtons[i][j]=tile;
										 
							 }
									 }
						}

							 LP.setValue(k.getPlayer2().getPayloadPos());
							 RP.setValue(k.getPlayer1().getPayloadPos());
							 ChessBoard.setVisible(true);

							 
						}	
						
									
								
							 
							if(k.getCurrentPlayer()==k.getPlayer1())
							{
								Gy1.removeAll();
								Gy1Buttons.clear();
								for(int j=0;j<k.getPlayer1().getDeadCharacters().size();j++) {

								deadcell=new JButton();
								deadcell.addActionListener(this);
								deadcell.setText(k.getPlayer1().getDeadCharacters().get(j).toString());
								deadcell.setVisible(true);
								Gy1.add(deadcell);	
								Gy1Buttons.add(deadcell);
								Gy1.setVisible(true);
								if(deadcell.getText().equals("K"))
									deadcell.setIcon(dsk);
								if(deadcell.getText().equals("M"))
									deadcell.setIcon(dMedic1);
								if(deadcell.getText().equals("A"))
									deadcell.setIcon(dArmor1);
								if(deadcell.getText().equals("S"))
									deadcell.setIcon(dSpeed1);
								if(deadcell.getText().equals("R"))
									deadcell.setIcon(dRanged1);
								if(deadcell.getText().equals("T"))
									deadcell.setIcon(dtech1);
								if(deadcell.getText().equals("R"))
									deadcell.setIcon(dRanged1);
								if(deadcell.getText().equals("P"))
									deadcell.setIcon(dSuper1);
								
							}
								
							}
							else
							{
								Gy2.removeAll();
								Gy2Buttons.clear();
								for(int j=0;j<k.getPlayer2().getDeadCharacters().size();j++) {
								deadcell2=new JButton();
								deadcell2.addActionListener(this);
								deadcell2.setText(k.getPlayer2().getDeadCharacters().get(j).toString());
								deadcell2.setVisible(true);
								Gy2.add(deadcell2);	
								Gy2Buttons.add(deadcell2);
								Gy2.setVisible(true);
								if(deadcell2.getText().equals("K"))
									deadcell2.setIcon(dsk2);
								if(deadcell2.getText().equals("M"))
									deadcell2.setIcon(dMedic2);
								if(deadcell2.getText().equals("A"))
									deadcell2.setIcon(dArmor2);
								if(deadcell2.getText().equals("S"))
									deadcell2.setIcon(dSpeed2);
								if(deadcell2.getText().equals("R"))
									deadcell2.setIcon(dRanged2);
								if(deadcell2.getText().equals("T"))
									deadcell2.setIcon(dtech2);
								if(deadcell2.getText().equals("R"))
									deadcell2.setIcon(dRanged2);
								if(deadcell2.getText().equals("P"))
									deadcell2.setIcon(dSuper2);
							}

							}
							if(LP.getValue()==6)
							{
								JOptionPane.showMessageDialog(null,"Congratulations ! ,The Winner is " + p2);
								this.dispose();
								}
								else if(RP.getValue()==6)
								{
									JOptionPane.showMessageDialog(null,"Congratulations ! ,The Winner is " + p1);
									this.dispose();
								
								}

					
					
				
			
			
			
			
		}}
			
			



			









