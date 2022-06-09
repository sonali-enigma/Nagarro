package linklist;

import java.util.Iterator;

public class Linklist<T> implements Iterable<T>{

	Node<T> head;

	private int length = 0;

	Linklist() {
		this.head = null;
	}

	void insert(T data) {
		Node<T> temp = new Node<>(data);
		if (this.head == null) {
			head = temp;
		}

		else {
			Node<T> X = head;

			while (X.next != null) {
				X = X.next;
			}

			X.next = temp;
		}

		length++;
	}

	void insert_at_position(int position, T data) {

		if (position > length + 1) {

			System.out.println("Position Unavailable in LikedList");
			return;
		}

		if (position == 1) {

			Node<T> temp = head;
			head = new Node<T>(data);
			head.next = temp;
			length++;
			return;
		}

		Node<T> temp = head;

		Node<T> prev = new Node<T>(null);

		while (position - 1 > 0) {

			prev = temp;

			temp = temp.next;

			position--;
		}

		prev.next = new Node<T>(data);

		prev.next.next = temp;
		
		length++;
	}

	void delete() {

		Node<T> temp = head;

		if (temp == null) {
			System.out.println("List is empty");
			return;
		}

		if (temp.next == null) {
			temp = null;
			length--;
			return;
		}

		while (temp.next.next != null) {
			temp = temp.next;
		}
		temp.next = null;
		length--;
	}

	void delete_at_position(int position) {
		
		if ( head==null || position > length + 1) {

			System.out.println("Position Unavailable in LikedList");
			return;
		}


		Node<T> temp = head;
		Node<T> prev = new Node<T>(null);

		
		if (position == 1) {
			temp = null;
			length--;
			return;
            
		}

		while (position - 1 > 0) {
			prev = temp;
			temp = temp.next;
			position--;
		}
		prev.next = temp.next;
		length--;
	}
	
	
	void center() {

		Node<T> slow = head;
		Node<T> fast = head;
		
		if (head == null) {
			System.out.println("List is empty");
			return;}
		
		while (fast!=null && fast.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
	
		System.out.println("Center is:"+slow.data);
	
}
	
	void reverse() {

		
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
			Node<T> current = head;
			Node<T> prev = null;
			Node<T> next = new Node<T>(null);
			
		while (current!=null) {
		
		
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		
		 head=prev;
		 print();
	}
	
	
	void size() {
		System.out.println(length);
			}
	
	void print() {
		
		Node<T>temp=head;
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		
		
		while(temp!=null) {
			System.out.println(temp.data);
			temp=temp.next;
		
			}
		
	
	}
	
	
	public Node<T> getHead() {
		return head;
	}

	public Iterator<T> iterator() {
		return new ListIterator<T>(this);
	}
}

class ListIterator<T> implements Iterator<T> {
	Node<T> current;

	public ListIterator(Linklist<T> list) {
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
