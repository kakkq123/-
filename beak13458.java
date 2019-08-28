import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class beak13458 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine()); // 시험장 개수
		long[] a = new long[n + 1];
		st = new StringTokenizer(br.readLine());
		// 시험장에 있는 응시자의 수
		for (int i = 0; i < n; i++)
			a[i] = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		// 총감독관이 한 방에서 감시할 수 있는 응시자 수
		long b = Long.parseLong(st.nextToken());
		// 부감독관이 한 방에서 감시할 수 있는 응시자의 수
		long c = Long.parseLong(st.nextToken());

		long cnt = 0;
		for (int i = 0; i < n; i++) {
			long rest = a[i] - b;
			if(rest<0) {
				cnt++;
				continue;
			}
			cnt++;
			cnt += (rest % c == 0 ? rest / c : rest / c + 1);
		}

		System.out.println(cnt);
		br.close();
	}

}
