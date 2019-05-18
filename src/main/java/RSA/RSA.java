package RSA;

import java.math.BigInteger;

public class RSA {

    //Primes
    private BigInteger[] privateKey = new BigInteger[2];
    private BigInteger[] publicKey = new BigInteger[2];
    private BigInteger fi_n, d;
    //The length of the message

    RSA(int bitLength) {
        bitLength = bitLength*8+1;
        privateKey[0] = new BigInteger(bitLength, 100, new java.util.Random());
        System.out.println("p: " + privateKey[0].toString(16));
        privateKey[1] = new BigInteger(bitLength, 100, new java.util.Random());
        System.out.println("q: " + privateKey[1].toString(16));

        calculate();
    }

    RSA(int p, int q) {
        privateKey[0] = BigInteger.valueOf(p);
        privateKey[1] = BigInteger.valueOf(q);

        calculate();
    }

    private void calculate() {
        publicKey[0] = privateKey[0].multiply(privateKey[1]);
        fi_n = privateKey[0].subtract(BigInteger.ONE).multiply(privateKey[1].subtract(BigInteger.ONE));
        System.out.println("fi(n): " + fi_n.toString(16));
        System.out.println("n: " + publicKey[0].toString(16));

        //Calculate e
        publicKey[1] = BigInteger.valueOf(3);
        while(!publicKey[1].gcd(fi_n).equals(BigInteger.ONE)){  //TODO: instead of gcd use own function
            publicKey[1] = publicKey[1].add(BigInteger.valueOf(2));
        }
        System.out.println("e: " + publicKey[1].toString(16));

        //Calculate d
        d = publicKey[1].modInverse(fi_n);
        System.out.println("d: " + d.toString(16));
    }
}
