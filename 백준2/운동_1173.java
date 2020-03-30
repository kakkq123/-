import java.io.*;
import java.util.*;

public class 운동_1173 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 운동시간
		int m = Integer.parseInt(st.nextToken()); // 최소 맥박
		int M = Integer.parseInt(st.nextToken()); // 최대 맥박
		int T = Integer.parseInt(st.nextToken()); // 운동 후 맥박
		int R = Integer.parseInt(st.nextToken()); // 휴식 맥박
		br.close();
		int time = 0, cur = m;
		while (N > 0) {
			time++;
			//운동 가능
			if (cur + T <= M) {
				N--;
				cur += T;
				continue;
			} 
			// 휴식 
			else {
				int tmp = cur; // 이전의 값 저장
				//휴식 후 m보다 작아지면 m 유지
				if (cur - R < m)
					cur = m;
				else
					cur -= R;
				//휴식해도 맥박 상태가 변하지 않으면 -> 운동을 끝낼 수 없음 -> break
				if (cur == tmp) {
					time = -1;
					break;
				}
			}
		}
		System.out.println(time);
	}

}
