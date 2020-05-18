import java.io.*;

public class Main {
	static int[] copy = new int[1000000];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N];
		for (int i = 0; i < N; i++)
			a[i] = Integer.parseInt(br.readLine());

		mergesort(a, 0, N - 1);
		for (int i : a) {
			sb.append(i + "\n");
		}
		bw.write(sb + "\n");
		br.close();
		bw.close();
	}

	private static void mergesort(int[] a, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergesort(a, left, mid);
			mergesort(a, mid + 1, right);
			merge(a, left, mid, right);
		}
	}

	private static void merge(int[] a, int left, int mid, int right) {
		int l = left, r = mid + 1, k = left;
		// System.out.println("left : " + left + ", right : " + right);
		while (l <= mid && r <= right) {
			if (a[l] < a[r])
				copy[k++] = a[l++];
			else
				copy[k++] = a[r++];
		}
		while (l <= mid)
			copy[k++] = a[l++];
		while (r <= right)
			copy[k++] = a[r++];
		for (int i = left; i <= right; i++)
			a[i] = copy[i];
	}

}
