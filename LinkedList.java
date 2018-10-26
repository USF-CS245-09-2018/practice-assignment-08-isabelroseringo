public class LinkedList implements List {
	
	public class Node {
		public Object data; 
		public Node next; 
	}

	private Node head; 
	private int size; 

	public LinkedList() {
		head = null; 
		size = 0; 
	}

	public void add(Object obj) throws Exception {
		Node node = new Node(); 
		node.data = obj; 
		node.next = head; 
		head = node; 
		size++; 
	}

	public void add(int pos, Object obj) throws Exception {
		if (pos < 0 || pos > size) {
			throw new Exception(); 
		}
		if (pos == 0) {
			add(obj); 
		}
		else {
			Node node = new Node(); 
			Node previous = getNode(pos - 1); 
			node.data = obj; 
			node.next = previous.next; 
			previous.next = node; 
			size++; 
		} 
	}

	public Object get(int pos) throws Exception {
		if (pos < 0 || pos >= size) {
			throw new Exception(); 
		}
		return getNode(pos).data; 
	}

	public Object remove(int pos) throws Exception {
		if (pos < 0 || pos > size) {
			throw new Exception(); 
		}
		Node current; 
		if (pos == 0) {
			current = head;
			head = head.next; 
		}	
		else {
			Node previous = getNode(pos - 1); 
			current = previous.next;
			previous.next = current.next; 
		}
		size--; 
		return current.data;
	}

	public int size() {
		return size; 
	}

	private Node getNode(int pos) {
		Node node = head; 
		for (int i = 0; i < pos; i++) {
			node = node.next; 
		}
		return node; 
	}
}