import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _9461 {
	static long[] dp = new long[101];
	static int n;

	public static long padovan(int a) {
		//중복 방지
		if (dp[a] != 0)
			return dp[a];
		if(a>=1 && a<=3)
			return dp[a]=1;
		else if(a==4 || a==5)
			return dp[a]=2;
		else if(a==6)
			return dp[6]=3;
		else if(a==7)
			return dp[7]=4;
		else if(a==8)
			return dp[8]=5;
		else if(a==9)
			return dp[9]=7;
		else if(a==10)
			return dp[10]=9;
		
		return dp[a] = padovan(a-1) + padovan(a - 5);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());
			padovan(n);
			System.out.println(dp[n]);
		}
		br.close();
	}

}
