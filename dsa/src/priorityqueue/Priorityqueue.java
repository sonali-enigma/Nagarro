package priorityqueue;

import java.util.Iterator;

public class Priorityqueue<T> implements Iterable<T> {

	Node<T> front;

	private int length = 0;

	Priorityqueue() {
		this.front = null;
	}

	void enqueue(T data, int Priority) {

		Node<T> temp = new Node<>(data, Priority);
		Node<T> X;

		if (front == null || Priority < front.priority) {
			temp.next = front;
			front = temp;
			length++;
		} else {
			X = front;
			while (X.next != null && X.next.priority <= Priority) {
				X = X.next;
			}
			temp.next = X.next;
			X.next = temp;

			length++;
		}

	}

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

	void peek() {

		if (front == null) {
			System.out.println("Queue is empty");
			return;
		}

		else {

			System.out.println(front.data);
		}
	}

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
		Node<T> next = null;

		while (current != null) {

			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		front = prev;
		print();
	}

	void print() {

		Node<T> temp = front;
		if (front == null) {
			System.out.println("Queue is empty");
			return;
		}

		while (temp.next != null) {
			System.out.println(temp.data);
			temp = temp.next;

		}
		System.out.println(temp.data);

		return;

	}

	public Node<T> getHead() {
		return front;
	}

	public Iterator<T> iterator() {
		return new ListIterator<T>(this);
	}
}

class ListIterator<T> implements Iterator<T> {
	Node<T> current;

	public ListIterator(Priorityqueue<T> list) {
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
