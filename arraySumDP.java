import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] num = new int[n];
		int[] dp = new int[n];

		// 입력
		for (int i = 0; i < n; i++)
			num[i] = kb.nextInt();

		int max=dp[0] = num[0];

		for (int i = 1; i < n; ++i) {
			if (num[i] < 0 && (dp[i - 1] + num[i] < 0))
				dp[i] = 0;
			else
				dp[i] = dp[i - 1] + num[i];

			if(max<dp[i])
				max=dp[i];
		}

		//출력
		System.out.printf("%d", max);

	}

}
