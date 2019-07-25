import java.util.*;

public class baek1463{
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int[] dp =new int[10000];
		
		dp[0]=0;
		dp[1]=0;
		
		for(int i=2; i<=n; i++) {
			dp[i]=dp[i-1]+1;
			if(i%2==0)
				dp[i]=Math.min(dp[i],dp[i/2]+1);
			else if(i%3==0)
				dp[i]=Math.min(dp[i],dp[i/3]+1);
		}
		System.out.printf("%d",dp[n]);

	}

}
