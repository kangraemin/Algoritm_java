import java.util.ArrayList;
import java.util.Stack;

public class Recursive_prob {
	
	static class Prob_1{
		// 계단 수를 받고
		public int get_ways_num_to_up_stairs(int stair_num) {
			// 남은 계단수가 1개면 방법은 하나 
			if(stair_num == 1) {
				return 1;
			} else if (stair_num == 2) {
				// 남은 계단수가 2개면 방법은 2개 
				return 2;
			} else if (stair_num == 3) {
				// 남은 계단수가 3개면 방법은 4개 
				return 4;
			} else {
				// n개의 계단을 올라가는 경우의 수는 크게 세가지다.  
				// 1. 도착하기 전 3칸을 한번에 오르는 경우 
				// 2. 도착하기 전 2칸을 한번에 오르는 경우 
				// 3. 도착하기 전 1칸을 한번에 오르는 경우 
				// 이 세가지가 모두 독립적이고, 각 경우당 경우의 수는 한가지 임으로 이 경우를 모두 더해준다. 
				return get_ways_num_to_up_stairs(stair_num-1) + get_ways_num_to_up_stairs(stair_num-2) + get_ways_num_to_up_stairs(stair_num-3);
			}
		}
	}
	
	static class Prob_2{
		// 너비, 높이, 방해 cell을 입력 받고 
		public int get_ways_num_to_destination(int width, int height, int[] prohibit_cell) {
			if(width == 0 || height == 0) {
				// 좌표가 0 ( 높이 || 너비 = 0 ) 이 되는 경우까지 가는데 필요한 이동의 수는 1가지 ( 쭉 오른쪽 / 쭉 밑의 경우 밖에 없기 때문, 위 / 왼쪽으로 가면 최선의 경우가 아니며 문제에서도 오른쪽 / 밑만 이동 )  
				return 1;
			} else if(width == prohibit_cell[0] && height == prohibit_cell[1] ) {
				// 방해 cell에 가는 경우엔 이동방법은 0개 
				return 0;
			}	else {
				// 높이 - 1칸에서 목적지까지 가는 경우의 수 + 너비 -1칸에서 목적지 까지 가는 경우의 수밖에 없고, 둘이 독립적이므로 더하기 연산 
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
		// 부분집합을 전부 받고 출력 할 메소드 
		public void get_subset(char[] char_set) {
			// 메모엔 부분집합이 담겨있다 ( Memo를 Array로 한 이유는 부분집합이 캐릭터 배열의 형태를 띄기 때문 ) 
			ArrayList<char[]> memo = new ArrayList<char[]>();
			char[] new_char_set = {};
			// char_set에는 입력받은 캐릭터 배열이, new_char엔 빈 배열이 들어있다. 
			// 메모에는 최종적으로 부분집합이 모두 담겨져나와야 한다. 
			memo = get_subset_real(char_set,new_char_set,memo);
			for(int i = 0 ; i < memo.size() ; i ++) {
				for(int j = 0 ; j < memo.get(i).length ; j ++) {
					// 메모안에 있는 부분집합들요소 전부 출력 
					System.out.print(memo.get(i)[j]);
				}
				// 부분집합 구분
				System.out.println();
			}
		}
		
		// memo -> 부분집합 담긴것 
		public ArrayList<char[]> get_subset_real(char[] char_set, char[] char_set_2, ArrayList<char[]> memo) {
			
			// 부분집합으로 나온 것이 memo 안에 있나 물어보기 위한 변수, 없다는 것이 기본값  
			boolean is_it_in = false; 
			
			// 종료조건, 왼쪽의 길이가 0이면 memo 리턴, 왼쪽(char_set)은 모든 값이 들어있는 캐릭터 배열이, 오른쪽(char_set_2)엔 char_set에서 하나 뺀 값들이 들어있는 캐릭터 배열이 들어있다.  
			if(char_set.length == 0) {
				return memo;
			} else {
				// 메모안에 없다면 해당 char_set이 없다면  (자기자신도 부분집합이 되므로) 
				for(int i = 0 ; i < memo.size() ; i ++) {
					// 메모안에 char_set이 있다면 
					// is_it_changable 메소드-> 부분집합 ab, ba는 같은것이기 때문에 memo안에 ba가 있고 char_set에 ab가 있으면 true를 리턴
					// 그렇다면 값이 있다는 것임 
					if(is_it_changable(memo.get(i), char_set)) {
						// 있다고 표시 
						is_it_in = true;
					}
				}
				
				// 메모안에 해당 char_set이 없다면 
				if(!is_it_in) {
					// 메모안에 char_set 추가 
					memo.add(char_set);
				}
				// char_set의 맨 뒷 요소부터 돌 것 
				for(int i = char_set.length-1 ; i > 0 ; i--) {
					// char_set_new엔 char_set에서 한가지 요소를 뺀 캐릭터 배열이 들어감 
					char[] char_set_new = new char[char_set.length-1];
					
					// 위의 작업을 하기위한 index_set 
					int[] index_set = new int[char_set.length-1];
					
					// char_set_new_2엔 char_set에서 한가지 요소를 뺸값과, char_set_2의 값이 들어가 있음  
					char[] char_set_new_2 = new char[char_set_2.length+1];
					
					// index_set의 index를 설정하기 위한 임시변수 
					int index = 0;
					for(int k = 0 ; k <char_set.length ; k ++) {
						// 만약 char_set의 크기가 3이라면 index_set에는 처음엔 {0,1} 두번째엔 {0,2} 세번째엔 {1,2}가 들어가있다. ( char_set의 전체인덱스에서 i만 뺀것 ) 
						if(k != i) {
							// index_set에 값 넣으면 해당 index에 값 넣고 index ++
							index_set[index++] = k;
						} else {
							continue;
						}
					}
					// char_set_new 생성 
					for(int j = 0 ; j < index_set.length ; j ++) {
						char_set_new[j]= char_set[index_set[j]] ;
					}
					// char_set_new_2 생성 
					for(int j = 0 ; j < char_set_2.length ; j ++) {
						char_set_new_2[j] = char_set_2[j];
					}
					// char_set_new_2에 char_set에서 하나 뺀 값 추가 
					char_set_new_2[char_set_2.length] = char_set[i];
					
					// 분기된 부분집합이 memo 안에 있는지 검사위해 변수 초기화 
					is_it_in = false; 
					
					// 메모안에 없다면 해당 char_set_new가 없다면  
					for(int k = 0 ; k < memo.size() ; k ++) {
						if(is_it_changable(memo.get(k), char_set_new)) {
							is_it_in = true;
						}
					}
					
					// 메모안에 해당 char_set_new이 없다면 
					if(!is_it_in) {
						memo.add(char_set_new);
					}
					
					is_it_in = false; 
					// 메모안에 없다면 해당 char_set_new_2가 없다면  
					for(int k = 0 ; k < memo.size() ; k ++) {
						if(is_it_changable(memo.get(k), char_set_new_2)) {
							is_it_in = true;
						}
					}
					
					// 메모안에 해당 char_set_new_2가 없다면 
					if(!is_it_in) {
						memo.add(char_set_new_2);
					}
					// 하나 뺀 상태로 재귀적으로 진행 
					memo = get_subset_real(char_set_new, char_set_new_2, memo);
				}
			}
			// for문 다 돌면 memo엔 부분집합 모두 들어가있음 
			return memo;
		}
		
		// 같은 순서 쌍으로 되어있는지 ? ( 부분집합 ab, ba는 같은것으로 처리하기 위한 메소드 ) 
		public boolean is_it_changable(char[] char_set_1, char[] char_set_2) {
			char[] sorted_char_set_1 = sorting_char_set(char_set_1);
			char[] sorted_char_set_2 = sorting_char_set(char_set_2);
			
			// 길이가 다르다면 반드시 다르기 때문에 false 
			if(sorted_char_set_1.length != sorted_char_set_2.length) {
				return false;
			} else {
				// 같다면 char_set들을 정렬 한 뒤 ( sorting_char_set이 char_set 정렬 해주는 method ) 
				// 다른것이 하나라도 있다면 false 아니면 true 리턴 
				for(int i = 0 ; i < sorted_char_set_1.length ; i ++) {
					if(sorted_char_set_1[i] != sorted_char_set_2[i]) {
						return false;
					}
				}
				return true;
			}
		}
		// char_set 정렬 메소드, selection sorting 
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
	
	static class Prob_5{
		// num1,num2 받고, sum을 리턴할것, 또한 반복횟수 최소화 하기 위해 숫자가 작은 것의 갯수만큼 반복 할 수 있도록 small / big num 정함 
		public int get_multi_num(int num_1, int num_2) {
			int sum = 0;
			int small_num = (num_1 > num_2) ? num_2 : num_1;
			int big_num = (num_1 > num_2) ? num_1 : num_2;
			return multi_num_recursive(big_num, small_num, sum);
		}
		
		// small_num을 1씩 빼면서 재귀 돌리고, small_num이 1이되면 big_num return 
		// ex_ 3 * 10 같은경우 -> 10+10+10이 됨 
		public int multi_num_recursive(int big_num, int small_num, int sum) {
			if(small_num == 1) {
				return big_num;
			} else {
				sum = big_num + multi_num_recursive(big_num, small_num-1, sum);
			}
			return sum;
		}
	}
	
	static class Prob_6{
		// 못품 
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
	
	static class Prob_7{
		public void String_permutation(String str){
			// 자주 쓰는 변수이기 때문에 주고 
			int factorial_num = get_factorial_num(str.length());
			// 순열에서 최악의 경우는 팩토리얼만큼 공간복잡도 가지기 때문에 이만큼 할당  
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
			// string_set 출력위해, 같은것 ( aab, aab ) 제거 위해 
			// 같은것이 생기는 이유 : 같은 문자란 것을 인식하지 않고 모든 순열의 조합을 생각하기 때문에 aab, aab도 포함 되어 있다. 
			// 첫번째 a를 c로 생각하면 aab, aab는 cab, acb와 같기 때문에 aab, aab라는 순열이 생기는것.
			// 중복되는 해당 순열을 제거하고 프린트 하기위해 
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
		// string_set에는 모든 문자 순열들이 담겨 져 있다. 
		public void print_permutation_value(String[] str_set) {
			// 최악의 공간복잡도의 경우엔 str_set.length만큼의 공간이 필요하기 때문에 미리 할당 
			String[] del_dup_string = new String[str_set.length];
			// del_dup_string의 인덱스를 쓰기위한 임시 변수 
			int index = 0 ;
			
			for(int i = 0 ; i < str_set.length ; i ++) {
				// 해당 string이 del_dup_string 배열에 있는지 검사하기 위한 boolean변수, 없다는 것이 기본
				// 있으면 대입 
				boolean is_it_dup = false;
				// 해당문자열(str_set[i])이 del_dup_string에 있다면 
				for(int j = 0 ; j < str_set.length ; j ++) {
					if(str_set[i].equals(del_dup_string[j])) {
						// 있다 
						is_it_dup = true;
						break;
					}
				}
				// 없으면 
				if(!is_it_dup) {
					// del_dup_string에 해당 string 추가 
					del_dup_string[index++] = str_set[i];
				}
			}
			// del_dup_string에 있는거 모두 출력 할것인데, 여기서 문자가 중복해서 나오는 것 제거해서 출력해야함
			// is_it_dup이 해당 string에 문자가 중복해서 나오는지 안나오는지 체크해주는 메소드 
			for(int i = 0 ; i < index; i ++) {
				if(!is_it_dup(del_dup_string[i])) {
					System.out.println(del_dup_string[i]);
				}
			}
		}
		// string 받고 해당 string에 연속해서 중복 char가 나오는지 check 
		// 없으면 false, 있으면 true 
		public boolean is_it_dup(String str) {
			for(int i= 0 ; i < str.length()-1 ; i ++) {
				// 하나라도 같으면 true 
				if(str.charAt(i) == str.charAt(i+1)) {
					return true;
				}
			}
			return false;
		}
	}
}
