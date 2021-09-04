import java.util.*;
class Solution {
    public int solution(String s) {
        int strLen = s.length();
		int answer = 0;

        // 문자열 길이 만큼 회전
		for (int i = 0; i < strLen; i++) {
            //문자열 회전
			char c = s.charAt(0);
			s = s.substring(1, strLen) + String.valueOf(c);
			
            // 첫 문자열이 닫힌 괄호면 올바른 괄호 문자열이 될 수 없음
			if (s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}')
				continue;
			Stack<Character> stack = new Stack<Character>();
			boolean check = true;
			for (int j = 0; j < strLen; j++) {
                // 열린 괄호는 stack에 넣어줌
				if (s.charAt(j) == '(' || s.charAt(j) == '[' || s.charAt(j) == '{')
					stack.add(s.charAt(j));
                // stack이 비어있거나, 현재에 맞는 닫힌 괄호가 stack top에 위치X 
				else if(stack.size() == 0 || (s.charAt(j) == ')' && stack.peek() !=                           '(') || (s.charAt(j) == ']' && stack.peek() != '[')
						|| (s.charAt(j) == '}' && stack.peek() != '{')) {
					check = false;
					break;
				}
				else {
					stack.pop();
				}
			}
			if (stack.isEmpty() && check)
				answer++;
		}
        return answer;
    }
}
