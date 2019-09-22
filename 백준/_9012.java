import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _9012 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean VPS;
		int cnt;
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			cnt = 0;
			VPS = true;
			String[] s = br.readLine().split("");
			for (int j = 0; j < s.length; j++) {
				if (s[j].equals("("))
					cnt++;
				else if (s[j].equals(")")) {
					if (cnt == 0) {
						VPS = false;
					}
					cnt--;
				}
			} // for j
			if (VPS && cnt == 0)
				System.out.println("YES");
			else
				System.out.println("NO");

		}

	}

}
