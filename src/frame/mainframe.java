package frame;


import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;


public class mainframe extends JFrame {


	public mainframe() throws IOException 
	
	{
		
		mainPanel pane=new mainPanel();
		pane.setFocusable(true);
		pane.requestFocus();
		this.add(pane,BorderLayout.CENTER);
		pack();
		
		this.setBounds(500, 200,pane.getWidth() ,pane.getHeight() );
		

	}
	
	public static void main(String[] args) throws IOException {
		mainframe frame=new mainframe();
		frame.setSize(800,645);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		

	}
	
}
