import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken()), b = Long.parseLong(st.nextToken());
		
		if (b < a) {
			long tmp = b;
			b= a;
			a = tmp;
		}
		
		while (a != 0) {
			long r = b % a;
			b = a;
			a = r;
		}
		StringBuilder sb = new StringBuilder();
		long i = 0;
		while (i < b) {
			sb.append(1);
			i++;
		}
		bw.write(sb.toString() + "\n");
		br.close();
		bw.close();
	}

}
