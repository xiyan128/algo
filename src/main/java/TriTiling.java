import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class TriTiling {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static StringTokenizer st;

    static int[] dp = new int[32];

    public static void main(String[] args) throws IOException {
        int curr = 0;
        dp[0] = 1;
        dp[2] = 3;
        while ((curr = readInt()) != -1) System.out.println(tile(curr));
    }

    static int tile(int i) {
        if (i % 2 != 0) return 0;
        if (dp[i] == 0) dp[i] = 4 * tile(i - 2) - tile(i - 4);
        return dp[i];
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
