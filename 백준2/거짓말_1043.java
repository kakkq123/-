import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.ArrayList;

/*
 * 과장된 이야기를 할 수 있는 파티 개수의 최댓값은
 * (1)진실을 알고있는 사람들이 참여하지 않고, (2)진실을 알고 있는 사람들과 접촉하지 않은 사람들만 구성된 파티에서  과장된 이야기를 하는 경우이다.
 * */

public class 거짓말_1043 {
	static boolean[] list;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());
		
		//진실을 알고 있는 사람
		st = new StringTokenizer(br.readLine());
		int tnum = Integer.parseInt(st.nextToken());
		ArrayList<Integer> truth = new ArrayList<Integer>();
		for (int i = 0; i < tnum; i++)
			truth.add(Integer.parseInt(st.nextToken()));
		
		//중복을 방지하기 위해 TreeSet을 사용
		TreeSet<Integer>[] set = new TreeSet[n + 1];
		for (int i = 1; i <= n; i++)
			set[i] = new TreeSet<Integer>();

		//party의 정보를 저장함
		ArrayList<Integer>[] party = new ArrayList[p];
		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			party[i] = new ArrayList<Integer>();
			for (int j = 0; j < x; j++)
				party[i].add(Integer.parseInt(st.nextToken()));
			for (int j = 0; j < x - 1; j++)
				for (int k = j + 1; j < x; j++) {
					set[party[i].get(j)].add(party[i].get(k));
					set[party[i].get(k)].add(party[i].get(j));
				}
		}
		br.close();
		
		//진실을 알고있는 사람과 접촉한 사람들을 구함
		//접촉한 사람들은 true로 표시
		list = new boolean[n + 1];
		for (int t : truth) {
			list[t] = true;
			find(t, set);
		}
		//진실을 모르는 사람들만 구성된 파티가 존재한다면 cnt + 1을 해준다.
		int cnt = 0;
		for (int i = 0; i < p; i++) {
			boolean flag = true;
			for (int j : party[i]) {
				if (list[j]) {
					flag = false;
					break;
				}
			}
			if (flag)
				cnt++;
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
	}

	//진실을 알고있는 사람과 접촉한 사람 찾는다
	public static void find(int index, TreeSet<Integer>[] set) {
		for (int next : set[index]) {
			if (list[next])
				continue;
			list[next] = true;
			find(next, set);
		}
	}

}
