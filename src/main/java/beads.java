import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

/*
ID: xiyan121
LANG: JAVA
TASK: beads
*/

// TODO: Not finished
public class beads {
    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("beads.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter(
                "beads.out")));
        int count = readInt();
        char[] beadsCh = readLine().toCharArray();
        char[] beads = new char[count << 1];
        int i = 0;
        for (; i < count; ++i) beads[i] = beadsCh[i];
        for (; i < count * 2; ++i) beads[i] = beadsCh[i - count];
        int max = 0, maxIdx = 0;
        for (int idx = 0; idx < count * 2 - 1; idx++) {
            int first = 0, second = 0;
            while (idx < count * 2 - 1 && (beads[idx] == beads[idx + 1] || beads[idx] == 'w' || beads[idx + 1] == 'w')) { first++; idx++; }
            while (idx < count * 2 - 1 && (beads[idx] == 'w' || beads[idx] == beads[idx++ + 1] || beads[idx] == 'w')) second++;
            max = Math.max(max, first + second);
            if (max == first + second) System.out.println(idx);
        }
        out.println(max);
        out.close();
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
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
}
