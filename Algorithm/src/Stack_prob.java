
public class Stack_prob {
	static class Prob_1{
		
	}
}
class Ram_Stack{
	int stack_size;
	StackNode top; 
	Ram_Stack(){
		stack_size = 0;
		top = null;
	}
	void print_all_in_it() {
		StackNode stackNode = top; 
		for(int i = 0 ; i < stack_size ; i ++) {
			if(stackNode == top) {
				System.out.println("위에서 "+i+"번째 데이터 : "+stackNode.data+" (top)");
				stackNode = stackNode.next;
			} else {
				if(i == stack_size-1) {
					System.out.println("위에서 "+i+"번째 데이터 : "+stackNode.data+" (last)");
					stackNode = stackNode.next;
				} else {
					System.out.println("위에서 "+i+"번째 데이터 : "+stackNode.data);
					stackNode = stackNode.next;
				} 
			}
		}
	}
	boolean is_it_empty() {
		if(stack_size == 0) {
			return true;
		}
		return false;
	}
	int pop() {
		int pop_int = top.data;
		top = top.next;
		stack_size--;
		return pop_int;
	}
	StackNode peek() {
		return top;
	}
	void push(int int_data) {
		StackNode new_stack_node = new StackNode(int_data);
		new_stack_node.next = top;
		top = new_stack_node;
		stack_size++;
	}
	class StackNode {
		int data;
		StackNode next;
		StackNode(int int_data){
			this.data = int_data;
		}
	}
}
