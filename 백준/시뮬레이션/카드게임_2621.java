import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] a = new int[4]; // 0 - R은 빨간색, 1 - B는 파란색, 2 - Y는 노란색, 3 - G는 녹색
		int[] f = new int[10];

		StringTokenizer st;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			char c = st.nextToken().charAt(0);
			if (c == 'R')
				a[0]++;
			else if (c == 'B')
				a[1]++;
			else if (c == 'Y')
				a[2]++;
			else
				a[3]++;
			f[Integer.parseInt(st.nextToken())]++;
		}

		int idx = 0, max = 0, con = 0, _3 = 0, _4 = 0;
		int[] _2 = new int[2];
		boolean all_color = false, flag= false;;
		for (int i = 0; i < 4; i++) {
			if (a[i] == 5)
				all_color = true;
		}
		for (int i = 1; i < 10; i++) {
			if (f[i] > 0) {
				max = Math.max(max, i);
				con++;
				if(con == 5)
					flag = true;
				if (f[i] == 2)
					_2[idx++] = i;
				else if (f[i] == 3)
					_3 = i;
				else if (f[i] == 4)
					_4 = i;
			} else {
				con = 0;
			}

		}
		int answer = 0;
		// 모두 같은 색 + 연속적>> 가장 큰 수 + 900
		if (all_color && flag) {
			answer = max + 900;
		}
		// 4개 숫자가 같음 >> 같은 숫자 + 800
		else if (_4 > 0) {
			answer = _4 + 800;
		}
		// 3개 숫자가 같음 && 2장의 숫자가 같음 >>3장같은숫자*10+2장같은숫자+700
		else if (_3 > 0 && _2[0] > 0) {
			answer = _3 * 10 + _2[0] + 700;
		}
		// 5개 카드 색깔 같음 >> 가장 큰 수 + 600
		else if (all_color) {
			answer = max + 600;
		}
		// 숫자 연속적 >>가장 큰 수 + 500
		else if (flag) {
			answer = max + 500;
		}
		// 3장 숫자가 같으면 >> 같은 숫자 + 400
		else if (_3 > 0) {
			answer = _3 + 400;
		}
		// 2개의 숫자가 같고 다른 두장의 숫자가 같으면 >> 가장 큰 숫자에 * 10 + 같은 숫자 작은 것 + 300
		else if (_2[0] > 0 && _2[1] > 0) {
			if (_2[0] > _2[1])
				answer = _2[0] * 10 + _2[1] + 300;
			else
				answer = _2[1] * 10 + _2[0] + 300;
		}
		// 카드 5장 중 2장의 숫자가 같으면 >> 같은 숫자 + 200
		else if (_2[0] > 0) {
			answer = _2[0] + 200;
		}
		// 가장 큰 수에 100을 더한다.
		else {
			answer = max + 100;
		}
		bw.write(answer + "\n");
		br.close();
		bw.close();
	}

}
