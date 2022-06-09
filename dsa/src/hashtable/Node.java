package hashtable;

public class Node{
	int key;
	String value;
    Node next;

    Node(int key,String value)
    {
        this.key = key;
        this.value=value;
        this.next = null;
    }
    public String getData()
    {
        return value;
    }
      
    public Node getNext()
    {
        return next;
    }
}


