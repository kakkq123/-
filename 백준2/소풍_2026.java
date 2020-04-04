import java.io.*;
import java.util.*;

public class 소풍_2026 {
	static int N, K, F;
	static boolean[][] friends = new boolean[901][901]; //친구의 관계
	static int[] friends_number = new int[901]; // 친구의 수
	static ArrayList<Integer> answer;
	static boolean flag = false;

	public static void dfs(int student, int number) {
		//친구 K명 완성!
		if (number == K) {
			flag = true;
			return;
		}
		// 친구가 K이하이면 소풍 못감
		if (friends_number[student] < K)
			return;
		for (int i = student + 1; i <= N; i++) {
			if (friends[student][i]) {
				//이전 친구들과 i가 친구인지 확인
				boolean check = false;
				for (int j = 0; j <= number - 1; j++) {
					if (!friends[i][answer.get(j)]) {
						check = true;
						break;
					}
				}
				if (check)
					continue;
				answer.add(i);
				dfs(i, number + 1);
				if (flag)
					return;
				answer.remove(number + 1);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken()) - 1; // 나를 제외한 친구들의 개수
		N = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());
		for (int i = 0; i < F; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			friends[s][e] = friends[e][s] = true;
			friends_number[s]++;
			friends_number[e]++;
		}
		br.close();
		for (int i = 1; i <= N; i++) {
			if (friends_number[i] >= K) {
				answer = new ArrayList<Integer>();
				answer.add(i);
				dfs(i, 0);
			}
			if (flag)
				break;
		}
		if (flag) {
			for (int student : answer) {
				bw.write(student + "\n");
			}
		} else
			bw.write(-1 + "\n");
		bw.close();
	}

}
