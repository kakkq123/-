import java.io.*;
import java.util.*;

public class 감소하는수_1038 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		br.close();
		if (N < 10)
			System.out.println(N);
		else if (N >= 1023)
			System.out.println(-1);
		else if (N == 1022) {
			System.out.println("9876543210");
		} else {
			N += 1; // 0번 째를 고려하면 + 1 해줘야함
			Queue<Integer> q = new LinkedList<Integer>();
			for (int i = 0; i <= 9; i++) {
				q.add(i);
				N--;
			}
			while (N > 0) {
				int res = q.poll(), r = res % 10;
				for (int num = 0; num < r; num++) {
					q.add(res * 10 + num);
					N--;
					if (N == 0) {
						System.out.println(res * 10 + num);
						break;
					}
				}
			}
		}
	}
}
