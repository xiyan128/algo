import java.util.*;

public class Sim {
    static int count = 0;
    static void sim(String str, int n) {
        if (str.length() >= n) {
//            System.out.println(str);
            count ++;
            return;
        }
        if (str.startsWith("11", str.length() - 2)) sim(str + "0", n);
        else {
            sim(str + "0", n);
            sim(str + "1", n);
        }
    }

    static void sim2(String str, int n, Set<String> list) {
        if (str.length() >= n) {
            list.add(str);
        } else {
            sim2(str + "1", n, list);
            sim2(str + "01", n, list);
            sim2(str + "001", n, list);
        }
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < 20; i++) {
            sim2("", i, set);
        }
        List<String> list = new ArrayList<>(set);
        list.sort(Comparator.comparingInt(String::length));
        for (int i = 0; i < 20; i++) {
            int finalI = i;
            int count = (int) list.stream().filter(s -> s.length() == finalI).count();
            System.out.println(count);
        }
//        System.out.println(list);
    }
}
