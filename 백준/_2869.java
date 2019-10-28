import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2869 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		double answer=Math.floor((double)(v-a)/(a-b));
		
		answer= (double)(v-a)%(a-b)==0? answer+1 : answer+2;
		
		System.out.println(Math.round(answer));
		
		br.close();
	}

}
