import java.io.*;
import java.util.StringTokenizer;

public class 가단조와다장조_5211 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int c = 0, a = 0, k = 0;
		StringTokenizer st = new StringTokenizer(br.readLine(), "|");
		while (st.hasMoreTokens()) {
			String s = st.nextToken();
			char last = s.charAt(s.length() - 1);
			if (last == 'C' || last == 'F' || last == 'G')
				k = 1;
			if (last == 'A' || last == 'D' || last == 'E')
				k = 0;

			char tmp = s.charAt(0);
			if (tmp == 'C' || tmp == 'F' || tmp == 'G')
				c++;
			if (tmp == 'A' || tmp == 'D' || tmp == 'E')
				a++;
		}

		if (c > a)
			bw.write("C-major\n");
		else if (c < a)
			bw.write("A-minor\n");
		else {
			if (k == 1)
				bw.write("C-major\n");
			else
				bw.write("A-minor\n");
		}

		br.close();
		bw.close();
	}

}
