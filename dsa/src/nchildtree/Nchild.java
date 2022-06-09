package nchildtree;

import java.util.ArrayList;

public class Nchild {

	Node root;

	int totalSize = 1;

	public Nchild(Node root) {
		this.root = root;
	}

	void insert(String data, String parent) {
		Node par = null;
		if (!exists(parent)) {
			System.out.println("Parent does not exist");
			return;
		} else {
			Node temp = new Node(data);
			par = findNode(root, parent);
			par.addChild(temp);
		}

	}

	void delete(String data) {
		if (!exists(data)) {
			System.out.println("Node does not exist");
			return;
		} else {
			if (root.data.equals(data)) {
				System.out.println("Can not delete root");
				return;
			} else {
				Node temp = new Node(data);
				temp = findNode(root, data);
				Node par = new Node(data);
				par = temp.getParent();
				for (Node child : temp.getChildren()) {
					child.setParent(par);
					par.addChild(child);
				}
				par.removeChild(temp);
			}
			System.out.println("DELETED");
		}
	}

	public void contains(String data) {
		if (exists(data)) {
			System.out.println("Tree Contains Node: " + data);
		} else {
			System.out.println("Tree Does Not Contains Node: " + data);
		}
	}

	public void getElement(String data) {
		if (!exists(data)) {
			System.out.println("Node does not exist");
			return;
		}
		System.out.println("Node: " + data);
		Node temp = new Node(data);
		temp = findNode(root, data);
		if (temp.getChildren() != null) {
			System.out.print("All children: ");
			for (Node child : temp.getChildren()) {
				System.out.print(child.data + " ");
			}
		}
	}

	public boolean exists(String key) {
		return find(root, key);
	}

	private boolean find(Node node, String keyNode) {
		boolean res = false;
		if (node.getData().equals(keyNode))
			return true;

		else {
			for (Node child : node.getChildren())
				if (find(child, keyNode))
					res = true;
		}

		return res;
	}

	private Node findNode(Node node, String keyNode) {
		if (node == null)
			return null;
		if (node.getData().equals(keyNode))
			return node;
		else {
			Node cnode = null;
			for (Node child : node.getChildren())
				if ((cnode = findNode(child, keyNode)) != null)
					return cnode;
		}
		return null;
	}

	public ArrayList<Node> breadthFirst() {
		ArrayList<Node> breadthFirst = new ArrayList<Node>();
		ArrayList<Node> children = new ArrayList<Node>();
		children = depthFirst();
		int sizeOfChild = children.size();
		totalSize = 1;
		breadthFirst.add(root);
		buildBFS(root, breadthFirst, sizeOfChild);
		return breadthFirst;
	}

	private void buildBFS(Node node, ArrayList<Node> in, int sizeOfChild) {
		for (Node child : node.getChildren()) {
			in.add(child);
		}
		if (totalSize < sizeOfChild)
			buildBFS(in.get(totalSize++), in, sizeOfChild);
	}

	public ArrayList<Node> depthFirst() {
		ArrayList<Node> depthFirst = new ArrayList<Node>();
		buildDFS(root, depthFirst);
		return depthFirst;
	}

	private void buildDFS(Node node, ArrayList<Node> depthFirst) {
		for (Node child : node.getChildren()) {
			buildDFS(child, depthFirst);
		}
		depthFirst.add(node);
	}

}