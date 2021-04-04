import java.io.IOException;
import java.util.StringTokenizer;

public class SpeedLimit {
    static java.io.BufferedReader br = new java.io.BufferedReader(new java.io.InputStreamReader(java.lang.System.in));
    static java.util.StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int len = 0;
        while ((len = readInt()) != -1) {
            int[] arr = new int[len], sp = new int[len];
            int sum = 0;
            for (int i = 0; i < len; i++) {
                sp[i] = readInt();
                arr[i] = readInt();
            }
            for (int i = len - 1; i >= 0; i--) {
                int time = arr[i] - (i == 0 ? 0 : arr[i - 1]);
                sum += time * sp[i];
            }
            System.out.println(sum + " miles");
        }

    }

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }

    static int readInt() throws IOException {
        return Integer.parseInt(next());
    }


}
