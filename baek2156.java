import java.util.Scanner;

public class baek2156 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] glass = new int[n];
		int[] dp = new int[n];
		int max_sum = 0;

		for (int i = 0; i < n; i++)
			glass[i] = kb.nextInt();

		dp[0] = glass[0];
		dp[1] = glass[0] + glass[1];
		dp[2]=Math.max(glass[0]+glass[2], glass[1]+glass[2]);
		for (int i = 3; i < n; i++) {
			dp[i] = Math.max(dp[i-3]+glass[i - 1] + glass[i], dp[i - 2] + glass[i]);
			if (max_sum < dp[i]) 
				max_sum = dp[i];
		}
		System.out.println(max_sum);

	}

}
