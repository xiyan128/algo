import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class Recycling {

    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int[][] data = new int[100][5];
        int i = 0;
        String line;
        while ((line = readLine()).charAt(0) != '#') {
            if (line.charAt(0) == 'e')
            {
                System.out.println(search(data, i));
                i = 0;
                continue;
            }
            data[i++] = parse(line);
        }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static int search(int[][] data, int len) {
//        System.out.println(Arrays.deepToString(data));
        int minIdx = -1, minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            int diff = 0;
            for (int j = 0; j < len; j++) {
               if (i == j)  continue;
                for (int k = 0; k < 5; k++) if(data[i][k] - data[j][k] != 0) diff++;
            }
//            System.out.println(diff);
            minDiff = Math.min(minDiff, diff);
            if (minDiff == diff) minIdx = i;
        }
        return minIdx + 1;
    }

    static long readLong() throws IOException {
        return parseLong(next());
    }

    static int readInt() throws IOException {
        return parseInt(next());
    }

    static double readDouble() throws IOException {
        return parseDouble(next());
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }

    static int[] parse(String str) {
        String[] strs = str.split(",");
        Arrays.sort(strs);
        int[] res = new int[5];
        int idx = 0;
        for (int i = 0; i < strs.length; i++) {
            char ch = strs[i].charAt(2);
            int t = -1;
            if (ch == 'P')  t = 0;
            else if (ch == 'G') t = 1;
            else if (ch == 'A') t = 2;
            else if (ch == 'S') t = 3;
            else if (ch == 'N') t = 4;
            res[idx++] = t;
        }
        return res;
    }

}
