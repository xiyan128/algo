import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

public class AutomaticPoetry {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int len = readInt();
        for (int i = 0; i < len; i++) {
            String l1 = readLine();
            String l2 = readLine();
            String[] c1 = getC1(l1);
            System.out.println(c1[0]);
            System.out.println(l2.substring(0, l2.length() - 3) + c1[1]);
        }
    }

    static String[] getC1(String str) {
        String[] res = new String[2];
        char[] charr = str.toCharArray();
        int[] marks = new int[4];
        StringBuilder sb = new StringBuilder(), sb2 = new StringBuilder();
        int idx = 0;
        for (int i = 0; i < charr.length; i++) {
            if (charr[i] == '<' || charr[i] == '>') marks[idx++] = i;
            else sb.append(charr[i]);
        }
        res[0] = sb.toString();
        for (int i = marks[2] + 1; i < marks[3]; i++) sb2.append(charr[i]);
        for (int i = marks[1] + 1; i < marks[2]; i++) sb2.append(charr[i]);
        for (int i = marks[0] + 1; i < marks[1]; i++) sb2.append(charr[i]);
        for (int i = marks[3] + 1; i < charr.length; i++) sb2.append(charr[i]);
        res[1] = sb2.toString();
        return res;
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
