import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.System.in;

public class SurprisingStrings {

    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        String line;
        List<String> lines = new ArrayList<String>();
        while (!(line = br.readLine()).equals("*")) lines.add(line);
        for (String l : lines)
            System.out.println(l + " is " + (isSurprising(l) ? "surprising." : "NOT surprising."));

    }

    static boolean isSurprising(String str) {
        for (int dist = 0; dist <= str.length() - 2; dist++) {
            HashSet<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < str.length() - dist - 1; i++) {
                int hash = str.charAt(i) * 31 + str.charAt(i + dist + 1);
                if (set.contains(hash)) return false;
                set.add(hash);
            }
        }
        return true;
    }
}
