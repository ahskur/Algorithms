/**************************************
2) ackermann(1, 10) = 1024
   ackermann(2, 4) = 65536
   ackermann(3, 3) = 65536

 3) Ackermann-Funktion ist eine schnell wachsende, rekursive Funktion. Das könnte zu einem Stack Overflow führen
 Stack Overflow = Wenn der Stack voll ist, bzw der Speicherbereich für die Methodeaufruf/lokale Variablen nicht freigegeben wird
 Kann schnell bei endlosen rekursiven Funktionen auftreten, wenn die Rekursion zu tief geht und der Stack voll ist

 ***********************************************/
import java.math.BigInteger;

public class AckermannFunction {
    public static BigInteger ackermann(BigInteger x, BigInteger y){
        if (y.equals(BigInteger.ZERO)) {
            return BigInteger.ZERO;
        } else if (x.equals(BigInteger.ZERO)) {
            return BigInteger.valueOf(2).multiply(y);
        } else if (y.equals(BigInteger.ONE)) {
            return BigInteger.TWO;
        } else {
           return ackermann(x.subtract(BigInteger.ONE), ackermann(x, y.subtract(BigInteger.ONE)));
        }
    }

        public static void main(String[] args) {
        BigInteger x = BigInteger.valueOf(1);
        BigInteger y = BigInteger.valueOf(10);
        System.out.println(ackermann(x,y));
    }
}