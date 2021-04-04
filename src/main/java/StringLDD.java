import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class StringLDD {
    static HashSet<String> refer = new HashSet<String>();
    static String data[] = new String[101];
    static int n = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            n = Integer.parseInt(in.readLine());
            if (n == 0) break;
            refer.clear();
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                data[i] = in.readLine();
                if (refer.contains(data[i]))
                    flag = false;
                else
                    refer.add(data[i]);
            }
            int count = 0;
            for (count = 0; flag; count++) {
                refer.clear();
                for (int i = 0; i < n; i++) {
                    data[i] = data[i].substring(1);
                    if (refer.contains(data[i]) || data[i].length() == 0)
                        flag = false;
                    else
                        refer.add(data[i]);

                }
            }
            System.out.println(count - 1);
        }
    }
}

