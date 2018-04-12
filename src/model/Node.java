package model;

import java.util.ArrayList;

public class Node {

	private ArrayList<String> files;
	private ArrayList<Node> folders;
	
	private String name;
	
	public Node() {
		files = new ArrayList<>();
		folders = new ArrayList<>();
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<String> getFiles() {
		return files;
	}
	
	public ArrayList<Node> getFolders() {
		return folders;
	}
	
	public void addFile(String file) {
		
		files.add(file);
		
	}
	
	public void addNode(Node node) {
		folders.add(node);
	}
	
}
