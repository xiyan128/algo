import java.io.IOException;
import java.util.Scanner;

public class BoxOfBricks {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int set = 1;
        while (sc.hasNext()) {
            int len = sc.nextInt();
            if (len == 0) return;
            int[] num = new int[len];
            int avg = 0;
            for (int i = 0; i < len; i++) {
                num[i] = sc.nextInt();
                avg += num[i];
            }
            avg /= len;
            int times = 0;
            for (int i = 0; i < len; i++) if (num[i] > avg) times += num[i] - avg;
            System.out.println("Set #" + set++);
            System.out.println("The minimum number of moves is " + times + ".");
            System.out.println();
        }
    }
}
