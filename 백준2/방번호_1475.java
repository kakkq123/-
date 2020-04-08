import java.io.*;

public class 방번호_1475 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int[] number = new int[10];
		for (int i = 0; i < s.length(); i++)
			number[s.charAt(i) - '0']++;
		int a = 0;
		if ((number[6] + number[9]) % 2 == 0)
			a = (number[6] + number[9]) / 2;
		else
			a = (number[6] + number[9]) / 2 + 1;
		int max = a;
		for (int i = 0; i < 10; i++) {
			if (i == 6 || i == 9)
				continue;
			max = Math.max(max, number[i]);
		}
		System.out.println(max);
	}

}
