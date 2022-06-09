package nchildtree;

import java.util.ArrayList;
import java.util.List;

public class Node {
	String data;
	List<Node> children;
	Node parent;

	public Node(String data) {
		this.data = data;
		this.children = new ArrayList<Node>();
	}

	public Node(Node node) {
		this.data = node.getData();
		children = new ArrayList<Node>();
	}

	public void addChild(Node child) {
		child.setParent(this);
		children.add(child);
	}

	public void addChildAt(int index, Node child) {
		child.setParent(this);
		this.children.add(index, child);
	}

	public void setChildren(List<Node> children) {
		for (Node child : children)
			child.setParent(this);

		this.children = children;
	}

	public void removeChildren() {
		this.children.clear();
	}

	public Node removeChildAt(int index) {
		return children.remove(index);
	}

	public boolean removeChild(Node childToBeDeleted) {
		List<Node> list = getChildren();
		return list.remove(childToBeDeleted);
	}

	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Node getParent() {
		return this.parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public List<Node> getChildren() {
		return this.children;
	}

	public Node getChildAt(int index) {
		return children.get(index);
	}

	@Override
	public boolean equals(Object obj) {
		if (null == obj)
			return false;

		if (obj instanceof Node) {
			if (((Node) obj).getData().equals(this.data))
				return true;
		}

		return false;
	}

	@Override
	public String toString() {
		return this.data.toString();
	}

}