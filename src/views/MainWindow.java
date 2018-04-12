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
		tree.setModel(null);
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
		treeModel.setAsksAllowsChildren(true);
		int i = 0;
		for (String extension : extensions) {
			DefaultMutableTreeNode childs = new DefaultMutableTreeNode(extension);
			DefaultMutableTreeNode max = new DefaultMutableTreeNode("Menor tamaño");
			DefaultMutableTreeNode min = new DefaultMutableTreeNode("Mayor tamaño");
			treeModel.insertNodeInto(childs, father, i);
			treeModel.insertNodeInto(min, childs, 0);
			treeModel.insertNodeInto(max , childs, 1);
			addFiles(childs,files,extensions, min, max);
			i++;
		}
	}

	private void addFiles(DefaultMutableTreeNode childs, ArrayList<String> files, HashSet<String> extensions, DefaultMutableTreeNode min, DefaultMutableTreeNode max) {
			
			for (String file : files) {
				if(childs.getUserObject().equals(getFileExtension(new File(file)))) {
					if(new File(file).length()>(50*1000)) {
//						treeModel.insertNodeInto(new DefaultMutableTreeNode(file), childs, i);
						max.add(new DefaultMutableTreeNode(file));
					}else {
						min.add(new DefaultMutableTreeNode(file));
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
