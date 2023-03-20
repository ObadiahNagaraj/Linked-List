import java.util.Arrays;

public class LinkedListandQueue {
	public static void main(String[] args) throws Exception{
		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		linkedList.insertNode(10);
		linkedList.insertNode(12);
		linkedList.insertNode(5);
		linkedList.insertNode(6);
		linkedList.insertNode(7);
		linkedList.insertNode(13);
		System.out.println(linkedList);
		System.out.println(linkedList.deleteNode(3));
		System.out.println(linkedList.deleteElement(12));
		System.out.println(linkedList+"\n------------------");
		Queue<String> queue = new Queue<String>();
		queue.enqueue("ab");
		queue.enqueue("cd");
		queue.enqueue("ef");
		queue.enqueue("gh");
		System.out.println(queue.get(3));
		System.out.println(queue);
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue);
	}
}
class LinkedList<T>{
	private Node<T> head;
	public void insertNode(T elem) {
		Node<T> node = new Node<T>(elem, null);
		if(head == null) {
			head = node;
		}else {
			Node<T> currNode = head;
			while(currNode.nextNode != null) {
				currNode = currNode.nextNode;
			}
			currNode.nextNode = node;
		}
	}
	public T deleteNode(int index) throws Exception{
		Node<T> currNode = head;
		Node<T> prevNode = null;
		for(int i=0; i< index; i++) {
			if(currNode != null && currNode.nextNode != null) {
				prevNode = currNode;
				currNode = currNode.nextNode;
			}else {
				throw new Exception("Linked List is smaller than you expected. ");
			}
		}
		Node<T> nodeToConnect = currNode.nextNode;
		prevNode.nextNode = nodeToConnect;
		currNode.nextNode = null;
		return currNode.data;
	}
	
	public String toString() {
		StringBuffer elements = new StringBuffer();
		Node<T> currNode = head;
		while(currNode.nextNode != null) {
			elements = elements.append(currNode.data).append(", ");
			currNode = currNode.nextNode;
		}
		elements = elements.append(currNode.data);
		return elements.toString();
	}
	public T deleteElement(T element) throws Exception{
		Node<T> currNode=head;
		Node<T> prevNode=null;
			while(currNode.data!=element) {
				prevNode=currNode;
				currNode=currNode.nextNode;
				if(currNode==null) {
					throw new Exception("Element not found");
				}
			}
		Node<T> nextNodeToConnect=currNode.nextNode;
		prevNode.nextNode=nextNodeToConnect;
		currNode.nextNode=null;
		return currNode.data;
	}
}
class Node<T>{
	T data;
	Node<T> nextNode;
	
	Node(T data, Node<T> nextNode) {
		this.data = data;
		this.nextNode = nextNode;
	}
}
class Queue<T>{
	private T[] myElements;
	private int lengthOfTheQueue;
	
	public Queue() {
		myElements = (T[])new Object[0];
		this.lengthOfTheQueue = 0;
	}
	public int getLengthOfTheQueue() {
		return this.lengthOfTheQueue;
	}
	
	public void enqueue(T elem) {
		myElements = Arrays.copyOf(myElements, lengthOfTheQueue+1);
		myElements[lengthOfTheQueue] = elem;
		lengthOfTheQueue = lengthOfTheQueue+1;
	}
	
	public T dequeue() 
	{
		T removedElement=myElements[0];
		if(myElements.length > 1) {
			myElements = Arrays.copyOfRange(myElements, 1, lengthOfTheQueue);
		}else if(myElements.length == 1) {
			myElements = (T[])new Object[0];
		}
		lengthOfTheQueue--;
		return removedElement;
	}
	
	public T get(int index) {
		return myElements[index];
	}
	
	public String toString() {
		StringBuffer elements = new StringBuffer();
		for(int i=0;i<myElements.length; i++) {
			elements = elements.append(myElements[i]).append(", ");
		}
		return elements.toString();
	}
}