import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;

public class LCDisplay {
    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static StringTokenizer st;

    static boolean[][] encodings = new boolean[][]{
            {true, true, true, true, true, true, false},
            {false, true, true, false, false, false, false},
            {true, true, false, true, true, false, true},
            {true, true, true, true, false, false, true},
            {false, true, true, false, false, true, true},
            {true, false, true, true, false, true, true},
            {true, false, true, true, true, true, true},
            {true, true, true, false, false, false, false},
            {true, true, true, true, true, true, true},
            {true, true, true, true, false, true, true},
    };

    public static void main(String[] args) throws IOException {
        int s;
        String n;
        int[] digits;
        boolean flag = false;
        while (true) {
            if (flag) System.out.println();
            flag = true;
            s = readInt();
            n = next();
            if (s == 0 && n.equals("0")) break;
            digits = toDigits(n);
            print(digits, s);
        }
    }

    public static void print(int[] digits, int s) {
        printHori(digits, s, 0);
        printVerti(digits, s, 5, 1);
        printHori(digits, s, 6);
        printVerti(digits, s, 4, 2);
        printHori(digits, s, 3);
    }

    private static void printVerti(int[] digits, int s, int left, int right) {
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < digits.length; j++) {
                if (encodings[digits[j]][left]) System.out.print("|");
                else System.out.print(" ");
                for (int k = 0; k < s; k++) System.out.print(" ");
                if (encodings[digits[j]][right]) System.out.print("|");
                else System.out.print(" ");
                if (j != digits.length - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }

    private static void printHori(int[] digits, int s, int seg) {
        for (int i = 0; i < digits.length; i++) {
            System.out.print(" ");
            for (int j = 0; j < s; j++)
                if (encodings[digits[i]][seg]) System.out.print("-");
                else System.out.print(" ");
            System.out.print(" ");
            if (i != digits.length - 1) System.out.print(" ");
        }
        System.out.println();
    }

    public static int[] toDigits(String str) {
        int[] res = new int[str.length()];
        for (int i = 0; i < str.length(); i++) res[i] = str.charAt(i) - '0';
        return res;
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
