package priorityqueue;

public class Node<T> {

	T data;
	Node<T> next;
	int priority;

	Node(T data, int priority) {
		this.data = data;
		this.next = null;
		this.priority = priority;

	}

	 public T getData()
	    {
	        return data;
	    }
	      
	    public Node<T> getNext()
	    {
	        return next;
	    }
}