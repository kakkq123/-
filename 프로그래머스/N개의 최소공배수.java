class Solution {
    public int getGcd(int p, int q){
        if(p < q){
            int tmp = q;
            q = p;
            p = tmp;
        }
        int r = 0;
        while(q > 0){
            r = p % q;
            p = q;
            q = r;
        }
        return p;
    }
    public int solution(int[] arr) {
        int len = arr.length;
        if(len == 1)
            return arr[0];
        int p = arr[0], gcd = arr[0], lcm = arr[0];
        for(int i = 1; i < len; i++){
            gcd = getGcd(p, arr[i]);
            lcm = p * arr[i] / gcd;
            p = lcm;
        }
        return lcm;
    }
}
