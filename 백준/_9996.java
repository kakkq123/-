import java.io.*;
import java.util.*;

public class _9996 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer pattern = new StringTokenizer(br.readLine(), "*");
		String a = pattern.nextToken();
		String b = pattern.nextToken();
		for (int test = 0; test < n; test++) {
			String s = br.readLine();
			if (s.length() < a.length() + b.length()) {
				bw.write("NE\n");
				continue;
			}
			boolean flag = true;
			for (int i = 0; i < a.length(); i++)
				if (s.charAt(i) != a.charAt(i)) {
					flag = false;
					break;
				}
			if (flag) {
				for (int i = 0; i < b.length(); i++)
					if (s.charAt(s.length() - b.length() + i) != b.charAt(i)) {
						flag = false;
						break;
					}
			}
			if (flag)
				bw.write("DA\n");
			else
				bw.write("NE\n");
		}
		br.close();
		bw.close();
	}

}
