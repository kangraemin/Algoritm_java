import java.util.ArrayList;
import java.util.Stack;

public class Recursive_prob {
	
	static class Prob_1{
		public int get_ways_num_to_up_stairs(int stair_num) {
			if(stair_num == 1) {
				return 1;
			} else if (stair_num == 2) {
				return 2;
			} else if (stair_num == 3) {
				return 4;
			} else {
				return get_ways_num_to_up_stairs(stair_num-1) + get_ways_num_to_up_stairs(stair_num-2) + get_ways_num_to_up_stairs(stair_num-3);
			}
		}
	}
	
	static class Prob_2{
		public int get_ways_num_to_destination(int width, int height, int[] prohibit_cell) {
			if(width == 0 || height == 0) {
				return 1;
			} else if(width == prohibit_cell[0] && height == prohibit_cell[1] ) {
				return 0;
			}	else {
				return get_ways_num_to_destination(width-1, height, prohibit_cell) + get_ways_num_to_destination(width, height-1, prohibit_cell);
			}
		}
	}
	
	static class Prob_3{
//		public boolean is_magic_index__in(int[] int_set) {
//			
//		}
	}

	static class Prob_4 {
		public void get_subset(char[] char_set) {
			ArrayList<char[]> memo = new ArrayList<char[]>();
			char[] new_char_set = {};
			memo = get_subset_real(char_set,new_char_set,memo);
			for(int i = 0 ; i < memo.size() ; i ++) {
				for(int j = 0 ; j < memo.get(i).length ; j ++) {
					System.out.print(memo.get(i)[j]);
				}
				System.out.println();
			}
		}
		
		// memo -> 부분집합 담긴것 
		public ArrayList<char[]> get_subset_real(char[] char_set, char[] char_set_2, ArrayList<char[]> memo) {
			
			// memo 안에 있나 물어보기 위한 변수 
			boolean is_it_in = false; 
			
			// 종료조건, 왼쪽의 길이가 0이면 memo 리턴 
			if(char_set.length == 0) {
				return memo;
			} else {
				// 메모안에 없다면 해당 char_set이 없다면  
				for(int i = 0 ; i < memo.size() ; i ++) {
					if(is_it_changable(memo.get(i), char_set)) {
						is_it_in = true;
					}
				}
				
				// 메모안에 해당 char_set이 없다면 
				if(!is_it_in) {
					memo.add(char_set);
				}
				
				for(int i = char_set.length-1 ; i > 0 ; i--) {
					char[] char_set_new = new char[char_set.length-1];
					int[] index_set = new int[char_set.length-1];
					char[] char_set_new_2 = new char[char_set_2.length+1];
					int index = 0;
					for(int k = 0 ; k <char_set.length ; k ++) {
						if(k != i) {
							index_set[index++] = k;
						} else {
							continue;
						}
					}
					for(int j = 0 ; j < index_set.length ; j ++) {
						char_set_new[j]= char_set[index_set[j]] ;
					}
					for(int j = 0 ; j < char_set_2.length ; j ++) {
						char_set_new_2[j] = char_set_2[j];
					}
					char_set_new_2[char_set_2.length] = char_set[i];
					
					is_it_in = false; 
					// 메모안에 없다면 해당 char_set이 없다면  
					for(int k = 0 ; k < memo.size() ; k ++) {
						if(is_it_changable(memo.get(k), char_set_new)) {
							is_it_in = true;
						}
					}
					
					// 메모안에 해당 char_set이 없다면 
					if(!is_it_in) {
						memo.add(char_set_new);
					}
					
					is_it_in = false; 
					// 메모안에 없다면 해당 char_set이 없다면  
					for(int k = 0 ; k < memo.size() ; k ++) {
						if(is_it_changable(memo.get(k), char_set_new_2)) {
							is_it_in = true;
						}
					}
					
					// 메모안에 해당 char_set이 없다면 
					if(!is_it_in) {
						memo.add(char_set_new_2);
					}
					
					memo = get_subset_real(char_set_new, char_set_new_2, memo);
				}
			}
			return memo;
		}
		
		// 같은 순서 쌍으로 되어있는지 ? 
		public boolean is_it_changable(char[] char_set_1, char[] char_set_2) {
			char[] sorted_char_set_1 = sorting_char_set(char_set_1);
			char[] sorted_char_set_2 = sorting_char_set(char_set_2);
			
			if(sorted_char_set_1.length != sorted_char_set_2.length) {
				return false;
			} else {
				for(int i = 0 ; i < sorted_char_set_1.length ; i ++) {
					if(sorted_char_set_1[i] != sorted_char_set_2[i]) {
						return false;
					}
				}
				return true;
			}
		}
		public char[] sorting_char_set(char[] char_set) {
			char temp;
			for(int i = 0 ; i < char_set.length ; i ++) {
				for(int j = i ; j < char_set.length ; j ++) {
					if(char_set[i] > char_set[j]) {
						temp = char_set[i];
						char_set[i] = char_set[j];
						char_set[j] = temp;
					}
				}
			}
			return char_set;
		}
	}
	
