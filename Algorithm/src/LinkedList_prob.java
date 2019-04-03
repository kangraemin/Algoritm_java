

public class LinkedList_prob {
	static class Prob_5{
		public Single_Linked_list get_sum_of_lined_list(Single_Linked_list linked_list_1, Single_Linked_list linked_list_2) {
			int above_ten_num = 0;
			int sum = 0 ;
			Single_Linked_list sum_of_list= new Single_Linked_list();
			for(int i = linked_list_1.get_size_num()-1 ; i >= 0 ; i --) {
				sum_of_list.Add_At_Pos(above_ten_num, 0);
				above_ten_num = 0;
				sum = sum_of_list.get_data_at_node_pos(0)+linked_list_1.get_data_at_node_pos(i) + linked_list_2.get_data_at_node_pos(i);
				if(sum >= 10) {
					above_ten_num = 1;
					sum_of_list.replace_At_Pos(sum-10, 0);
				} else {
					sum_of_list.replace_At_Pos(sum, 0);
				}
			}
			if(above_ten_num == 1) {
				sum_of_list.Add_At_Pos(above_ten_num, 0);
			}
			return sum_of_list;
		}
	}
	static class Prob_4{
		public Single_Linked_list split_node_by_integer(Single_Linked_list linked_list,int x) {
			int temp_int = 0 ; 
			for(int i = 0 ; i < linked_list.get_size_num() ; i ++) {
				if(linked_list.get_data_at_node_pos(i) < x ) {
					temp_int = linked_list.get_data_at_node_pos(i);
					linked_list.Delete_At_Pos(i);
					linked_list.Add_At_Pos(temp_int, 0);
				}
			}
			return linked_list;
		}
	}
	static class Prob_3{
		public Single_Linked_list del_median_node(Single_Linked_list linked_list) {
			if(linked_list.get_size_num() <= 2) {
				System.out.println("Impossible to del ( list size does not enough long ) ");
			} else {
				linked_list.Delete_At_Pos(linked_list.get_size_num()/2);
			}
			return linked_list;
		}
	}
	
	static class Prob_2{
		public Single_Linked_list.Node get_k_th_Node_From_Behind(Single_Linked_list linked_list, int k) {
			Single_Linked_list.Node node = linked_list.get_node_at_pos(linked_list.get_size_num()-k);
			return node;
		}
	}
	static class Prob_1{
		public Single_Linked_list del_Duplicate_Node(Single_Linked_list linked_list) {
			Single_Linked_list del_dup = new Single_Linked_list();
			for(int i = 0 ; i < linked_list.get_size_num() ; i ++) {
				if(!check_Is_in_It(del_dup, linked_list.get_data_at_node_pos(i))) {
					del_dup.Add_To_tail(linked_list.get_data_at_node_pos(i));
				}
			}
			return del_dup;
		}
		public boolean check_Is_in_It(Single_Linked_list linked_list, int int_data) {
			for(int i = 0 ; i < linked_list.get_size_num() ; i ++) {
				if(linked_list.get_data_at_node_pos(i) == int_data) {
					return true;
				}
			}
			return false;
		}
		public Single_Linked_list sorting_Linked_List(Single_Linked_list linked_list) {
			for(int i = 0 ; i < linked_list.get_size_num() ; i ++) {
				for(int j = i ; j < linked_list.get_size_num() ; j ++) {
					if(linked_list.get_data_at_node_pos(i) > linked_list.get_data_at_node_pos(j)) {
						int temp_num;
						temp_num = linked_list.get_data_at_node_pos(i);
						linked_list.replace_At_Pos(linked_list.get_data_at_node_pos(j), i);
						linked_list.replace_At_Pos(temp_num, j);
					}
				}
			}
			return linked_list;
		}
	}
}
class Double_Linked_list{
	private Node head = new Node();
	private Node tail = new Node();
	private int list_size = 0;
	Double_Linked_list() {
		head.next = tail;
		tail.prev = head; 
	}
	class Node{
		Node next = null;
		Node prev = null; 
		int data;
		Node(int int_data){
			this.data = int_data;
		}
		Node(){
			
		}
	}
	void del_all_node() {
		head.next = tail;
		tail.prev = head;
		list_size = 0;
	}
	Node get_node_at_pos(int pos) {
		Node node = head.next; 
		for(int i = 0 ; i < pos ; i ++) {
			node = node.next;
		}
		return node;
	}
	int get_data_at_node_pos(int pos) {
		Node node = get_node_at_pos(pos);
		return node.data;
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
		new_node.next = tail;
		new_node.prev = tail.prev;
		tail.prev = new_node;
		tail.prev.prev.next = new_node;
		list_size++;
	}
	
	void Delete_At_tail() {
		tail.prev = tail.prev.prev;
		tail.prev.next = tail;
		list_size--;
	}
	
	void Add_At_Pos(int int_data, int at_node_pos) {
		if(at_node_pos == 0 || list_size / at_node_pos == 0 ) {
			Node new_node = new Node(int_data);
			Node node = head;
			for(int i = 0 ; i < at_node_pos ; i ++) {
				node = node.next;
			}
			new_node.next = node.next;
			new_node.prev = node;
			node.next.prev = new_node;
			node.next = new_node;
			list_size++;
		} else {
			Node new_node = new Node(int_data);
			Node node = tail;
			for(int i = list_size ; i > at_node_pos ; i --) {
				node = node.prev;
			}
			new_node.next = node;
			new_node.prev = node.prev;
			node.prev.next = new_node;
			node.prev = new_node;
			list_size++;
		}
	}
	
	void Delete_At_Pos(int at_node_pos) {
		if(at_node_pos == 0 || list_size / at_node_pos == 0 ) {
			Node node = head.next;
			for(int i = 0 ; i < at_node_pos ; i ++) {
				node = node.next;
			}
			node.prev.next = node.next;
			node.next.prev = node.prev;
			node.next = null;
			node.prev = null;
			list_size--;
		} else {
			Node node = tail;
			for(int i = list_size ; i > at_node_pos ; i --) {
				node = node.prev;
			}
			node.prev.next = node.next;
			node.next.prev = node.prev; 
			node.next = null;
			node.prev = null; 
			list_size--;
		}
	}
	void replace_At_Pos(int replace_value, int replace_pos) {
		if(replace_pos == 0 || list_size / replace_pos == 0 ) {
			Node node = head.next;
			for(int i = 0 ; i < replace_pos ; i ++) {
				node = node.next;
			}
			node.data = replace_value;
		} else {
			Node node = tail;
			for(int i = list_size ; i > replace_pos ; i --) {
				node = node.prev;
			}
			node.data = replace_value;
		}
	}
}
class Single_Linked_list{

	private Node head = new Node();
	private Node tail = new Node();
	private int list_size = 0;
	Single_Linked_list(){
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
	void del_all_node() {
		head.next = tail;
		list_size = 0;
	}
	Node get_node_at_pos(int pos) {
		Node node = head.next; 
		for(int i = 0 ; i < pos ; i ++) {
			node = node.next;
		}
		return node;
	}
	int get_data_at_node_pos(int pos) {
		Node node = get_node_at_pos(pos);
		return node.data;
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
	void replace_At_Pos(int replace_value, int replace_pos) {
		Node node = head.next;
		for (int i = 0 ; i < replace_pos ; i ++) {
			node = node.next;
		}
		node.data = replace_value;
	}
}