import java.util.*;
import java.io.*;

public class 가르침_1062_2 {
	static int n, k, max = 0;
	static boolean[] alphabet = new boolean[26];
	static ArrayList<Integer> a; // 배워야야할 알파벳
	static HashSet<Integer>[] h; // 각 단어당 배워야할 알파벳 모음, 중복된 알파벳 검사 방지 위해 hashset을 사용했지만 메모리를 많이 사용함

	public static void dfs(int number, int index) {
		if (number == k) {
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				boolean flag = true;
				for (int alpha : h[i]) {
					if (!alphabet[alpha]) {
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
		for (int i = index; i < a.size(); i++) {
			if (alphabet[a.get(i)])
				continue;
			alphabet[a.get(i)] = true;
			dfs(number + 1, i + 1);
			alphabet[a.get(i)] = false;
		}
	}

	public static void solve() {
		//a,c,i,n,t 알파벳을 모르면 모든 단어를 배울 수 없음
		if (k < 5)
			return;
		//배워야하는 단어가 최대 배울수 있는 단어 개수보다 작으면 최댓값은 n
		if (a.size() + 5 <= k) {
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
		// 중복저장 방지 -> HashSet 사용
		HashSet<Integer> hash = new HashSet<Integer>();
		h = new HashSet[n];
		for (int i = 0; i < n; i++)
			h[i] = new HashSet<Integer>();

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			for (int j = 4; j < s.length() - 4; j++) {
				int num = s.charAt(j) - 'a';
				if (!alphabet[num]) {
					hash.add(num);
					h[i].add(num);
				}
			}
		}
		br.close();
		a = new ArrayList<Integer>(hash);
		solve();
		System.out.println(max);
	}

}
