/*
ID: xiyan121
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class ride {
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("ride.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter(
                "ride.out")));
        int a = prod(readLine());
        int b = prod(readLine());
        if (a % 47 == b % 47) out.println("GO");
        else out.println("STAY");
        out.close();
    }

    public static int prod(String str) {
        int res = 1;
        for (char ch : str.toCharArray()) res *= ch - 'A' + 1;
        return res;
    }

    static BufferedReader br;
    static PrintWriter out;
    static StringTokenizer st;

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