package views;


import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainWindow() {
		setExtendedState(MAXIMIZED_BOTH);
		
		JButton fileChooser = new JButton("File");
		add(fileChooser, BorderLayout.NORTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
