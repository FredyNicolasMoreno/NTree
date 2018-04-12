package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import model.Node;
import views.FileChooser;
import views.MainWindow;

public class Controller implements ActionListener{

	private FileChooser chooser = new FileChooser(this);
	private File file = new File("");
	private Node root = new Node();
	
	public Controller() {
		new MainWindow(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (Commands.valueOf(e.getActionCommand())) {
		case FILE:
			try {
				file = new File(chooser.getPathFile());
			} catch (Exception e1) {
				e1.printStackTrace();
			}
				root.setName(file.getPath());
				createTree(root);
			break;

		default:
			break;
		}
		
	}

	private void createTree(Node node) {
		for (File file : new File(node.getName()).listFiles()) {
			if(file.isDirectory()) {
				System.out.println("carpertas: " +file.getPath());
				Node aux = new Node();
				aux.setName(file.getPath());
				createTree(aux);
				node.addNode(aux);
			}else {
				System.out.println("archivos:" + file.getPath()+ "|-|" + node.getName());
				node.addFile(file.getPath());
			}
		}
	}
	
	
	
	
	
}
