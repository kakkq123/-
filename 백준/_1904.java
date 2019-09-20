import java.util.Scanner;
public class _1904 {
	static int[] dp=new int[1000001];
	public static int tile(int n) {
		if(n==1)
			return dp[1]=1;
		if(n==2)
			return dp[2]=2;
		if(dp[n]!=0)
			return dp[n]%15746;
		return dp[n]=(tile(n-1)+tile(n-2))%15746;
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		System.out.println(tile(n));
	}

}
