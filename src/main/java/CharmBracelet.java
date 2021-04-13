import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class CharmBracelet {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int N = readInt(), M = readInt();
        int[][] data = new int[N][2];
        for (int i = 0; i < N; i++) {
            data[i][0] = readInt();
            data[i][1] = readInt();

        }
        int[] dp = new int[M + 1];
        for (int i = 0; i < N; i++)
            for (int j = M; j >= data[i][0]; j--)
                dp[j] = Math.max(dp[j], dp[j - data[i][0]] + data[i][1]);
        System.out.println(dp[M]);
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
