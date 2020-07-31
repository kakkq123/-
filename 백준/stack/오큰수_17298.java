import java.util.*;
import java.io.*;

public class Main {
	static int[][] board = new int[20][20];
	static int[] dr = { -1, 0, 1, 1 }, dc = { 1, 1, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[] v = new int[n], ans = new int[n];

		Stack<Integer> stack = new Stack<Integer>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			v[i] = Integer.parseInt(st.nextToken());
			ans[i] = -1;
		}

		stack.add(v[n - 1]);

		for (int i = n - 2; i >= 0; i--) {
			while (!stack.isEmpty()) {
				if (v[i] < stack.peek()) {
					ans[i] = stack.peek();
					break;
				}
				stack.pop();
			}
			stack.add(v[i]);
		}

		for (int i = 0; i < n; i++) {
			bw.write(ans[i] + " ");
		}

		br.close();
		bw.close();
	}

}
