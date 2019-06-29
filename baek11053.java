import java.util.Scanner;

public class baek11053 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] a = new int[n];
		int[] dp = new int[n];
		int i, j, max = 1;

		for (i = 0; i < n; i++) {
			a[i] = kb.nextInt();
			dp[i] = 1;
		}

		for (i = 0; i < n; i++) {
			for (j = 0; j <i; j++) {
				if (a[j] < a[i] && dp[j]+1>dp[i]) {
					dp[i]=dp[j]+1;
				}
			}
			if (dp[i] > max)
				max = dp[i];
		}

		System.out.printf("%d", max);
	}

}
