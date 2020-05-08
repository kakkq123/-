import java.util.Deque;
import java.util.ArrayDeque;
class Solution {
    public int find(int[][] board, int col){
        for(int r=0; r < board.length; r++){
            if(board[r][col] > 0){
                int t =  board[r][col];
                board[r][col] = 0;
                return t;
            }
        }
        return 0;
    }
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Deque<Integer> d = new ArrayDeque<Integer>();
        for(int i = 0; i < moves.length; i++){
            int doll = find(board, moves[i] - 1);
            if(doll == 0)
                continue;
            if(d.isEmpty())
                d.addLast(doll);
            else{
                if(d.peekLast() == doll){
                    answer += 2;
                    d.pollLast();
                }else
                    d.addLast(doll); 
            }
        }
        return answer;
    }
}
