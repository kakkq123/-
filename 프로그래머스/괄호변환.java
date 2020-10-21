import java.util.*;

class Solution {
    public String solution(String p) {
        return solve(p);
    }

	private static String solve(String p) {
		if (p.isEmpty())
			return p;
		// u와 v로 분리
		String[] s = distribute(p); //s[0] : u, s[1] : v
		String u = s[0];
        //u가 올바른 괄호 문자열
        if(check(u)){
		    String v = solve(s[1]);
            return u + v;
        }
        //u가 균형잡힌 괄호 문자열
		StringBuilder sb = new StringBuilder("(");
        sb.append(solve(s[1]));
        sb.append(')');
		for (int i = 1; i < u.length() - 1; i++) {
			if (p.charAt(i) == '(')
				sb.append(')');
			else
				sb.append('(');
		}	    
	    return sb.toString();
	}
    //올바른 괄호인지 확인하는 함수
	private static boolean check(String p) {
		int cnt1 = 0, cnt2 = 0;
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '(')
				cnt1++;
			else
				cnt2++;
			if (cnt1 < cnt2)
				return false;

		}
		if (cnt1 == cnt2)
			return true;
		return false;

	}
    //문자열 나누기(최소단위)
    private static String[] distribute(String p) {
		int cnt1 = 0, cnt2 = 0, i;
		for (i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '(')
				cnt1++;
			else
				cnt2++;
			if (cnt1 == cnt2)
				break;
		}
		String[] answer = new String[2];
		answer[0] = p.substring(0, i + 1);
		answer[1] = p.substring(i + 1, p.length());
		return answer;
	}
}
