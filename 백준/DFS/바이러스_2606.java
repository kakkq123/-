import java.util.*;
import java.io.*;

public class Main {

	static ArrayList<Integer>[] edge;
	static boolean[] visit;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int computer_cnt = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());

		visit = new boolean[computer_cnt + 1];
		edge = new ArrayList[computer_cnt + 1];
		for (int i = 1; i <= computer_cnt; i++)
			edge[i] = new ArrayList<Integer>();

		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			edge[a].add(b);
			edge[b].add(a);
		}
		br.close();

		visit[1] = true;
		dfs(1);
		
		
		bw.write(answer + "\n");
		bw.close();

	}

	private static void dfs(int cur) {
		for(int next : edge[cur]) {
			if(!visit[next]) {
				visit[next] = true;
				answer++;
				dfs(next);				
			}
		}
		
	}

}
