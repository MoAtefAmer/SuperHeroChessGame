package GUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MedicReserect  extends Board  implements ActionListener {
	JButton b = new JButton();
	JFrame F = new JFrame();
	
	
	
	public MedicReserect ()
	{
		//getContentPane().removeAll();
		F.setSize(300,400 );
		F.setLayout( new GridLayout(8,8));
		
		for(int i=0;i<k.getCurrentPlayer().getDeadCharacters().size();i++) {
			deadcell=new JButton();
			deadcell.addActionListener(this);
			deadcell.setText(k.getCurrentPlayer().getDeadCharacters().get(i).toString());
			deadcell.setVisible(true);
			F.add(deadcell);	
			}
		F.setDefaultCloseOperation(EXIT_ON_CLOSE);
		F.setVisible(true);
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
		
	
	

}
