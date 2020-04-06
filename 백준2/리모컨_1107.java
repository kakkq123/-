import java.io.*;
import java.util.*;

public class 리모컨_1107{
	static int N, count = 1000000;
	static boolean[] remote = new boolean[10];

	public static void solve(int value) {
		if (value == 0) {
			if (remote[value])
				return;
			count = Math.min(count, N + 1);
			return;
		}
		int cnt = 0, v = value;
		while (v > 0) {
			if (remote[v % 10])
				return;
			cnt++;
			v /= 10;
		}
		count = Math.min(count, Math.abs(N - value) + cnt);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		if (M > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				int number = Integer.parseInt(st.nextToken());
				remote[number] = true;
			}
		}
		br.close();
		if (M == 10) {
			System.out.println(Math.abs(100 - N));
		} else {
			for (int i = 0; i <= 1000000; i++)
				solve(i);
			count = Math.min(Math.abs(100 - N), count);
			System.out.println(count);
		}
	}

}
