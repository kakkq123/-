import java.io.*;
import java.util.*;

public class 손익분기점_1712 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		if (C <= B)
			bw.write(-1 + "\n");
		else
			bw.write((A / (C - B) + 1) + "\n");
		bw.close();
	}

}
