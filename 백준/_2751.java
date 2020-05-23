import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N];
		for (int i = 0; i < N; i++)
			a[i] = Integer.parseInt(br.readLine());

		quicksort(a, 0, N-1);
		for (int i : a) {
			bw.write(i + "\n");
		}
		br.close();
		bw.close();
	}

	private static void quicksort(int[] a, int left, int right) {
		if (left >= right)
			return;
		int pivot = partition(a, left, right);
		quicksort(a, left, pivot - 1);
		quicksort(a, pivot + 1, right);

	}

	private static int partition(int[] a, int left, int right) {
		int mid = (left + right) / 2;
		swap(a, left, mid);
		int pivot = left, i = left, j = right;
		while (i < j) {
			while (a[pivot] < a[j])
				j--;
			while (i < j && a[pivot] >= a[i])
				i++;
			swap(a, i, j);
		}
		swap(a, pivot, i);
		return i;
	}

	private static void swap(int[] a, int left, int mid) {
		int tmp = a[left];
		a[left] = a[mid];
		a[mid] = tmp;
	}

}
