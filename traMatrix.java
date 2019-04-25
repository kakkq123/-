import java.util.*;

//전치행렬

public class traMatrix {


	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("행의 크기를 입력하세요: ");
		int row = kb.nextInt();
		System.out.println("열의 크기를 입력하세요: ");
		int col = kb.nextInt();
		int temp;
		int[][] a = new int[row][col];
		int[][] at = new int[row][col];

		// 입력
		System.out.println("차례대로 원소값을 입력하세요");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				a[i][j] = kb.nextInt();
			}
		}
		System.out.println("\n*************결과*************\n");
		// 전치행렬 출력~
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				at[i][j] = a[j][i];
				System.out.printf("%d ", at[i][j]);
			}
			System.out.println();
		}

	}

}
