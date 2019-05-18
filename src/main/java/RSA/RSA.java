package RSA;

import RSA.tools.EuclideanAlgorithm;
import RSA.tools.MillerRabin;

import java.math.BigInteger;

public class RSA {

    //Primes
    private BigInteger[] privateKey = new BigInteger[2];
    private BigInteger[] publicKey = new BigInteger[2];
    //The length of the message

    /**
     * Constructor for the RSA.
     *
     * @param bitLength the length of the message
     */
    RSA(int bitLength) {
        bitLength = bitLength*8+1;
        privateKey[0] = MillerRabin.createPrime(bitLength);
        System.out.println("p: " + privateKey[0].toString(16));
        privateKey[1] = MillerRabin.createPrime(bitLength);
        System.out.println("q: " + privateKey[1].toString(16));

        calculate();
    }

    /**
     * Constructor for the RSA.
     *
     * @param p first prime number
     * @param q second prime number
     */
    RSA(int p, int q) {
        privateKey[0] = BigInteger.valueOf(p);
        privateKey[1] = BigInteger.valueOf(q);

        calculate();
    }

    private void calculate() {
        BigInteger fi_n, d;
        //Calculate n
        publicKey[0] = privateKey[0].multiply(privateKey[1]);
        fi_n = privateKey[0].subtract(BigInteger.ONE).multiply(privateKey[1].subtract(BigInteger.ONE));
        System.out.println("fi(n): " + fi_n.toString(16));
        System.out.println("n: " + publicKey[0].toString(16));

        //Calculate e
        publicKey[1] = BigInteger.valueOf(3);
        while(!EuclideanAlgorithm.gcd(privateKey[1], fi_n).equals(BigInteger.ONE)){
            publicKey[1] = publicKey[1].add(BigInteger.valueOf(2));
        }
        System.out.println("e: " + publicKey[1].toString(16));

        //Calculate d
        d = publicKey[1].modInverse(fi_n);
        System.out.println("d: " + d.toString(16));
    }

    public static void main(String[] args) {
        RSA rsa = null;
        if(args.length == 2){
            rsa = new RSA(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        }
        else if(args.length == 1){
            int bit_length = Integer.parseInt(args[0])*8+1;
            rsa = new RSA(bit_length);
        }
        else{
            System.out.println("RSA p q");
            System.out.println("RSA m_karakterek_max_szama");
            java.lang.System.exit(-1);
        }

        if (rsa != null) {
            rsa.calculate();
        }
    }
}
