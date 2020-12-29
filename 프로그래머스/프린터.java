import java.util.*;

class Solution {
    static class Print implements Comparable<Print>{
        int s, n;
        public Print(int s , int n){
            this.s=s;
            this.n=n;
        }
        public int compareTo(Print print){
            if(print.n == this.n)
                return this.s - print.s;
            return this.n < print.n? 1:-1;
        }
    }
    public int solution(int[] priorities, int location) {
        int answer = 0, num = 0;
        PriorityQueue<Print> q = new PriorityQueue<Print>();
        for(int i = 0; i < priorities.length; i++)
            q.add(new Print(i,priorities[i]));
        
        while(true){
            num++;
            int s = q.peek().s, n = q.peek().n;
            q.poll();
            if(s == location){
                answer = num;
                break;
            }
        }
        return answer;
    }
}
