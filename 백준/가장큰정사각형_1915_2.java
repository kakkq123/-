import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장큰정사각형_1915_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(s.nextToken());
		int m = Integer.parseInt(s.nextToken());
		int[][] dp = new int[n + 1][m + 1];
		int k = 0; // 사각형 한 변의 최대 길이
    /*
    * String[]으로 숫자 하나씩 받아서 Integer로 변환하는 것보다
    * String으로 받아 charAt으로 문자열 하나씩 자르고
    * st.charAt(j) - '0'을 통해 바로 Integer로 변환하는 것이 메모리 사용량도 적고 속도도 빠르다!
    */
		for (int i = 1; i <= n; i++) {
			String st = br.readLine();
			for (int j = 0; j < m; j++) {
				dp[i][j + 1] = st.charAt(j) - '0';
			}
		}
    
    //왼쪽 대각선, 왼쪽, 위의 'dp 최솟값 + 1'을 해당 dp에 저장!
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (dp[i][j] == 0)
					continue;
				dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
				if (dp[i][j] > k)
					k = dp[i][j];
			}
		}
    
    //정사각형 넓이 출력
		System.out.println(k * k);
		br.close();

	}

}
