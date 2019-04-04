import java.util.ArrayList;

public class Algorithm_study {

	public static void main(String[] args) {
//		list_prob_method();
//		recursive_prob_method();
//		check_Double_Linked_List_Method();
//		System.out.println("구분------------------------------");
//		check_single_linked_list_method();
//		linked_list_prob_method();
//		check_stack_method();
//		check_queue_method();
		
	}
	public static void stack_queue_prob() {
		
	}
	public static void check_queue_method() {
		Ram_Queue queue = new Ram_Queue();
		System.out.println(queue.is_it_empty());
		queue.add(3);
		System.out.println(queue.is_it_empty());
		queue.add(2);
		System.out.println(queue.peek().data);
		queue.print_all_in_it();
		queue.add(6);
		System.out.println("--구분--");
		queue.print_all_in_it();
		queue.add(4);
		System.out.println("--구분--");
		queue.print_all_in_it();
		System.out.println("--구분--");
		System.out.println(queue.peek().data);
		queue.remove();
		queue.print_all_in_it();
		System.out.println("--구분--");
		queue.remove();
		queue.print_all_in_it();
		System.out.println("--구분--");
		System.out.println(queue.is_it_empty());
		queue.remove();
		queue.print_all_in_it();
		System.out.println("--구분--");
		queue.remove();
		System.out.println(queue.is_it_empty());
//		queue.remove(); //에러뜸
	}
	public static void check_stack_method() {
		Ram_Stack stack = new Ram_Stack();
		System.out.println(stack.is_it_empty());
		stack.push(3);
		System.out.println(stack.is_it_empty());
		System.out.println("--구분--");
		stack.print_all_in_it();
		stack.push(5);
		int a = stack.peek().data;
		System.out.println("--구분--");
		stack.print_all_in_it();
		System.out.println("--구분--");
		System.out.println("peek 값 : " + a);
		stack.push(6);
		System.out.println("--구분--");
		stack.print_all_in_it();
		stack.pop();
		System.out.println("--구분--");
		stack.print_all_in_it();
		System.out.println("--구분--");
		System.out.println(stack.is_it_empty());
		stack.pop();
		stack.pop();
		System.out.println("--구분--");
		System.out.println(stack.is_it_empty());
		
	}
	public static void linked_list_prob_method () {
		System.out.println("Prob_1");
		LinkedList_prob.Prob_1 prob_1 = new LinkedList_prob.Prob_1();
		Single_Linked_list single_Linked_list = new Single_Linked_list();
		single_Linked_list.Add_To_tail(4);
		single_Linked_list.Add_To_tail(2);
		single_Linked_list.Add_To_tail(2);
		single_Linked_list.Add_To_tail(3);
		single_Linked_list.Add_To_tail(6);
		single_Linked_list.Add_To_tail(4);
		single_Linked_list.Add_To_tail(5);
		Single_Linked_list del_dup_list = prob_1.del_Duplicate_Node(single_Linked_list);
		del_dup_list.print_all_in_it(); // 42365거 나와야 함 
		
		System.out.println("Prob_2");
		LinkedList_prob.Prob_2 prob_2 = new LinkedList_prob.Prob_2();
		int k_th_from_behind = 3;
		// 6이 나와야 함 
		System.out.println(prob_2.get_k_th_Node_From_Behind(single_Linked_list, k_th_from_behind).data);
		
		System.out.println("Prob_3");
		LinkedList_prob.Prob_3 prob_3 = new LinkedList_prob.Prob_3();
		Single_Linked_list del_median_node_list = prob_3.del_median_node(single_Linked_list);
		// 422645가 나와야함 
		del_median_node_list.print_all_in_it();
		
		System.out.println("Prob_4");
		LinkedList_prob.Prob_4 prob_4 = new LinkedList_prob.Prob_4();
		int split_int = 3;
		Single_Linked_list split_list = prob_4.split_node_by_integer(single_Linked_list, split_int);
		// 224645 가 나와야함 
		split_list.print_all_in_it();
		
		System.out.println("Prob_5");
		LinkedList_prob.Prob_5 prob_5 = new LinkedList_prob.Prob_5();
		single_Linked_list.del_all_node();
		single_Linked_list.Add_To_tail(6);
		single_Linked_list.Add_To_tail(1);
		single_Linked_list.Add_To_tail(7);
		Single_Linked_list add_list = new Single_Linked_list();
		add_list.Add_To_tail(2);
		add_list.Add_To_tail(9);
		add_list.Add_To_tail(5);
		Single_Linked_list sum_list = prob_5.get_sum_of_lined_list(single_Linked_list, add_list);
		// 912가 나와야함 
		sum_list.print_all_in_it();
	}
	public static void check_Double_Linked_List_Method() {
		Double_Linked_list linked_list = new Double_Linked_list();
		System.out.println(linked_list.is_it_empty());
		System.out.println(linked_list.get_size_num());
		linked_list.print_all_in_it(); 
		linked_list.Add_To_tail(2);
		System.out.println(linked_list.is_it_empty());
		System.out.println(linked_list.get_size_num());
		linked_list.print_all_in_it();
		linked_list.Add_At_Pos(1, 0);
		System.out.println(linked_list.is_it_empty());
		System.out.println(linked_list.get_size_num());
		linked_list.print_all_in_it();
		linked_list.Delete_At_tail();
		System.out.println(linked_list.is_it_empty());
		System.out.println(linked_list.get_size_num());
		linked_list.print_all_in_it();
		linked_list.Add_At_Pos(123, 0);
		linked_list.print_all_in_it();
		System.out.println(linked_list.is_it_empty());
		System.out.println(linked_list.get_size_num());
		linked_list.Delete_At_Pos(0);
		linked_list.print_all_in_it();
		System.out.println(linked_list.is_it_empty());
		System.out.println(linked_list.get_size_num());
		linked_list.Delete_At_tail();
		linked_list.print_all_in_it();
		System.out.println(linked_list.is_it_empty());
		System.out.println(linked_list.get_size_num());
	}
	public static void check_single_linked_list_method() {
		Single_Linked_list linked_list = new Single_Linked_list();
		System.out.println(linked_list.is_it_empty());
		System.out.println(linked_list.get_size_num());
		linked_list.print_all_in_it(); 
		linked_list.Add_To_tail(2);
		System.out.println(linked_list.is_it_empty());
		System.out.println(linked_list.get_size_num());
		linked_list.print_all_in_it();
		linked_list.Add_At_Pos(1, 0);
		System.out.println(linked_list.is_it_empty());
		System.out.println(linked_list.get_size_num());
		linked_list.print_all_in_it();
		linked_list.Delete_At_tail();
		System.out.println(linked_list.is_it_empty());
		System.out.println(linked_list.get_size_num());
		linked_list.print_all_in_it();
		linked_list.Add_At_Pos(123, 0);
		linked_list.print_all_in_it();
		System.out.println(linked_list.is_it_empty());
		System.out.println(linked_list.get_size_num());
		linked_list.Delete_At_Pos(0);
		linked_list.print_all_in_it();
		System.out.println(linked_list.is_it_empty());
		System.out.println(linked_list.get_size_num());
		linked_list.Delete_At_tail();
		linked_list.print_all_in_it();
		System.out.println(linked_list.is_it_empty());
		System.out.println(linked_list.get_size_num());
	}
	public static void recursive_prob_method() {
		
		Recursive_prob.Prob_1 prob_1 = new Recursive_prob.Prob_1();
		int test_stair_num_prob_1 = 4;
		System.out.println(prob_1.get_ways_num_to_up_stairs(test_stair_num_prob_1));
		
		Recursive_prob.Prob_2 prob_2 = new Recursive_prob.Prob_2();
		int test_width_prob_2 = 2; 
		int test_height_prob_2 = 2;
		int[] test_prohibit_cell_prob_2 = {1,1}; 
		System.out.println(prob_2.get_ways_num_to_destination(test_width_prob_2, test_height_prob_2, test_prohibit_cell_prob_2));
		
		Recursive_prob.Prob_4 prob_4 = new Recursive_prob.Prob_4();
		char[] test_char_set_prob_4 = {'a','b','c','d'};
		ArrayList<char[]> a = new ArrayList<char[]>();
		prob_4.get_subset(test_char_set_prob_4);
		
		Recursive_prob.Prob_5 prob_5 = new Recursive_prob.Prob_5();
		int test_num_1_prob_5 = 4;
		int test_num_2_prob_5 = 3;
		System.out.println(prob_5.get_multi_num(test_num_1_prob_5, test_num_2_prob_5));
		
		Recursive_prob.Prob_7 prob_7 = new Recursive_prob.Prob_7();
		String test_str_prob_7 = "aabb";
		prob_7.String_permutation(test_str_prob_7);
		
		
	}
	public static void list_prob_method() {
		
		List_prob.Prob_1 prob_1 = new List_prob.Prob_1();
		String[] test_set = {"abc","ccd","abcd","abcddda","kqderhn"};
		prob_1.test_print(test_set);
		
		List_prob.Prob_2 prob_2 = new List_prob.Prob_2();
		System.out.println(prob_2.check_permutation_relation("abacss","bsscaa"));
		
		List_prob.Prob_3 prob_3 = new List_prob.Prob_3();
		String test_string_prob_3 = "Mr John Smith";
		System.out.println(prob_3.space_to_url(test_string_prob_3));
		System.out.println(prob_3.space_to_url_from_char_set(test_string_prob_3, test_string_prob_3.length()));
		
		List_prob.Prob_4 prob_4 = new List_prob.Prob_4();
		String test_string_prob_4 = "abc";
		System.out.println(prob_4.is_it_palindrome(test_string_prob_4));
		
		List_prob.Prob_5 prob_5 = new List_prob.Prob_5();
		String test_string_prob_5 = "pale";
		String test_string_prob_5_1 = "bake";
		System.out.println(prob_5.can_i_change_in_one_try(test_string_prob_5, test_string_prob_5_1));
		
		List_prob.Prob_6 prob_6 = new List_prob.Prob_6();
		String test_string_prob_6 = "aaaabccc";
		System.out.println(prob_6.Compressor(test_string_prob_6));
	}
}


