import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _16637 {
	static char[] op;
	static int[] num;
	static long max = Long.MIN_VALUE;

	public static long cal(long a, long b, char c) {
		if (c == '+')
			return a + b;
		if (c == '-')
			return a - b;
		return a * b;
	}

	public static void solve(int end, int index, long value) {
		if (index == end) {
			max = Math.max(max, value);
			return;
		}
		if (index == 0) {
			solve(end, index + 1, num[0]);
			solve(end, index + 2, cal(num[0], num[1], op[0]));
		} else {
			long v = 0;
			v = cal(value, num[index], op[index - 1]);
			solve(end, index + 1, v);
			if (index + 2 <= end) {
				v = cal(num[index], num[index + 1], op[index]);
				v = cal(value, v, op[index - 1]);
				solve(end, index + 2, v);
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		op = new char[n / 2];
		num = new int[n / 2 + 1];

		String[] s = br.readLine().split("");
		for (int i = 0; i < n; i++) {
			if (i % 2 == 1)
				op[i / 2] = s[i].charAt(0);
			else
				num[i / 2] = Integer.parseInt(s[i]);
		}
		if (n == 1)
			System.out.println(num[0]);
		else {
			solve(n / 2 + 1, 0, 0);
			System.out.println(max);
		}
		br.close();

	}

}
