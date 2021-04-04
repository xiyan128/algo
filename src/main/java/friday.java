/*
ID: xiyan121
LANG: JAVA
TASK: friday
*/
import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;


public class friday {
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("friday.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter(
                "friday.out")));
        int dayCount = 1;
        int[] stat = new int[7];
        int years = readInt() + 1900;
        for (int year = 1900; year < years; year++) {
            int feb = 28;
            if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) feb = 29;
            if (feb == 29) System.out.println(year);
            //                          1   2    3   4   5   6   7   8   9   10  11  12
            for (int month : new int[]{ 31, feb, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}) {
               for (int day = 1; day <= month; day++) {
                   dayCount++;
                   if (day == 13) stat[dayCount % 7]++;
               }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : stat) sb.append(i).append(" ");
        out.println(sb.substring(0, sb.length() - 1));
        out.close();
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
