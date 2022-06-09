package hashtable;

import java.util.Iterator;

public class Hashtable implements Iterable<Node> {

	Node[] table;
	int count;
	public int size;

	public Hashtable(int size) {
		table = new Node[size];
		this.size = size;
	}

	// insert
	public void insert(int key, String value) {

		int bucket = hash(key);
		Node list = table[bucket];

		while (list != null) {
			if (list.key == key)
				break;
			list = list.next;
		}
		if (list != null) {
			list.value = value;
			count++;
		} else {

			Node newNode = new Node(key, value);
			newNode.next = table[bucket];
			table[bucket] = newNode;
			count++;
		}
	}

	// delete
	public void delete(int key) {
		int bucket = hash(key);
		if (table[bucket] == null) {
			System.out.println("Not present");
			return;
		}
		if (table[bucket].key == key) {
			table[bucket] = table[bucket].next;
			System.out.println("DELETED");
			count--;
			return;
		}
		Node prev = table[bucket];
		Node curr = prev.next;
		while (curr != null && curr.key != key) {
			curr = curr.next;
			prev = curr;
		}
		if (curr != null) {
			prev.next = curr.next;
			count--;
		}
		System.out.println("DELETED");
	}

	// get
	public void get(int key) {

		int bucket = hash(key);
		Node list = table[bucket];
		while (list != null) {
			if (list.key == key) {
				System.out.println("Value present at that key are: " + list.value);
				return;
			}
			list = list.next;

		}
		System.out.println("Not present");
	}

	// contains
	public void contains(int key) {
		int bucket = hash(key);
		Node list = table[bucket];
		while (list != null) {
			if (list.key == key) {
				System.out.println("Hash Table contains:" + key);
				return;
			}
			list = list.next;
		}
		System.out.println("Hash Table does not contains:" + key);
	}

	// size
	public void size() {
		System.out.println("Size:" + count);
	}

	// printing
	void print() {

		boolean empty = true;
		System.out.println();
		for (int i = 0; i < table.length; i++) {

			Node list = table[i];
			while (list != null) {
				System.out.print("Table index:" + i + "->");
				System.out.print(" Key:" + list.key + ", Value: " + list.value);
				list = list.next;
				System.out.println();
				empty = false;
			}

		}
		if (empty)
			System.out.println("Table Empty");
	}

	public int hash(Object key) {
		return (Math.abs(key.hashCode())) % table.length;
	}

	public Node[] getHead() {
		return table;
	}

	public int getSize() {
		return size;
	}

	public Iterator<Node> iterator() {
		return new ListIterator<String>(this);
	}
}

// iterator
class ListIterator<String> implements Iterator<Node> {
	Node[] current;
	public int size;
	public int i = 0;

	public ListIterator(Hashtable list) {
		current = list.getHead();
		size = list.getSize();
	}

	public boolean hasNext() {
		return i < size && current != null;
	}

	public Node next() {
		while (i < size)
			return current[i++];
		return null;

	}
}
