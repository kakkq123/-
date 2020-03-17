import java.util.*;
import java.io.*;

public class 가르침_1062 {
	static int n, k, max = 0;
	static boolean[] alphabet = new boolean[26];
	static HashSet<Integer>[] hash;

	public static void dfs(int number, int index) {
		if (number == k) {
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				boolean flag = true;
				for (int num : hash[i]) {
					if (!alphabet[num]) {
						flag = false;
						break;
					}
				}
				if (flag)
					cnt++;
			}
			max = Math.max(max, cnt);
			return;
		}
		for (int i = index; i < 26; i++) {
			if (alphabet[i])
				continue;
			alphabet[i] = true;
			dfs(number + 1, i + 1);
			alphabet[i] = false;
		}
	}

	public static void solve() {
		if (k < 5)
			return;
		if (k == 26) {
			max = n;
			return;
		}
		k -= 5;
		dfs(0, 0);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		alphabet[0] = alphabet[2] = alphabet[8] = alphabet[13] = alphabet[19] = true;
		hash = new HashSet[n];
		for (int i = 0; i < n; i++) {
			hash[i] = new HashSet<Integer>();
		}

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 4; j <= s.length() - 4; j++) {
				int num = s.charAt(j) - 'a';
				if (!alphabet[num]) {
					hash[i].add(num);
				}
			}
		}
		br.close();

		solve();
		System.out.println(max);
	}

}
