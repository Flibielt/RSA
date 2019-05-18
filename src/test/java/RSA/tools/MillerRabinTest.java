package RSA.tools;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class MillerRabinTest {

    @Test
    void testIsPrime() {
        assertTrue(MillerRabin.isPrime(BigInteger.valueOf(467)));
        assertTrue(MillerRabin.isPrime(BigInteger.valueOf(479)));
        assertTrue(MillerRabin.isPrime(BigInteger.valueOf(503)));
        assertTrue(MillerRabin.isPrime(BigInteger.valueOf(71)));
        assertTrue(MillerRabin.isPrime(BigInteger.valueOf(541)));
    }
}