

public class Algorithm_study {

	public static void main(String[] args) {
		list_prob_method();
	}
	public static void list_prob_method() {
		
		Prob_1 prob_1 = new Prob_1();
		String[] test_set = {"abc","ccd","abcd","abcddda","kqderhn"};
		prob_1.test_print(test_set);
		
		Prob_2 prob_2 = new Prob_2();
		System.out.println(prob_2.check_permutation_relation("abacss","bsscaa"));
		
		Prob_3 prob_3 = new Prob_3();
		String test_string_prob_3 = "Mr John Smith";
		System.out.println(prob_3.space_to_url(test_string_prob_3));
		System.out.println(prob_3.space_to_url_from_char_set(test_string_prob_3, test_string_prob_3.length()));
		
		Prob_4 prob_4 = new Prob_4();
		String test_string_prob_4 = "abc";
		System.out.println(prob_4.is_it_palindrome(test_string_prob_4));
		
		Prob_5 prob_5 = new Prob_5();
		String test_string_prob_5 = "pale";
		String test_string_prob_5_1 = "bake";
		System.out.println(prob_5.can_i_change_in_one_try(test_string_prob_5, test_string_prob_5_1));
		
		Prob_6 prob_6 = new Prob_6();
		String test_string_prob_6 = "aaaabccc";
		System.out.println(prob_6.Compressor(test_string_prob_6));
	}
}


