/*
ID: xiyan121
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class gift1 {
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader("gift1.in"));
        out = new PrintWriter(new BufferedWriter(new FileWriter(
                "gift1.out")));
        int np = readInt();
        HashMap<String, Integer> map = new HashMap<>();
        String[] names = new String[np];
        for (int i = 0; i < np; i++) names[i] = readLine();
        for (String name : names) map.put(name, 0);
        String curr;
        while ((curr = br.readLine()) != null) {
            int amount = readInt(), num = readInt();
            if (num == 0) continue;
            int residue = amount % num;
            int share = (amount - residue) / num;
            map.computeIfPresent(curr, (key, val) -> val + residue - amount);
            for (int i = 0; i < num; i++) map.computeIfPresent(readLine(), (k, val) -> val + share);
        }
        for (String name : names) out.println(name + " " + map.get(name));
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
