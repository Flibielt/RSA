package RSA;

import java.math.BigInteger;

public class RSA {

    public static void main(String[] args) {
        //Primes
        BigInteger p, q;
        BigInteger n, fi_n, e, d;
        int bitLength;

        if (args.length == 2) {
            p = new BigInteger(args[0]);
            q = new BigInteger(args[1]);
        } else if (args.length == 1) {
            bitLength = Integer.parseInt(args[0])*8+1;
            p = new BigInteger(bitLength, 100, new java.util.Random());
            System.out.println("p: " + p.toString(16));
            q = new BigInteger(bitLength, 100, new java.util.Random());
            System.out.println("q: " + q.toString(16));
        } else {
            p = BigInteger.valueOf(431);
            q = BigInteger.valueOf(443);
            System.out.println("RSA p q");
            System.out.println("RSA m_karakterek_max_szama");
            java.lang.System.exit(-1);
        }

        //Calculate n and fi_n
        n = p.multiply(q);
        fi_n = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        System.out.println("fi(n): " + fi_n.toString(16));
        System.out.println("n: " + n.toString(16));

        //Calculate e
        e = BigInteger.valueOf(3);
        while(!e.gcd(fi_n).equals(BigInteger.ONE)){
            e = e.add(BigInteger.valueOf(2));
        }
        System.out.println("e: " + e.toString(16));

        //Calculate d
        d = e.modInverse(fi_n);
        System.out.println("d: " + d.toString(16));
    }
}
