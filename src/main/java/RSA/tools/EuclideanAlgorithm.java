package RSA.tools;

import java.math.BigInteger;

public class EuclideanAlgorithm {
    public static BigInteger gcd(BigInteger x, BigInteger y) {
        BigInteger divided = null;
        BigInteger remainder = BigInteger.ONE;
        if (x.compareTo(y) == -1){
            BigInteger swap = y;
            y = x;
            x = swap;
        }
        while (!remainder.equals(BigInteger.ZERO)) {
            divided = x.divide(y);
            remainder = x.subtract(y.multiply(divided));
            x = y;
            if (!remainder.equals(BigInteger.ZERO)) {
                y = remainder;
            }
        }
        return y;
    }
}
