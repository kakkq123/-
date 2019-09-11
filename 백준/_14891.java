import java.util.*;

public class _14891 {

	// 반시계방향 회전
	static public void left_rotate(int[] arr) {
		int temp = arr[0];
		for (int i = 0; i < 7; i++)
			arr[i] = arr[i + 1];
		arr[7] = temp;

	}

	// 시계방향 회전
	static public void right_rotate(int[] arr) {
		int temp = arr[7];
		for (int i = 7; i > 0; i--)
			arr[i] = arr[i - 1];
		arr[0] = temp;

	}

	public static void main(String[] args) {
		String str;
		int[][] saw = new int[4][8]; // 4개의 톱니바퀴
		int[] direction = new int[4]; // 각 톱니바퀴의 방향을 저장 1:시계방향, -1:반시계방향
		int number, k, i = 0, score = 0, l, r, n;

		Scanner kb = new Scanner(System.in);

		for (i = 0; i < 4; i++) {
			str = kb.nextLine();

			String[] strArray = str.split("");

			for (int j = 0; j < 8; j++)
				saw[i][j] = Integer.parseInt(strArray[j]);
		}

		// 몇 번 회전할지 k를 입력받는다
		k = kb.nextInt();

		// k번 회전함
		for (i = 0; i < k; i++) {
			number = kb.nextInt(); // 톱니바퀴 번호를 입력받음
			direction[number - 1] = kb.nextInt(); // 회전 방향을 입력받는다.

			r = 4 - number; // 오른쪽 톱니바퀴 검사해야 하는 개수 : number=3일 경우 오른쪽으로 1번 검사해야함
			l = number - 1; // 왼쪽 톱니바퀴 검사해야 하는 개수 : number=3일 경우 왼쪽으로 2번 검사해야함

			// 왼쪽 톱니바퀴들 검사
			n = 0;
			while (n < l) {
				if (saw[number - 1 - n][6] != saw[number - 2 - n][2])
					direction[number - 2 - n] = -direction[number - 1 - n];
				n++;
			}

			// 오른쪽 톱니바퀴를 검사
			n = 0;
			while (n < r) {
				if (saw[number - 1 + n][2] != saw[number + n][6])
					direction[number + n] = -direction[number - 1 + n];

				n++;
			}

			// 방향에 맞게 회전
			for (int j = 0; j < 4; j++) {
				if (direction[j] == 1)
					right_rotate(saw[j]);
				else if (direction[j] == -1)
					left_rotate(saw[j]);

			}

			// direction 초기화
			for (int j = 0; j < 4; j++)
				direction[j] = 0;

		}

		// 계산
		if (saw[0][0] == 1)
			score += 1;
		if (saw[1][0] == 1)
			score += 2;
		if (saw[2][0] == 1)
			score += 4;
		if (saw[3][0] == 1)
			score += 8;

		System.out.printf("%d", score);

	}

}
