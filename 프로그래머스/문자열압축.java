class Solution {
    public int solution(String s) {
        int answer = s.length(), len = s.length() / 2;
		StringBuilder sb;
		for (int l = 1; l <= len; l++) {
			sb = new StringBuilder();

			String cmp = s.substring(0, l);
			int cnt = 1, i = l;
			while (i + l <= s.length()) {
				if (cmp.equals(s.substring(i, i + l))) {
					cnt++;
				} else {
					if (cnt > 1)
						sb.append(cnt);
					sb.append(cmp);
					cnt = 1;
					cmp = s.substring(i, i + l);
				}
				i += l;
			}
			if (cnt > 1)
				sb.append(cnt + cmp + s.substring(i, s.length()));
			else
				sb.append(s.substring(i-l, s.length()));

			answer = Math.min(answer, sb.length());
		}

		return answer;


    }
}
