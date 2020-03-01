import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 초콜릿자르기_2163 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(n * m - 1 + "\n");
		bw.flush();
		bw.close();
	}

}
