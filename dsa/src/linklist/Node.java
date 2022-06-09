package linklist;

public class Node<T> {

	T data;
	Node<T> next;

	Node(T data) {
		this.data = data;
		this.next = null;
	}

	public T getData() {
		return data;
	}

	public Node<T> getNext() {
		return next;
	}
}
