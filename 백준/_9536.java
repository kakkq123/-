import java.io.*;
import java.util.*;

public class _9536 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int TEST = Integer.parseInt(br.readLine());
		for (int test = 0; test < TEST; test++) {
			StringTokenizer sound = new StringTokenizer(br.readLine());
			ArrayList<String> a = new ArrayList<String>();
			while (true) {
				String[] s = br.readLine().split(" ");
				if (s.length == 5) {
					break;
				}
				a.add(s[2]);
			}
			ArrayList<String> res = new ArrayList<String>();
			while (sound.hasMoreTokens()) {
				String tmp = sound.nextToken();
				if (a.contains(tmp))
					continue;
				res.add(tmp);
				System.out.printf("%s ",tmp);
			}
			System.out.println();
		}
	}

}
