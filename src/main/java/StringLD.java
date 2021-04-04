import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class StringLD {

    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int len = 0;
        while ((len = readInt()) != 0) {
            List<String> list = new ArrayList<String>();
            for (int i = 0; i < len; i++) list.add(readLine());
            System.out.println(getSteps(list));
        }


    }

    static int getSteps(List<String> list) {
        int i = 0;
        while (true) {
            HashSet<String> set = new HashSet<String>();
            for (String s : list) {
                if (i >= s.length() - 1) return i;
                if (set.contains(s.substring(i))) return i - 1;
                set.add(s.substring(i));
            }
            i++;
        }
    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static int readInt() throws IOException {
        return parseInt(next());
    }

    static String readLine() throws IOException {
        return br.readLine().trim();
    }

}