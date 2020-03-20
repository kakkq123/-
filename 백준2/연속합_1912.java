import java.io.*;
import java.util.*;

public class 연속합_1912 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] num = new int[n], dp = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			num[i] = Integer.parseInt(st.nextToken());

		int max = dp[0] = num[0];

		for (int i = 1; i < n; i++) {
			// 이전의 계산값에 num[i] 더해줌
			int tmp = dp[i - 1] + num[i];
			// 연속된 값이 num[i]보다 크다면 연속해서 더할 수 있음
			if (tmp > num[i])
				dp[i] = tmp;
			else
				dp[i] = num[i];
			max = Math.max(max, dp[i]);
		}
		System.out.printf("%d", max);
	}

}
