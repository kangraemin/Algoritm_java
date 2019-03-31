import java.util.ArrayList;

public class Algorithm_study {

	public static void main(String[] args) {
//		list_prob_method();
		recursive_prob_method();
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


