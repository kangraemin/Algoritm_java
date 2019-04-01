
public class LinkedList_prob {
	
}

class Linked_list{

	private Node head = new Node();
	private Node tail = new Node();
	private int list_size = 0;
	Linked_list(){
		head.next = tail;
	}
	class Node{
		Node next = null;
		int data; 
		Node(int int_data){
			this.data = int_data;
		}
		Node(){
			
		}
	}
	boolean is_it_empty() {
		if(this.list_size ==0) {
			return true;
		}
		return false;
	}
	
	int get_size_num() {
		return this.list_size;
	}
	void print_all_in_it() {
		Node n = head;
		for(int i = 0 ; i < this.list_size ; i ++) {
			System.out.println(i+1 + "번째 노드의 값 : " + n.next.data);
			n = n.next;
		}
	}
	
	void Add_To_tail(int int_data) {
		Node new_node = new Node(int_data);
		Node n = head;
		while(n.next != tail) {
			 n = n.next;
		}
		n.next = new_node;
		new_node.next = tail;
		this.list_size++;
	}
	
	void Delete_At_tail() {
		Node n = head;
		while(n.next.next != tail) {
			n = n.next;
		}
		Node temp = n.next;
		n.next = tail;
		temp.next = null;
		this.list_size--;
	}
	
	void Add_At_Pos(int int_data, int at_node_pos) {
		Node new_node = new Node(int_data);
		Node n = head;
		for(int i = 0 ; i < at_node_pos ; i ++) {
			n = head.next;
		}
		new_node.next = n.next;
		n.next = new_node;
		this.list_size++;
	}
	
	void Delete_At_Pos(int node_pos) {
		Node n = head;
		for(int i = 0 ; i < node_pos ; i++) {
			n = n.next;
		}
		Node temp = n.next.next;
		n.next.next = null;
		n.next = temp;
		this.list_size--;
	}
}