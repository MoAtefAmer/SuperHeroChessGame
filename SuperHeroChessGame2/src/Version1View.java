import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.game.Game;
import model.game.Player;
import model.pieces.Piece;

public class Version1View extends JFrame implements ActionListener {

	Player p1;
	Player p2;
	Game game;
	JButton l = new JButton();
	JButton m = new JButton();
	
	JButton swap = new JButton("Swap");
	Piece p ;
	Piece o;
	String s ;
	String c ;
	public Version1View() {
		/**
		 * Initializing a game object, where the first Player corresponds to p1
		 * object and the second player corresponds to p2 object
		 */
		p1 = new Player("player 1");
		p2 = new Player("player 2");
		game = new Game(p1, p2);
		
		/**
		 * Your solution starts from here
		 */
		this.setLayout(null);
		this.setSize(400,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		if(game.getCurrentPlayer()==p1){
		 p=game.getCellAt(5,0).getPiece();
		 o=game.getCellAt(5,1).getPiece();
		}
		if(game.getCurrentPlayer()==p2)
		{
			
			p=game.getCellAt(1,0).getPiece();
			 o=game.getCellAt(1,1).getPiece();
			
		}
		add(l);
		l.setText(p.toString());
		l.setBounds(0,0,50,50);
		s=p.toString();
		
		
		
		add(m);
		m.setText(o.toString());
		m.setBounds(0,100,50,50);
		c=o.toString();
		
		this.setVisible(true);
		
		
		add(swap);
		swap.addActionListener(this);

		swap.setBounds(0,200,400,150);
		
		
		
		
	}
	public static void main (String [] args)
	{
		Version1View v= new Version1View ();
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		
		
			if(event.getSource()==swap)
			{
				
				if(l.getText().equals(s)&&(m.getText().equals(c))){
				l.setText(c);
				m.setText(s);
				
			}
				else{
				l.setText(s);
				m.setText(c);
			}
		
	}

}
}
