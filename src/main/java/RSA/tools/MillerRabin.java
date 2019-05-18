package RSA.tools;

import java.math.BigInteger;

import static java.lang.Math.pow;

public class MillerRabin {
    private static int getS(BigInteger n) {
        int s = 0;
        BigInteger two = BigInteger.valueOf(2);
        BigInteger x = n.subtract(BigInteger.ONE);
        while ((x.mod(two)).equals(BigInteger.ZERO)) {
            s++;
            x = x.divide(two);
        }
        return s;
    }

    public static boolean isPrime(BigInteger n) {
        boolean prime = false;
        int s = getS(n);
        BigInteger d = (n.subtract(BigInteger.ONE)).divide((BigInteger.valueOf(2)).pow(s));
        int[] bases = {3, 5, 7};

        for (int i : bases) {
            if (!(EuclideanAlgorithm.gcd(n, BigInteger.valueOf(i))).equals(BigInteger.ONE)) {
                prime = false;
                break;
            } else {
                if (FastPower.calculate(BigInteger.valueOf(i), d, n).equals(BigInteger.ONE)) {
                    prime = true;
                } else {
                    for (int r = 0; r < s; r++) {
                        if (FastPower.calculate(BigInteger.valueOf(i), d.multiply(BigInteger.valueOf((int) pow(2, r))), n).equals(n.subtract(BigInteger.ONE))) {
                            prime = true;
                            break;
                        } else {
                        }
                    }
                }
            }
        }
        return prime;
    }

    public static BigInteger createPrime(int bitLength) {
        BigInteger random = new BigInteger(bitLength, new java.util.Random());
        if (random.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO)) {
            random = random.add(BigInteger.ONE);
        }
        while (!isPrime(random)) {
            random = random.add(BigInteger.valueOf(2));
        }
        return random;
    }
}
