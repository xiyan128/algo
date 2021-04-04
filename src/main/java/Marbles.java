import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Marbles {

    static final Random rd = new Random();
    public static final int NUM = 28;

    public static void main(String[] args) {
        int g = 0, r = 0;
        for (int i = 0; i < 100; i++) {
            if (sim()) r++;
            else g++;
        }
        System.out.println("g: " + g);
        System.out.println("r: " + r);
    }

    private static boolean sim() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < NUM; i++) {
            list.add("Green");
            list.add("Red");
        }
        while (list.size() != 1) op(list);
//        System.out.println(list);
        return list.get(0).equals("Red");
    }

    public static void op(List<String> list) {
        String sample1 = list.remove(rd.nextInt(list.size()));
        String sample2 = list.remove(rd.nextInt(list.size()));
        System.out.println(sample1 + " " + sample2);
        if (sample1.equals(sample2)) list.add("Green");
        else list.add("Red");
    }
}
