class Solution {
	boolean solution(String s) {
		boolean answer = false;
		int p = 0, y = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'P' || c == 'p')
				p++;
			if (c == 'Y' || c == 'y')
				y++;
		}
		if (p == y)
			answer = true;
		return answer;
	}
}
