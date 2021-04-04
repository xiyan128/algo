import java.math.BigInteger;
import java.util.*;

public class CountFibs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<BigInteger>  fibs = new ArrayList<BigInteger>(),
                uppers = new ArrayList<BigInteger>(),
                lowers = new ArrayList<BigInteger>();

        BigInteger max = new BigInteger("0");
        while (scanner.hasNext()) {
            BigInteger lower = scanner.nextBigInteger();
            BigInteger upper = scanner.nextBigInteger();
            if (lower.bitLength() == 0 && upper.bitLength() == 0) break;
            lowers.add(lower);
            if (upper.compareTo(max) > 0) max = upper;
            uppers.add(upper);
        }
        fibs.add(new BigInteger("0"));
        fibs.add(new BigInteger("1"));
        while (fibs.get(fibs.size() - 1).compareTo(max) < 0)
            fibs.add(fibs.get(fibs.size() - 1).add(fibs.get(fibs.size() - 2)));
        for (int i = 0; i < uppers.size(); i++) {
            int lo = Collections.binarySearch(fibs, lowers.get(i));
            int hi = Collections.binarySearch(fibs, uppers.get(i));
            int res = 0;
            if (lo >= 0 && lo == hi) res = 1;
            else if (lo >= 0 && hi > lo) res = hi - lo + 1;
            else if (lo >= 0 && hi < 0) res = - hi - lo - 1;
            else if (lo < 0 && hi >= 0)  res = hi + lo + 2;
            else res = Math.abs(Math.abs(lo) - Math.abs(hi));
            System.out.println(res);
        }
    }
}
