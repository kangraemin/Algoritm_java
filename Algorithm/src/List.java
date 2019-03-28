
public class List {

	public static void main(String[] args) {
		
//		Prob_1 prob_1 = new Prob_1();
//		String[] test_set = {"abc","ccd","abcd","abcddda","kqderhn"};
//		prob_1.test_print(test_set);
		
		Prob_2 prob_2 = new Prob_2();
		System.out.println(prob_2.check_permutation_relation("abacss","bsscaa"));
		
		Prob_3 prob_3 = new Prob_3();
		String test_string = "Mr John Smith";
		System.out.println(prob_3.space_to_url(test_string));
		System.out.println(prob_3.space_to_url_from_char_set(test_string, test_string.length()));
		
		
	}
}

class Prob_3{
	public static String space_to_url(String str) {
		String output = str.replaceAll(" ", "%20");
		return output;
	}
	
	public static String space_to_url_from_char_set(String str, int str_len) {
		char[] char_set = new char[str_len*3];
		char_set = get_char_set_from_str(str);
		for(int i = 0 ; i < char_set.length ; i ++ ) {
			if(char_set[i] == ' ') {
				for(int j = str_len-1 ; j > i ; j --) {
					char_set[j+2] = char_set[j];
				}
				char_set[i] = '%';
				char_set[i+1] = '2';
				char_set[i+2] = '0';
				str_len = str_len + 2;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < char_set.length ; i ++ ) {
			sb.append(char_set[i]);
		}
		return sb.toString();
	}
	
	public static char[] get_char_set_from_str(String str) {
		char[] char_set = new char[str.length()*3];
		for(int i = 0 ; i < str.length() ; i ++) {
			char_set[i] = str.charAt(i);
		}
		return char_set;
	}
}

class Prob_2{
	public static boolean check_permutation_relation(String str, String test_str) {
		String[] a = new String[get_factorial_num(str.length())];
		a = String_permutation(str);
		String[] b = new String[get_factorial_num(test_str.length())];
		b = String_permutation(test_str);
		for (int i = 0 ; i < a.length ; i ++) {
			for (int j = 0 ; j < b.length ; j ++) {
				if(a[i].equals(b[j]) && a[i] != null && b[j] != null) {
					return true;
				}
			}
		}
		return false;
	}
	public static String[] String_permutation(String str){
		int factorial_num = get_factorial_num(str.length());
		String[] string_set = new String[factorial_num];
		String string_set_temp = get_permutation_string("", str, str.length());
		int num1 = 0;
		int num2 = num1 + str.length();
		for(int i = 0 ; i < factorial_num ; i++) {
			if(num2 <= string_set_temp.length()) {
				string_set[i] = string_set_temp.substring(num1, num2);
				num1 += str.length();
				num2 += str.length();
			}
		}
		return string_set;
	}
	public static String get_permutation_string(String prefix, String str, int str_len) {
		String s = "";
		if(prefix.length() == str_len) {
			return prefix;
		} else {
			for(int i = 0 ; i < str.length() ; i ++) {
				String rem = str.substring(0, i) + str.substring(i+1, str.length());
				String pref = prefix + str.charAt(i);
				s = s + get_permutation_string(pref, rem, str_len);
			}
			return s;
		}
	}
	
	public static int get_factorial_num(int num) {
		if(num==1) {
			return 1;
		} else {
			return num * get_factorial_num(num-1);
		}
	}
	
//	public static char[] get_char_set(String str) {
//		char[] char_set = new char[str.length()];
//		for(int i = 0 ; i < str.length() ; i ++) {
//			boolean check_is_it_in_char_set = false;
//			for(int j = 0 ; j < str.length() ; j++) {
//				if(char_set[j] == str.charAt(i)) {
//					check_is_it_in_char_set = true;
//					break;
//				}
//			}
//			if(!check_is_it_in_char_set) {
//				char_set[i] = str.charAt(i);
//			}
//		}
//		return char_set;
//	}
}

class Prob_1 {
	public static boolean check_duplicate_char(String str) {
		for(int i = 0 ; i < str.length()-1 ; i ++) {
			if(is_it_in(str.substring(i+1, str.length()),str.charAt(i))) {
				return true;
			}
		}
		return false;
	}
	public static boolean is_it_in(String str, char a) {
		for(int i = 0 ; i < str.length() ; i ++) {
			if(str.charAt(i) == a) {
				return true;
			}
		}
		return false;
	}
	public static void test_print(String[] str_set) {
		for (int i = 0 ; i < str_set.length ; i ++) {
			System.out.println(check_duplicate_char(str_set[i]));
		}
	}
}


