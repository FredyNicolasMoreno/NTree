package views;



import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.Commands;
import controller.Controller;

public class MainWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainWindow(Controller control) {
		setExtendedState(MAXIMIZED_BOTH);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileChooser = new JMenu("Open");
		JMenuItem file = new JMenuItem("File");
		
		file.setActionCommand(Commands.FILE.toString());
		file.addActionListener(control);
		fileChooser.add(file);
		menuBar.add(fileChooser);
		add(menuBar, BorderLayout.NORTH);
		
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
