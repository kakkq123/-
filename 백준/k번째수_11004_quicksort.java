import java.io.*;
import java.util.*;

public class k번째수_11004_quicksort {

	public static void swap(int[] a, int x, int y) {
		int t = a[x];
		a[x] = a[y];
		a[y] = t;
	}

	public static int partition(int[] a, int low, int high) {
		int mid = (low + high) / 2;
		swap(a, low, mid);
		int pivot = low, left = low, right = high;
		while (left < right) {
			while (a[pivot] < a[right])
				right--;
			while (left < right && a[pivot] >= a[left])
				left++;
			swap(a, left, right);
		}
		swap(a, left, pivot);
		return left;
	}

	public static void quick_sort(int[] a, int k, int low, int high) {
		if (low < high) {
			int pivot = partition(a, low, high);
			if (pivot + 1 == k)
				return;
			if (pivot + 1 < k)
				quick_sort(a, k, pivot + 1, high);
			else
				quick_sort(a, k, low, pivot - 1);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] a = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			a[i] = Integer.parseInt(st.nextToken());
		br.close();
		quick_sort(a, K, 0, N - 1);
		for (int i = 0; i < N; i++)
			System.out.printf("%d ", a[i]);

		System.out.println();
		System.out.println(a[K - 1]);
	}

}
