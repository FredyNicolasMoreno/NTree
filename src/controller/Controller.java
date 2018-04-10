package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.FileChooser;
import views.MainWindow;

public class Controller implements ActionListener{

	private FileChooser file = new FileChooser(this);
	
	public Controller() {
		new MainWindow(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (Commands.valueOf(e.getActionCommand())) {
		case FILE:
				file.getPathFile();
			break;

		default:
			break;
		}
		
	}
	
}
