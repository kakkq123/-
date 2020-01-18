class Solution {
	public long gcd(long a, long b) {
		long t;
		if (a < b) {
			t = a;
			a = b;
			b = t;
		}
		while (b != 0) {
			t = a % b;
			a = b;
			b = t;
		}
		return a;
	}

	public long solution(int w, int h) {
		long g = gcd(w, h);
		return (long) w * h - g * (w / g + h / g - 1);
	}
}
