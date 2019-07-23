
/*
사람 n명의 몸무게와 키가 주어진다.
a가 k+1 사람들보다 몸무게 적고 키가 작다면 랭킹은 k+1이다.
n명의 사람 모두 비교하고 각각 랭킹을 출력한다.
*/

import java.util.Scanner;

public class baek7568 {
	// 사람의 몸무게, 키, 랭킹
	public static class Person {
		public int weight;
		public int height;
		public int rank = 1;

		public Person(int weight, int height) {
			this.weight = weight;
			this.height = height;
		}

		// 랭킹 증가
		public void increaseRank() {
			rank++;
		}
	}

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt(); // 사람의 수
		int w, h;
		Person[] p = new Person[n]; // 객체 배열 생성

		for (int i = 0; i < n; i++) {
			w = kb.nextInt(); // 몸무게
			h = kb.nextInt(); // 키
			p[i] = new Person(w, h); // 객체 생성
		}

		// 비교
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				// 같은 것끼리 비교하는 건 불필요
				if (i == j)
					continue;

				// p[j]가 p[i]보다 키와 몸무게 값이 크다면 p[i]의 랭킹을 증가시킨다.
				if (p[i].weight < p[j].weight)
					if (p[i].height < p[j].height)
						p[i].increaseRank();
			}
		}
		// 결과값을 출력
		for (int i = 0; i < n; i++)
			System.out.printf("%d ", p[i].rank);

	}

}
