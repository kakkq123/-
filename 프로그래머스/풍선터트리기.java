class Solution {
    public int solution(int[] a) {
        int[] left = new int[a.length], right = new int[a.length];
        //왼쪽에 있는 값중에 최솟값을 저장
        left[0] = 1000000001;
        for(int i = 1; i < a.length; i++)
            left[i] = Math.min(left[i - 1], a[i - 1]);
        //오른쪽에 있는 값중에 최솟값을 저장
        right[a.length - 1] = 1000000001;
        for(int i = a.length - 2; i >= 0; i--)
            right[i] = Math.min(right[i + 1], a[i + 1]); 
        
        //최소한 왼오 중 하나의 최댓값보다 작다면 풍선 터트릴 수 있음
        int answer = 0;
        for(int i = 0; i < a.length; i++){
            int max = Math.max(left[i], right[i]);
            if(max > a[i])
                answer++;
        }
        return answer;
    }
}
