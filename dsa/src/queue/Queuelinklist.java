package queue;

import java.util.Iterator;

public class Queuelinklist<T>implements Iterable<T> {

	Node<T> front;

	private int length = 0;

	Queuelinklist() {
		this.front = null;
	}
//enqueue
	void enqueue(T data) {

		Node<T> temp = front;
		Node<T> X = new Node<>(data);
		if (this.front == null) {
			front = X;

		} else {
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = X;

		}

		length++;
	}
//dequeue
	void dequeue() {

		if (front == null) {
			System.out.println("Queue is empty");
			return;
		}

		else {

			front = front.next;
			length--;
			return;
		}
	}
//peek
	void peek() {

		if (front == null) {
			System.out.println("Queue is empty");
			return;
		}

		else {

			System.out.println(front.data);
		}
	}
//contains
	void contains(T data) {

		Node<T> temp = front;
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
//size
	void size() {
		System.out.println(length);
	}

	void reverse() {

		if (front == null) {
			System.out.println("Queue is empty");
			return;
		}
		Node<T> current = front;
		Node<T> prev = null;
		Node<T> next = new Node<T>(null);

		while (current != null) {

			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		front = prev;
		print();
	}
//print
	void print() {

		Node<T> temp = front;
		if (front == null) {
			System.out.println("Queue is empty");
			return;
		}

		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;

		}

	}
//iterator
	public Node<T> getHead() {
		return front;
	}

	public Iterator<T> iterator() {
		return new ListIterator<T>(this);
	}
}

class ListIterator<T> implements Iterator<T> {
	Node<T> current;

	public ListIterator(Queuelinklist<T> list) {
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
