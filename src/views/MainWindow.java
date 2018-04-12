package views;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ScrollPane;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import controller.Commands;
import controller.Controller;
import model.Node;

public class MainWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DefaultTreeModel treeModel;
	private JTree tree;
	
	public MainWindow(Controller control) {
		setExtendedState(MAXIMIZED_BOTH);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu fileChooser = new JMenu("Open");
		JMenuItem file = new JMenuItem("File");
		
		file.setActionCommand(Commands.FILE.toString());
		file.addActionListener(control);
		fileChooser.add(file);
		menuBar.add(fileChooser);
		
		menuBar.setBackground(new Color(13, 0, 108));
		fileChooser.setBackground(new Color(13, 0, 108));
		file.setBackground(new Color(13, 0, 108));
		fileChooser.setForeground(Color.WHITE);
		file.setForeground(Color.WHITE);
		
		add(menuBar, BorderLayout.NORTH);
		
		tree = new JTree();
		ScrollPane scroll = new ScrollPane();
		scroll.add(tree);
		
		add(scroll, BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void setData(Node root, ArrayList<String> files, HashSet<String> extensions) {
		DefaultMutableTreeNode father = new DefaultMutableTreeNode(root.getName());
		treeModel = new DefaultTreeModel(father);
		tree.setModel(treeModel);
		int i = 0;
		for (String extension : extensions) {
			DefaultMutableTreeNode childs = new DefaultMutableTreeNode(extension);
			treeModel.insertNodeInto(childs, father, i);
			i++;
			addFiles(childs,files,extensions);
		}
	}

	private void addFiles(DefaultMutableTreeNode childs, ArrayList<String> files, HashSet<String> extensions) {
		
		for (String extension : extensions) {
			for (String file : files) {
				int i = 0;
				if(extension.equals(getFileExtension(new File(file)))) {
					DefaultMutableTreeNode childFilds = new DefaultMutableTreeNode(file);
					treeModel.insertNodeInto(childFilds, childs, i);
					i++;
				}
			}
		}
	}
	
	private String getFileExtension(File file) {
	    String name = file.getName();
	    try {
	        return name.substring(name.lastIndexOf(".") + 1);
	    } catch (Exception e) {
	        return "";
	    }
	}
	
}
