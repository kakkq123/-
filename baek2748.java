import java.util.Scanner;
public class baek2748 {
	//n이 어느정도 커지면 피보나치 숫자도 커지기 때문에 8B크기를 갖는 long type으로 해줘야 숫자가 안 짤린다
	static long[] dp=new long[10000];
	
	public static long fibo(int n) {
		if(n==0)
			return dp[0]=0;
		if(n==1)
			return dp[1]=1;
		if(dp[n]!=0)
			return dp[n];
		return dp[n]=fibo(n-2)+fibo(n-1);
	}
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		System.out.println(fibo(n));
	}

}
