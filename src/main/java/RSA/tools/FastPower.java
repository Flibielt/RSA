package RSA.tools;

import java.math.BigInteger;

public class FastPower {
    public static BigInteger calculate(BigInteger base, BigInteger exponent, BigInteger modulo) {
        String numberInBinary = exponent.toString(2);
        BigInteger multiplication = BigInteger.ONE;
        BigInteger previous = (base.pow(1)).mod(modulo);
        if (numberInBinary.charAt(numberInBinary.length() - 1) == '1') {
            multiplication = previous;
        }
        for (int i = 1; i < numberInBinary.length(); i++) {
            previous = (previous.pow(2)).mod(modulo);
            if (numberInBinary.charAt(numberInBinary.length() - (i + 1)) == '1') {
                multiplication = multiplication.multiply(previous);
            }
        }
        return multiplication.mod(modulo);
    }
}
