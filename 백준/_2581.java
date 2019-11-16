import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2581 {
	/*
	 * m이상 n이하 소수들의 합과 소수 최솟값 출력하기
	 * */
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int min = 10001, sum = 0;
		for (int i = n; i >= m; i--) {
			if(i==1)
				continue;
			boolean check = true;
			// check
			for (int j = 2; j <= i / 2; j++) {
				if (i % j == 0) {
					check = false;
					break;
				}
			}
			if (check) {
				sum += i;
				if (min > i)
					min = i;
			}
		}
		if (min==10001)
			System.out.println("-1");
		else
			System.out.println(sum + "\n" + min);
		br.close();
	}

}
