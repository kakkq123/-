import java.io.*;
import java.util.*;

public class 단어정렬_1181 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < n; i++)
			set.add(br.readLine());
		br.close();
		String[] list = new String[set.size()];
		set.toArray(list);
		Arrays.sort(list);
		Arrays.sort(list, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return Integer.compare(s1.length(), s2.length());
			}
		});
		// print
		for (String s : list)
			bw.write(s + "\n");
		bw.close();

	}

}
