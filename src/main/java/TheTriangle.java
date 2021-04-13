import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class TheTriangle {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static StringTokenizer st;
    static int[][] memo;

    public static void main(String[] args) throws IOException {
        int len = readInt();
        int[][] data = new int[len][];
        memo = new int[len][len];
        for (int i = 0; i < len; i++) {
            int[] temp = new int[i + 1];
            for (int j = 0; j < i + 1; j++) temp[j] = readInt();
            data[i] = temp;
        }
        System.out.println(sum(data, 0, 0));
    }

    static int sum(int[][] data, int level, int idx) {
        if (level == data.length - 1) return data[level][idx];
        if (memo[level][idx] == 0) memo[level][idx] = Math.max(
                sum(data, level + 1, idx) + data[level][idx],
                sum(data, level + 1, idx + 1) + data[level][idx]
        );
        return memo[level][idx];
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static int readInt() throws IOException {
        return parseInt(next());
    }
}
