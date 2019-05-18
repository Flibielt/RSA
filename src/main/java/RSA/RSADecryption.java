package RSA;

import java.math.BigInteger;

public class RSADecryption {

    public static void main(String[] args) {

        if(args.length != 3){
            System.out.println("RSADecryption d n c");
            System.exit(-1);
        }

        BigInteger d, n, c, m;
        String message;
        d = new BigInteger(args[0],16);
        n = new BigInteger(args[1],16);
        c = new BigInteger(args[2],16);

        try {

            m = c.modPow(d, n);
            byte[] m_chars = m.toByteArray();

            if((m_chars.length)%2 != 0){
                byte[] destination = new byte[m_chars.length+1];
                System.arraycopy(m_chars, 0, destination, 1, m_chars.length);
                destination[0] = 0;
                m_chars = destination;
            }

            message = new String(m_chars,"UTF-16BE");
            System.out.println(message);
        } catch (Exception e) {
            System.out.println("Unsupported character set");
            System.out.println(e);
        }
    }
}
