

public class List_prob{
	
	static class Prob_6{
		public String Compressor(String str) {
			// 압축된 String 형태를 char / int로 나누어 배열에 담고 나중에 합칠것이다. 
			int[] num_char = new int[str.length()];
			char[] char_set = new char[str.length()];
			
			// num_char, char_set의 index값 
			int index = 0;
			// int_char에 넣기 위한 값 ( 같은게 계속되면 계속 더해지고 바로 다른거 나오면 바로 1 ) 
			int same_num = 1;
			for(int i = 0 ; i < str.length() ; i ++) {
				if(i == str.length()-1) {
					// 마지막번째는 다음 문자열이 없어 비교 할 수 없기 때문에 케이스 나누어 줌 
					// 이전꺼와 같더라도, 다르더라도 코드는 같음 ( 다를땐 same_num이미 초기화 되었기 때문 ) 
					char_set[index] = str.charAt(i);
					num_char[index++] = same_num;
				} else {
					if(str.charAt(i) == str.charAt(i+1)) {
						// i번째 문자와 그다음 문자가 같을 때 same_num을 더해주어 몇개가 같은지 셈
						same_num++;
						continue;
					} else {
						// 해당하는 index에 문자와 숫자를 넣고, index값 더해줌 
						char_set[index] = str.charAt(i);
						num_char[index++] = same_num;
						
						// 같은것이 더이상 없기 때문에 1로 초기화 
						same_num = 1;
					}
				}
			}
			StringBuilder sb = new StringBuilder();
			for(int i = 0 ; i < index ; i++) {
				// 문자 ( char )들 스트링화 
				sb.append(char_set[i]);
				sb.append((char)(num_char[i]+'0'));
			}
			sb.toString();
			if(sb.toString().length() > str.length()) {
				return str;
			} else {
				return sb.toString();
			}
		}
	}
	static class Prob_5{
		public boolean can_i_change_in_one_try(String str_1, String str_2) {
			
			// 문자에 포함된 글자의 갯수가 차이를 기준으로 나눌 것 
			int len_diff = Math.abs(str_1.length() - str_2.length());
			
			// 문자의 갯수 차이가 2이상이면 한번의 처리만에 바꿀 수 없으니 바로 false 
			if(len_diff > 1) {
				return false;
			} else {
				// 문자의 갯수의 차이가 1 이하이면 각 알파벳이 몇개가 다른가 셈 
				int num_different_char = num_different_char(str_1, str_2);
				if(len_diff == 1) {
					//갯수가 다를때 ( 1개차이 ) 
					if(num_different_char == 0) {
						// 속한 알파벳 모두 같아야한다. 
						return true;
					} else {
						// 아니면 false 
						return false;
					}
				} else { 
					// 갯수가 같을때 
					if(num_different_char <= 1) {
						// 다른 개수가 1 -> 1개만 수정하면 됨 
						// 다른 개수가 0 -> 같은 것
						return true;
					} else {
						// 다른 개수가 2이상 -> false 
						return false;
					}
				}
			}
		}
		// string을 쪼개서 다른 char갯수를 셀 메소드 
		public int num_different_char(String str_1, String str_2) {
			int diff_cnt = 0 ;
			if(str_1.length() < str_2.length()) {
				for(int i = 0 ; i < str_1.length() ; i ++) {
					if(str_1.charAt(i) != str_2.charAt(i)) {
						diff_cnt++;
					}
				}
			} else {
				for(int i = 0 ; i < str_2.length() ; i ++) {
					if(str_1.charAt(i) != str_2.charAt(i)) {
						diff_cnt++;
					}
				}
			}
			return diff_cnt;
		}
	}
	static class Prob_4{
		public boolean is_it_palindrome(String str) {
			// 모두 소문자화, 공백을 없앤 뒤에 비교한다. 
			str = str.toLowerCase();
			str = str.replaceAll(" ", "");
			
			// 문자열에 속한 문자들을 중복을 빼서 하나의 배열에 담아준다. 
			char[] char_set = get_char_set(str);
			
			// 문자들의 갯수도 배열에 담음 
			int[] char_num_set = get_char_num(str, char_set);
			
			// 문자열의 길이 ( 공백을 뺀 )구하기 
			int sum_all_char_num = 0;
			for(int i = 0 ; i < char_num_set.length ; i ++) {
				sum_all_char_num += char_num_set[i];
			}
			// 만약 문자열의 길이가 홀수라면 -> 문자가 홀수번 나온것은 반드시 1번 있어야 한다. 2번 이상 나오면 false ( 0번 나오는것은 존재 불가 )  
			if(sum_all_char_num % 2 == 1) {
				int cnt_odd_num = 0;
				for(int i = 0 ; i < char_num_set.length ; i ++ ) {
					if(char_num_set[i] % 2 == 1) {
						cnt_odd_num++;
						if(cnt_odd_num == 2) {
							return false;
						}
					}
				}
				return true;
			} else { // 문자열의 길이가 짝수라면 -> 문자가 홀수번 나온게 있으면 false 없으면 true 
				for(int i = 0 ; i < char_num_set.length ; i ++ ) {
					if(char_num_set[i] % 2 == 1) {
						return false;
					}
				}
				return true;
			}
		}
		
