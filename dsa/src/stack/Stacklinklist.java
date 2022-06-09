package stack;

import java.util.Iterator;



public class Stacklinklist<T>implements Iterable<T> {

	Node<T> top;

	private int length = 0;

	Stacklinklist() {
		this.top = null;
	}

	void push(T data) {
		Node<T> temp = new Node<>(data);
		if (this.top == null) {
			top = temp;
		}

		else {
			temp.next = top;
			top = temp;
		}

		length++;
	}

	void pop() {

		if (top == null) {
			System.out.println("Stack is empty");
			return;
		}

		if (top.next == null) {
			top = null;
			length--;
			return;
		} else {

			top = top.next;
			length--;
			return;
		}
	}

	void peek() {

		if (top == null) {
			System.out.println("Stack is empty");
			return;
		}

		if (top.next == null) {
			System.out.println(top.data);
			return;
		}

		else {

			System.out.println(top.data);
		}
	}

	void contains(T data) {

		Node<T> temp = top;
		if (temp.data.equals(data)) {
			System.out.println("YES IT CONTAINS");
			return;
		}

		while (temp.next != null) {

			if (temp.data.equals(data)) {
				System.out.println("YES IT CONTAINS");
				return;
			}

			else {
				temp = temp.next;
			}
			
		}
		System.out.println("Do not CONTAINS");
	}

	void size() {
		System.out.println(length);
	}

	void reverse() {

		if (top == null) {
			System.out.println("Stack is empty");
			return;
		}
		Node<T> current = top;
		Node<T> prev = null;
		Node<T> next = new Node<T>(null);

		while (current != null) {

			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		top = prev;
		print();
	}

	void print() {

		Node<T> temp = top;
		if (top == null) {
			System.out.println("Stack is empty");
			return;
		}

		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;

		}

	}

	public Node<T> getHead() {
		return top;
	}

	public Iterator<T> iterator() {
		return new ListIterator<T>(this);
	}
}

class ListIterator<T> implements Iterator<T> {
	Node<T> current;

	public ListIterator(Stacklinklist<T> list) {
		current = list.getHead();
	}

	public boolean hasNext() {
		return current != null;
	}

	public T next() {
		T data = current.getData();
		current = current.getNext();
		return data;
	}
}

