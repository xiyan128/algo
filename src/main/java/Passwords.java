import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class Passwords {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = 0, m = 0;
        String temp;
        List<String> dict = new ArrayList<>();
        while ((temp = br.readLine()) != null) {
            System.out.println("--");
            n = parseInt(temp);
            for (int i = 0; i < n; i++) dict.add(next());
            m = readInt();
            for (int i = 0; i < m; i++) printPwd(next(), dict, 0, "");
            dict.clear();
        }
    }

    static void printPwd(String rule, List<String> dict, int idx, String res) {
        if (idx == rule.length()) {
            System.out.println(res);
            return;
        }
        if (rule.charAt(idx) == '0')
            for (int i = 0; i < 10; i++) printPwd(rule, dict, idx + 1, res + i);
        else if (rule.charAt(idx) == '#')
            for (String i : dict) printPwd(rule, dict, idx + 1, res + i);
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
