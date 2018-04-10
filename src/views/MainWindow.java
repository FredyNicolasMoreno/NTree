package views;


import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

import controller.Commands;
import controller.Controller;

public class MainWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainWindow(Controller control) {
		setExtendedState(MAXIMIZED_BOTH);
		
		JButton fileChooser = new JButton("File");
		fileChooser.setActionCommand(Commands.FILE.toString());
		fileChooser.addActionListener(control);
		add(fileChooser, BorderLayout.NORTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
