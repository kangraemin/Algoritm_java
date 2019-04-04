
public class Stack_prob {
	static class Prob_2{
		int get_min(Ram_Stack stack) {
			return stack.get_min_value();
		}
	}
	static class Prob_4{
		static class Queue_Using_Stacks{
			Ram_Stack stack_1;
			public Queue_Using_Stacks() {
				this.stack_1 = new Ram_Stack();
			}
			
			Ram_Stack stack_shipping(Ram_Stack stack) {
				Ram_Stack temp_stack = new Ram_Stack();
				if(!stack.is_it_empty()) {
					while(!stack.is_it_empty()) {
						temp_stack.push(stack.pop());
					}
				}
				return temp_stack;
			}
			void print_all_in_it() {
				stack_1.print_all_in_it();
			}
			
			Ram_Stack.StackNode remove(){
				Ram_Stack shifted_stack = stack_shipping(stack_1);
				Ram_Stack.StackNode return_node = shifted_stack.peek();
				shifted_stack.pop();
				stack_1 = stack_shipping(shifted_stack);
				return return_node;
			}
			void add(int int_data){
				Ram_Stack shifted_stack = stack_shipping(stack_1);
				shifted_stack.push(int_data);
				stack_1 = stack_shipping(shifted_stack);
			}
			Ram_Stack.StackNode peek(){
				Ram_Stack shifted_stack = stack_shipping(stack_1);
				Ram_Stack.StackNode return_node = shifted_stack.peek();
				stack_1 = stack_shipping(shifted_stack);
				return return_node;
			}
		}
	}
	static class Prob_5{
		static class min_Value_Top_Stack{
			Ram_Stack stack = new Ram_Stack();
			void print_all_in_it() {
				stack.print_all_in_it();
			}
			Ram_Stack stack_order(Ram_Stack order_stack) {
				Ram_Stack temp_stack = new Ram_Stack();
				if(!order_stack.is_it_empty()) {
					while(order_stack.get_min_value() != order_stack.peek().data) {
						temp_stack.push(order_stack.pop());
					}
					int min_of_stack = order_stack.pop();
					while(!temp_stack.is_it_empty()) {
						order_stack.push(temp_stack.pop());
					}
					order_stack.push(min_of_stack);
				}
				return order_stack;
			}
			boolean is_it_empty() {
				return stack.is_it_empty();
			}
			Ram_Stack.StackNode pop(){
				Ram_Stack.StackNode return_node = stack.peek();
				stack.pop();
				stack = stack_order(stack);
				return return_node;
			}
			void push(int int_data) {
				stack.push(int_data);
				stack = stack_order(stack);
			}
			Ram_Stack.StackNode peek(){
				return stack.peek();
			}
		}
	}
}
class Ram_Stack{
	int stack_size;
	StackNode top;
	Single_Linked_list ordered_data_set;
	Ram_Stack(){
		stack_size = 0;
		top = null;
		ordered_data_set = new Single_Linked_list();
	}
	int get_min_value() {
		return ordered_data_set.get_data_at_node_pos(0);
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
		for(int i = 0 ; i < ordered_data_set.get_size_num() ; i ++) {
			if(pop_int == ordered_data_set.get_data_at_node_pos(i)) {
				ordered_data_set.Delete_At_Pos(i);
			}
		}
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
		ordered_data_set.Add_To_tail(int_data);
		ordered_data_set.sorting_data_set();
	}
	class StackNode {
		int data;
		StackNode next;
		StackNode(int int_data){
			this.data = int_data;
		}
	}
}
