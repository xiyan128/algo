import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RecyclingRef {

    static void generateTests() {
        Random rd = new Random();
        String[] chs = new String[]{"r", "o", "y", "g", "b"};
        for (int i = 0; i < rd.nextInt(100); i++) {
            List<String> alo = new ArrayList<String>(List.of("G", "P", "S", "A", "N"));
            for (int j = 0; j < 5; j++) {
                System.out.print(chs[j]);
                System.out.print("/");
                System.out.print(alo.remove(rd.nextInt(alo.size())));
                if (j != 4) System.out.print(",");
                else System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            generateTests();
            System.out.println("e");
        }
        System.out.println("#");
    }
//    public static void main(String[] args) throws NumberFormatException,
//            IOException {
//        BufferedReader in = new BufferedReader(new InputStreamReader(
//                System.in));
//        String newline = in.readLine();
//        String [][] cities = new String [100][5];
//        int counter = 0,min = 1000,result = 0;
//        int scores[];
//
//        while(newline.charAt(0) != '#'){
//
//            counter = 0 ;
//            min = 1000;
//            while(newline.charAt(0) != 'e'){
//                cities[counter] = newline.split(",");
//                Arrays.sort(cities[counter++]);
//                newline = in.readLine();
//            }
//            scores = new int [counter];
//            for(int i = 0 ; i < counter ; i++){
//                findScores(scores, cities, i, counter);
//            }
//            for(int i = 0 ; i < counter ; i++){
//                if(scores[i] < min){
//                    min = scores[i];
//                    result = i;
//                }
//            }
//            System.out.println(result+1);
//            newline = in.readLine();
//        }
//    }

    public static void findScores(int[] scores, String [][] cities,int i,int counter){
        for(int j = i+1 ; j < counter ; j++){
            for(int k = 0 ; k < 5 ; k++){
                if(cities[j][k].charAt(2) != cities[i][k].charAt(2)){
                    scores[i]++;
                    scores[j]++;
                }
            }
        }
    }
}