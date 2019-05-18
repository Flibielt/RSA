package RSA.tools;

import java.math.BigInteger;

import static java.lang.Math.pow;

public class MillerRabin {
    private static int getS(BigInteger n) {
        int s = 0;
        BigInteger two = BigInteger.valueOf(2);
        while ((n.mod(two)).equals(BigInteger.ZERO)) {
            s++;
            n = n.divide(two);
        }
        return s;
    }

    public static boolean isPrime(BigInteger n) {
        boolean prime = false;
        int s = getS(n);
        BigInteger d = (n.divide(BigInteger.ONE)).divide((BigInteger.TWO).pow(s));
        int[] bases = {3, 5, 7, 11};

        for (int i : bases) {
            if (!EuclideanAlgorithm.gcd(d, BigInteger.valueOf(i)).equals(BigInteger.ONE)) {
                prime = false;
                break;
            } else {
                if (FastPower.calculate(BigInteger.valueOf(i), d, n).equals(BigInteger.ONE)) {
                    prime = true;
                } else {
                    for (int r = 0; r < s; r++) {
                        if (FastPower.calculate(BigInteger.valueOf(i), d.multiply(BigInteger.valueOf((int) pow(2, r))), n).equals(BigInteger.ONE)) {
                            prime = true;
                        }
                    }
                }
            }
        }
        return prime;
    }
}
