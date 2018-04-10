package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.FileChooser;

public class Controller implements ActionListener{

	public Controller() {
		new FileChooser(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
	}
	
}
