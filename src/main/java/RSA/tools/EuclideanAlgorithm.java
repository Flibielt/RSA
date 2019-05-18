package RSA.tools;

import java.math.BigInteger;

public class EuclideanAlgorithm {
    public static BigInteger gcd(BigInteger x, BigInteger y) {
        BigInteger divided = null;
        BigInteger remainder = BigInteger.ONE;
        while (!remainder.equals(BigInteger.ZERO)) {
            divided = x.divide(y);
            remainder = x.subtract(y.multiply(divided));
            x = y;
            y = remainder;
        }
        return divided;
    }
}