		// 중복된 char 없앤 char_set 구하기 
		public char[] get_char_set(String str) {
			char[] char_set = new char[str.length()];
			for(int i = 0 ; i < str.length() ; i ++) {
				boolean check_is_it_in_char_set = false;
				for(int j = 0 ; j < str.length() ; j++) {
					// char_set속에 해당 문자(str.charAt(i))가 한번이라도 있으면 
					if(char_set[j] == str.charAt(i)) {
						check_is_it_in_char_set = true;
						break;
					}
				}
				// 한번도 안나왔다면 새로운 문자임으로 charset에 대입 아니면 pass  
				if(!check_is_it_in_char_set) {
					char_set[i] = str.charAt(i);
				}
			}
			return char_set;
		}
		
		// 문자열에 char_set( 중복이 빠진 문자 )가 몇개나 들어있는지 char_set의 순서대로 반환 
		public  int[] get_char_num(String str,char[] char_set) {
			int[] char_num_set = new int[char_set.length]; 
			for(int i = 0 ; i < char_set.length ; i ++) {
				for(int j = 0 ; j < str.length() ; j ++ ) {
					if(char_set[i] == str.charAt(j)) {
						char_num_set[i]++;
					}
				}
			}
			return char_num_set;
		}
	}

	static class Prob_3{
		// replace 함수 쓴것 
		public String space_to_url(String str) {
			String output = str.replaceAll(" ", "%20");
			return output;
		}
		
		// 공간 충분하댔으니 그냥 3배 줌, char_set에는 출력할 문자들 다 넣을꺼 
		public String space_to_url_from_char_set(String str, int str_len) {
			char[] char_set = new char[str_len*3];
			char_set = get_char_set_from_str(str); // string을 char_set으로 바꿨음 
			for(int i = 0 ; i < char_set.length ; i ++ ) {
				if(char_set[i] == ' ') { // 공백이 보이면 
					for(int j = str_len-1 ; j > i ; j --) { // 공백 다음칸 부터 끝까지를 2칸 미루어서 저장한뒤에 
						char_set[j+2] = char_set[j];
					}
					// 해당 문자 삽입해주고 
					char_set[i] = '%';
					char_set[i+1] = '2';
					char_set[i+2] = '0';
					// string의 길이가 2칸만큼 늘어났다고 알림 ( 안알리면 for문 시작점이 변화가 없음 ) 
					str_len = str_len + 2;
				}
			}
			StringBuilder sb = new StringBuilder();
			for(int i = 0 ; i < char_set.length ; i ++ ) {
				sb.append(char_set[i]);
			}
			return sb.toString();
		}
		
		// string -> char배열 
		public char[] get_char_set_from_str(String str) {
			char[] char_set = new char[str.length()*3];
			for(int i = 0 ; i < str.length() ; i ++) {
				char_set[i] = str.charAt(i);
			}
			return char_set;
		}
	}

	static class Prob_2{
		// string의 모든 조합으로 순열을 모두 생성하여 비교 할 것이다. 
		public boolean check_permutation_relation(String str, String test_str) {
			// 최악의 경우 순열이 factorial과 같아지므로 최악의 경우의 공간을 할당해줌 
			// String_permutation -> string 순열들로 이루어진 배열 
			String[] a = new String[get_factorial_num(str.length())];
			a = String_permutation(str);
			String[] b = new String[get_factorial_num(test_str.length())];
			b = String_permutation(test_str);
			for (int i = 0 ; i < a.length ; i ++) {
				for (int j = 0 ; j < b.length ; j ++) {
					// 순열로들이 같은게 있나 확인 있으면 true 한번도 없으면 false 
					if(a[i].equals(b[j]) && a[i] != null && b[j] != null) {
						return true;
					}
				}
			}
			return false;
		}
		
		public String[] String_permutation(String str){
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
			return string_set;
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
	}

	static class Prob_1 {
		// string에 중복 검사 할껀데 
		public boolean check_duplicate_char(String str) {
			for(int i = 0 ; i < str.length()-1 ; i ++) {
				// i+1부터 끝까지 i번째 문자가 있는지 검사한다. 
				if(is_it_in(str.substring(i+1, str.length()),str.charAt(i))) {
					return true;
				}
			}
			return false;
		}
		// 문자 a가 str에 있으면 true 없으면 false 
		public boolean is_it_in(String str, char a) {
			for(int i = 0 ; i < str.length() ; i ++) {
				if(str.charAt(i) == a) {
					return true;
				}
			}
			return false;
		}
		public void test_print(String[] str_set) {
			for (int i = 0 ; i < str_set.length ; i ++) {
				System.out.println(check_duplicate_char(str_set[i]));
			}
		}
	}
}


