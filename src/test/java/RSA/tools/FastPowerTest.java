package RSA.tools;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class FastPowerTest {

    @Test
    void testCalculate() {
        assertEquals(BigInteger.valueOf(511), FastPower.calculate(BigInteger.valueOf(7), BigInteger.valueOf(283), BigInteger.valueOf(567)));
        assertEquals(BigInteger.valueOf(320), FastPower.calculate(BigInteger.valueOf(5), BigInteger.valueOf(283), BigInteger.valueOf(567)));
    }
}