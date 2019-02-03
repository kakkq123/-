import java.util.Scanner;

public class 백준2108 {
	public static void main(String[] args) {
		int N, median, mode, range, num, sum=0;
		int i,j,min,temp,frequency,frequencyMax, frequencyValue;
		int[] array;
		float  arithMean;
		Scanner kb = new Scanner(System.in);

		do {
			N = kb.nextInt();
		} while (N < 1 || N > 500000);

		array = new int[N];
		
		for (i = 0; i < N; i++) {
			num = kb.nextInt();
			if (Math.abs(num) > 4000) {
				System.out.println("4000이하의 값을 넣어주세요");
				continue;
			}
			array[i]=num;
			sum+= array[i];
		}

		//오름차순으로 정렬
		for (i = 0; i < N - 1; i++) {
			min = i;
			for (j = i + 1; j < N; j++)
				if (array[j] < array[min])
					min = j;

			temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
		//산술평균
		arithMean=(float)sum/N;
		System.out.printf("\n산술평균 : %.2f", arithMean);
		
		/*중앙값
		통계학에 있어서 N의 값이 홀수이면 (N+1)/2번째 값이 중앙값이 되며
		N의 값이 짝수이면 N/2 그리고 N/2+1번째 값의 평균이 중앙값이 된다
		배열 인덱스는 0~ N-1이므로 
		각각 (N+1)/2, N/2, N/2+1 은 배열 인덱스에선 N/2,(N-1)/2,(N-1)/2+1 이다.		 
		*/
		if(N%2==1) 
			median=array[(N)/2];
		else 
			median=(array[(N-1)/2]+array[(N-1)/2+1])/2;
		
		System.out.printf("\n중앙값 : %d", median);
		
		//최빈값
		frequency=1;
		frequencyMax=1;
		frequencyValue=array[0];
		
		for(i=1;i<N;i++) {
			if(array[i-1]==array[i]) {
				frequency++;
				if(frequencyMax < frequency) {
					frequencyMax=frequency;
					frequencyValue=array[i];
				}
			}
			else
				frequency=1;
		}
		
		mode=frequencyValue;
		System.out.printf("\n최빈값: %d", mode);
		
		//범위
		range=array[N-1]-array[0];
		System.out.printf("\n범위 : %d", range);
		
	}

}
