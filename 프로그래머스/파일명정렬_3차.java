import java.util.*;
class Solution {
  
    public String[] solution(String[] files) {
        	Arrays.sort(files, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				String[] file1 = func(s1);
				String[] file2 = func(s2);
				// head가 같다면 number순으로 오름차순 정렬
				if (file1[0].equalsIgnoreCase(file2[0]))
					return Integer.parseInt(file1[1]) - Integer.parseInt(file2[1]);
				// head순으로 정렬(대소문자 구분 안 함)
				return file1[0].toLowerCase().compareTo(file2[0].toLowerCase());
			}

			private String[] func(String s1) {
				int idx = 0;
				// head
				for (; idx < s1.length(); idx++) {
					if (s1.charAt(idx) >= '0' && s1.charAt(idx) <= '9')
						break;
				}
				String head = s1.substring(0, idx);
				// number;
				int n = idx;
				for (; idx < s1.length(); idx++) {
					if (!(s1.charAt(idx) >= '0' && s1.charAt(idx) <= '9'))
						break;
				}
				String number = s1.substring(n, idx);
				// tail
				String tail = s1.substring(idx, s1.length());
				String[] res = { head, number, tail };
				return res;
			}

		});

		return files;
    }
}
