import java.util.*;

public class road {

	public static void main(String[] args) {
		String s;
		int[][] road = new int[5][5];
		Scanner kb = new Scanner(System.in);

		for (int i = 0; i < 5; i++) {
			s = kb.nextLine();
			String[] str = s.split("");
			for (int j = 0; j < str.length; j++)
				road[i][j] = Integer.parseInt(str[j]);
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.printf("%d", road[i][j]);

			}
			System.out.println();
		}

		int i = 1;
		while (i < 5) {
			for (int j = 1; j < 5; j++){
				if(road[i][j]==0)
					continue;
				road[i][j] = road[i][j - 1] + road[i - 1][j];
				
			}
			i++;

		}

		System.out.println("");
		System.out.printf("총 가지수 : %d", road[4][4]);

	}

}
