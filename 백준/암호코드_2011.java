import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 암호코드_2011 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		br.close();
		int[] dp = new int[str.length() + 1];
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		if (str.charAt(0) == '0')
			bw.write(0 + "\n");
		else {
			dp[0] = dp[1] = 1;
			for (int i = 2; i <= str.length(); i++) {
				int a = str.charAt(i - 2) - '0', b = str.charAt(i - 1) - '0', num = a * 10 + b;
				// 한자리 수 가능?
				if (b > 0)
					dp[i] = dp[i - 1];
				// 두자리수 가능
				if (num >= 10 && num <= 26)
					dp[i] = (dp[i] + dp[i - 2]) % 1000000;

			}
			bw.write(dp[str.length()] + "\n");
		}
		bw.flush();
		bw.close();
	}

}
