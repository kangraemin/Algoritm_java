import java.util.NoSuchElementException;

public class Queue_prob {

}
class Ram_Queue{
	int Queue_size;
	QueueNode first;
	QueueNode last;
	Ram_Queue(){
		Queue_size = 0;
	}
	void print_all_in_it() {
		QueueNode queueNode = first;
		for(int i = 0 ; i < Queue_size ; i ++) {
			if(queueNode == first) {
				System.out.println(i+"번째 Node Data : " + queueNode.data +" (first)");
				queueNode = queueNode.next;
			} else if (queueNode == last) {
				System.out.println(i+"번째 Node Data : " + queueNode.data +" (last)");
				queueNode = queueNode.next;
			} else {
				System.out.println(i+"번째 Node Data : " + queueNode.data);
				queueNode = queueNode.next;
			}
		}
	}
	void add(int int_data) {
		if(Queue_size == 0) {
			QueueNode new_queue_node = new QueueNode(int_data);
			first = new_queue_node;
			last = new_queue_node;
			Queue_size++;
		} else {
			QueueNode new_queue_node = new QueueNode(int_data);
			new_queue_node.next = first;
			first = new_queue_node;
			Queue_size++;
		}
	}
	QueueNode remove() {
		if(Queue_size == 0) {
			System.out.println("error ! ( queue_size = 0 )");
			throw new NoSuchElementException();
		} else if(Queue_size == 1){
			QueueNode return_node;
			return_node = last;
			first = null;
			last = null; 
			Queue_size = 0;
			return last;
		} else {
			QueueNode queueNode = first;
			QueueNode return_node = last;
			for(int i = 1 ; i < Queue_size-1 ; i ++) {
				queueNode = queueNode.next;
			}
			queueNode.next = null;
			last = queueNode;
			Queue_size--;
			return return_node; 
		}
	}
	QueueNode peek() {
		if(Queue_size == 0) {
			System.out.println("error ! ( queue_size = 0 )");
			throw new NoSuchElementException();
		} else {
			return last;
		}
	}
	boolean is_it_empty() {
		if(Queue_size == 0) {
			return true;
		}
		return false;
	}
	class QueueNode{
		int data;
		QueueNode next;
		QueueNode(int int_data){
			this.data = int_data;
			this.next = null;
		}
		QueueNode(){
			this.next = null;
		}
	}
}