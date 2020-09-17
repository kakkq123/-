import java.util.*;
import java.io.*;

public class Main {
   static public void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st;
      int[][] arr = new int[n][2];
      for (int i = 0; i < n; i++) {
         st = new StringTokenizer(br.readLine());
         int x = Integer.parseInt(st.nextToken());
         int y = Integer.parseInt(st.nextToken());
         if (x < y) {
            arr[i][0] = x;
            arr[i][1] = y;
         } else {
            arr[i][0] = y;
            arr[i][1] = x;
         }
      }
      //arr[i][1] 오름차순으로, arr[i][0] 오름차순으로 정렬
      Arrays.sort(arr, new Comparator<int[]>() {
         @Override
         public int compare(int[] o1, int[] o2) {
            if (o1[1] == o2[1])
               return o1[0] - o2[0];
            return o1[1] - o2[1];
         }
      });
      
      int len = Integer.parseInt(br.readLine()),answer = 0;
      PriorityQueue<Integer> q = new PriorityQueue<Integer>(); // 시작점 오름차순으로 저장해놓음
      for (int i = 0; i < n; i++) {
         //직장과 집의 거리가 len이하면 시작점을 q에 넣어줌 
         if (arr[i][1] - arr[i][0] <= len)
            q.add(arr[i][0]);
         //현재 arr[i][1] - len보다 작은 값이 있다면 q에서 삭제함
         while (!q.isEmpty() && q.peek() < arr[i][1] - len)
            q.poll();
         //현재 q의 사이즈의 값과 비교하여 answer의 최댓값을 갱신해줌
         answer = Math.max(answer, q.size());
      }
      br.close();
      bw.write(answer + "\n");
      bw.close();

   }
}
