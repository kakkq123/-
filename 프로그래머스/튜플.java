import java.util.*;
class Solution {
    public int[] solution(String s) {
        s = s.substring(1, s.length() - 1);
		s = s.replaceAll("\\}\\,\\{", "#");
		s = s.substring(1, s.length() - 1);

		String[] t = s.split("#");
		Arrays.sort(t, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return Integer.compare(s1.length(), s2.length());// 문자열 길이순 정렬
			}
		});
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(Integer.parseInt(t[0]));
		for (int j = 1; j < t.length; j++) {
			StringTokenizer st = new StringTokenizer(t[j], "\\,");
			while (st.hasMoreTokens()) {
				int _t = Integer.parseInt(st.nextToken());
				if (list.contains(_t))
					continue;
				list.add(_t);
				break;
			}
		}
		int[] answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++)
			answer[i] = list.get(i);
        return answer;
    }
}
