package RSA;

import java.math.BigInteger;

public class RSAEncryption {

    public static void main(String[] args) {
        if(args.length != 3){
            System.out.println("RSAEncryption e n m");
            System.exit(-1);
        }

        BigInteger e, n, m, c;
        String message;
        e = new BigInteger(args[0],16);
        n = new BigInteger(args[1],16);
        message = args[2];

        try{
            byte[] m_chars = message.getBytes("UTF-16BE");
            m = new BigInteger(m_chars);

            c = m.modPow(e, n);
            System.out.println("c: " + c.toString(16));

        } catch(Exception ex){
            System.out.println("Unsupported character set. "+ ex);
        }
    }
}
