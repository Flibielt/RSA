package RSA.tools;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class ExtendedEuclidianAlgorithmTest {

    @Test
    void testGcd() {
        BigInteger[] xkyk = {BigInteger.valueOf(7), BigInteger.valueOf(-58)};
        assertEquals(xkyk, ExtendedEuclidianAlgorithm.gcd(BigInteger.valueOf(141), BigInteger.valueOf(17)));
    }
}