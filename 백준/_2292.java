import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _2292 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt=1;
		n--;
		while(n>0) {
			n-=6*cnt;
			cnt++;
			
		}
		System.out.println(cnt);
		
		
		br.close();
	}

}
