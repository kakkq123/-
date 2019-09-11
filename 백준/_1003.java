import java.util.Scanner;
/*피보나치 함수가 호출될 때 0과 1이 호출되는 개수를 출력
 * n의 숫자가 주어졌을 때 0이 호출되는 개수는 n-1의 0이 호출되는 개수+ n-2의 0이 호출되는 개수이다. (1도 마찬가지)
 * 따라서 dp[n][0]=dp[n-1][0]+dp[n-2][0]가 된다.
 * */
public class _1003 {
	static int[][] dp = new int[41][2];

	public static int fibo_0(int n) {
		if (n == 0)
			return dp[0][0] = 1;
		else if (n == 1)
			return dp[1][0] = 0;
		//중복 계산을 방지
		if (dp[n][0] != 0)
			return dp[n][0];
		return dp[n][0] = fibo_0(n - 1) + fibo_0(n - 2);
	}

	public static int fibo_1(int n) {
		if (n == 0)
			return dp[0][1] = 0;
		else if (n == 1)
			return dp[1][1] = 1;
		//중복 계산을 방지
		if (dp[n][1] != 0)
			return dp[n][1];
		return dp[n][1] = fibo_1(n - 1) + fibo_1(n - 2);
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int t = kb.nextInt(); //test할 개수
		int n[] = new int[t];
		for (int i = 0; i < t; i++) {
			n[i] = kb.nextInt();
			fibo_0(n[i]);
			fibo_1(n[i]);
		}
		// print
		for (int i = 0; i < t; i++)
			System.out.printf("%d %d\n", dp[n[i]][0], dp[n[i]][1]);
	}

}
