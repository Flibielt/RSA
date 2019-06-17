package RSA.tools;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class ExtendedEuclidianAlgorithm {
    public static BigInteger gcd(BigInteger x, BigInteger y) {
        List<BigInteger> xk = new ArrayList<BigInteger>();
        List<BigInteger> yk = new ArrayList<BigInteger>();
        xk.add(BigInteger.ONE);
        xk.add(BigInteger.ZERO);
        yk.add(BigInteger.ZERO);
        yk.add(BigInteger.ONE);

        BigInteger divided;
        BigInteger remainder = BigInteger.ONE;
        if (x.compareTo(y) == -1) {
            BigInteger swap;
            swap = x;
            x = y;
            y = swap;
        }
        BigInteger originalX = x;
        BigInteger originalY = y;
        while (!remainder.equals(BigInteger.ZERO)) {
            divided = x.divide(y);
            remainder = x.subtract(y.multiply(divided));
            if (!remainder.equals(BigInteger.ZERO)) {
                xk.add((xk.get(xk.size() - 1).multiply(divided)).add(xk.get(xk.size() - 2)));
                yk.add((yk.get(yk.size() - 1).multiply(divided)).add(yk.get(yk.size() - 2)));
            }
            x = y;
            if (!remainder.equals(BigInteger.ZERO)) {
                y = remainder;
            }
        }
        BigInteger[] xkyk = new BigInteger[2];
        if (y.equals(BigInteger.ONE)) {
            xkyk[0] = xk.get(xk.size() - 1);
            xkyk[1] = yk.get(yk.size() - 1);
        } else {
            xkyk[0] = xkyk[0] = BigInteger.ZERO;
        }
        if (originalX.multiply(xkyk[0]).subtract(originalY.multiply(xkyk[1])).equals(BigInteger.ONE)) {
            xkyk[1] = xkyk[1].multiply(BigInteger.valueOf(-1));
        } else if (originalX.multiply(xkyk[0]).subtract(originalY.multiply(xkyk[1])).equals(BigInteger.valueOf(-1))) {
            xkyk[0] = xkyk[0].multiply(BigInteger.valueOf(-1));
        }
        System.out.println("EEA: " + originalX.multiply(xkyk[0]).add(originalY.multiply(xkyk[1])));
        return xkyk[1];
    }
}
