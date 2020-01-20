/*
* 값을 비교할 때 long 형변환을 해주어 비교해야한다.
* int로 변환하여 비교하면 오버플로우가 발생하기 때문이다.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2529 {
	static String[] inequality;
	static String mins = "", maxs = "";

	public static void getMinValue(String str) {
		if (mins.equals("")) {
			mins = str;
			return;
		}
		if (Long.parseLong(mins) > Long.parseLong(str))
			mins = str;
	}

	public static void getMaxValue(String str) {
		if (maxs.equals("")) {
			maxs = str;
			return;
		}
		if (Long.parseLong(maxs) < Long.parseLong(str))
			maxs = str;
	}

	public static void dfs(int index, String str, int before) {
		if (index == inequality.length) {
			getMinValue(str);
			getMaxValue(str);
			return;
		}
		for (int i = 0; i <= 9; i++) {
			if (!str.contains(Integer.toString(i))) {
				if (inequality[index].equals("<") && before < i) {
					dfs(index + 1, str + Integer.toString(i), i);
				}
				if (inequality[index].equals(">") && before > i) {
					dfs(index + 1, str + Integer.toString(i), i);
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		inequality = new String[n];
		inequality = br.readLine().split(" ");
		for (int i = 0; i <= 9; i++)
			dfs(0, Integer.toString(i), i);
		System.out.printf("%s\n%s", maxs, mins);
		br.close();
	}

}
