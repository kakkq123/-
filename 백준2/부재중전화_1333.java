import java.util.*;
import java.io.*;

public class 부재중전화_1333 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();

		int N = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken()),
				D = Integer.parseInt(st.nextToken());

		int time = L, d = D;
		for (int i = 1; i < N; i++) {
			// 음악이 끝난 시점(time)보다 d가 작다면 d >= time이 될 때까지 + D해줌
			while (d < time) {
				d += D;
			}
			// d가 노래 사이의 5초 간에 존재한다면 break
			if (time <= d && d < time + 5)
				break;
			// 조용한 구간 5초와 노래 길이 L을 더해줌
			time += 5 + L;
		}
		// 마지막 노래까지 끝났지만 d가 time보다 작다면 커질 때까지 + D
		while (d < time) {
			d += D;
		}
		System.out.println(d);

	}

}
