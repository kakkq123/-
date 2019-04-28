/*
 * x가 3으로 나누어 떨어지면 3으로 나눔
 * x가 2로 나누어 떨어지면 2로 나눔
 * 1을 뺀다
 */

import java.util.*;

public class dp1463 {

	public static int min(int a, int b) {
		if (a > b)
			return b;
		return a;

	}
	
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] dp =new int[10000];
		
		dp[0]=0;
		dp[1]=0;
		
		for(int i=2; i<=n; i++) {
			dp[i]=dp[i-1];
			if(i%2==0)
				dp[i]=min(dp[i]+1,dp[i/2]+1);
			else if(i%3==0)
				dp[i]=min(dp[i]+1,dp[i/3]+1);
		}
		System.out.printf("%d",dp[n]);

	}

}
