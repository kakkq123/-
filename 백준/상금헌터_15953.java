import java.util.*;
import java.io.*;

public class Main {
	static public void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int test = 0; test < t; test++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int p = 0;
			p += funcA(a);
			p += funcB(b);
			bw.write(p + "\n");
		}
		br.close();
		bw.close();

	}

	private static int funcA(int a) {
		if (a == 0 || a > 21)
			return 0;
		if (a == 1)
			return 5000000;
		if (a <= 3)
			return 3000000;
		if (a <= 6)
			return 2000000;
		if (a <= 10)
			return 500000;
		if (a <= 15)
			return 300000;

		return 100000;
	}

	private static int funcB(int b) {
		if (b == 0 || b > 31)
			return 0;
		if (b == 1)
			return 5120000;
		if (b <= 3)
			return 2560000;
		if (b <= 7)
			return 1280000;
		if (b <= 15)
			return 640000;
		return 320000;
	}

}
