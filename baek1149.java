import java.util.Scanner;

public class baek1149 {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[][] rgb = new int[n][3];
		int[][] dp = new int[n][n];
		
		for (int i = 0; i < n; i++) 
			for (int j = 0; j < 3; j++)
			rgb[i][j] = kb.nextInt();
		
		for (int i = 0; i <n; i++) {
			for (int j = 0; j < 3; j++) {
				//첫번째 집이면 dp에 각 rgb값을 저장한다.
				if (i == 0)
					dp[i][j] = rgb[i][j];
				else {
					/*만약 j=a이면 옆집은 a가 아닌 색으로 페인팅이 되어있어야한다. 
					 * dp[i][0]=rgb[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
					 * dp[i][1]=rgb[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
					 * dp[i][2]=rgb[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
					 * */
					if (j == 0)
						dp[i][j] = rgb[i][j] + Math.min(dp[i - 1][1], dp[i - 1][2]);
					else if (j == 1)
						dp[i][j] = rgb[i][j] + Math.min(dp[i - 1][0], dp[i - 1][2]);
					else
						dp[i][j] = rgb[i][j] + Math.min(dp[i - 1][0], dp[i - 1][1]);
				}

			} // j
		} // i

		//마지막 dp값 중에 최솟값을 출력한다.
		System.out.println(Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2])));
	}

}