	static class Prob_6{
		public void Hanoi_Tower(int tower_height) {
			Stack<Integer> Left_tower = new Stack<>();
			Stack<Integer> Middle_tower = new Stack<>();
			Stack<Integer> Right_tower = new Stack<>();
			for(int i = tower_height ; i > 0 ; i --) {
				Left_tower.push(i);
			}
			Hanoi_recursive(Left_tower, Middle_tower, Right_tower);
		}
		public void Hanoi_recursive(Stack<Integer> Left,Stack<Integer> Middle,Stack<Integer> Right) {
			if(Right.size() == Left.size()+Middle.size()+Right.size()) {
				System.out.println("하노이 타워 완성");
			} else if(Middle.size() == 0 && Left.pop()==1){
				System.out.println(Left.pop().toString()+"을 Left to Middle" );
				Middle.push(Left.pop());
				Hanoi_recursive(Left, Middle, Right);
			} else if(Left.size() == 0) {
				System.out.println(Left.pop().toString()+"을 Middle to Right" );
				Middle.push(Left.pop());
				Hanoi_recursive(Left, Middle, Right);
			}
		}
	}
	
	static class Prob_5{
		public int get_multi_num(int num_1, int num_2) {
			int sum = 0;
			int small_num = (num_1 > num_2) ? num_2 : num_1;
			int big_num = (num_1 > num_2) ? num_1 : num_2;
			return multi_num_recursive(big_num, small_num, sum);
		}
		
		public int multi_num_recursive(int big_num, int small_num, int sum) {
			if(small_num == 1) {
				return big_num;
			} else {
				sum = big_num + multi_num_recursive(big_num, small_num-1, sum);
			}
			return sum;
		}
	}
	
	static class Prob_7{
		public void String_permutation(String str){
			// 자주 쓰기때문에 주고 
			int factorial_num = get_factorial_num(str.length());
			// 위와 마찬가지로 최악은 팩토리얼이기때문에 이만큼 줌 
			String[] string_set = new String[factorial_num];
			// 왼쪽의 prefix가 str과 같아지면 해당 prefix를 return해줌 
			String string_set_temp = get_permutation_string("", str, str.length());
			
			// string_set_temp에는 문자열의 모든 순열이 들어있기 때문에 이것을 끊어서 배열에 넣어주어야함 
			int num1 = 0;
			int num2 = num1 + str.length(); // num2 - num1 -> str.length()맞추기용 
			for(int i = 0 ; i < factorial_num ; i++) {
				if(num2 <= string_set_temp.length()) {
					// 담기 
					string_set[i] = string_set_temp.substring(num1, num2);
					num1 += str.length();
					num2 += str.length();
				}
			}
			print_permutation_value(string_set);
		}
		// 이해가 힘들면 tree를 그려볼 것, prefix가 str과 같아지는 순간 함수 종료 
		public String get_permutation_string(String prefix, String str, int str_len) {
			// 아무것도 없는것에 계속해서 더해나가서 해당 string return 
			String s = "";
			if(prefix.length() == str_len) {
				return prefix;
			} else {
				for(int i = 0 ; i < str.length() ; i ++) {
					// 문자 하나(씩)만 빼고 
					String rem = str.substring(0, i) + str.substring(i+1, str.length());
					// pref에 방금 뺀 문자 넣고 재귀함수호출 
					String pref = prefix + str.charAt(i);
					s = s + get_permutation_string(pref, rem, str_len);
				}
				return s;
			}
		}
		// 팩토리얼 수 구하기 
		public int get_factorial_num(int num) {
			if(num==1) {
				return 1;
			} else {
				return num * get_factorial_num(num-1);
			}
		}
		public void print_permutation_value(String[] str_set) {
			String[] del_dup_string = new String[str_set.length];
			int index = 0 ;
			for(int i = 0 ; i < str_set.length ; i ++) {
				boolean is_it_dup = false;
				for(int j = 0 ; j < str_set.length ; j ++) {
					if(str_set[i].equals(del_dup_string[j])) {
						is_it_dup = true;
						break;
					}
				}
				if(!is_it_dup) {
					del_dup_string[index++] = str_set[i];
				}
			}
			for(int i = 0 ; i < index; i ++) {
				if(!is_it_dup(del_dup_string[i])) {
					System.out.println(del_dup_string[i]);
				}
			}
		}
		public boolean is_it_dup(String str) {
			for(int i= 0 ; i < str.length()-1 ; i ++) {
				if(str.charAt(i) == str.charAt(i+1)) {
					return true;
				}
			}
			return false;
		}
	}
}
