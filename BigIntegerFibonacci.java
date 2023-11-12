/**************************************
 Baumrekursion
 Für fib1(5):

 fib1(4)
    fib1(3)
        fib1(2)
            fib1(1)
            fib1(0)
         fib1(1)
    fib1(2)
        fib1(1)
        fib1(0)

 F(0) ≡ 0
 F(1) ≡ 1
 F(2) = F(1) + F(0) = 1 + 0 = 1
 F(3) = F(2) + F(1) = 1 + 1 = 2
 F(4) = F(3) + F(2) = 2 + 1 = 3
 F(5) = F(4) + F(3) = 3 + 2 = 5

 ***********************************************/
import java.math.*;

public class BigIntegerFibonacci {
    private static int schleifeRek = 0;
    private static int schleifeIter = 0;

    public static BigInteger fib1(int n) {
        schleifeRek++;
        if ((n == 0) || (n == 1)) {
            return BigInteger.ONE;
        } else {
            return fib1(n - 2).add(fib1(n - 1));
        }
    }
    public static BigInteger fib2(int n) {
         schleifeIter++;
         if ((n == 0) || (n == 1)) {
            return BigInteger.ONE;
         } else {
             BigInteger a = BigInteger.ZERO;
             BigInteger b = BigInteger.ONE;
             BigInteger result = BigInteger.ZERO;

             for (int i = 1; i <= n; i++) {
                 result = a.add(b);
                 a = b;
                 b = result;
                 schleifeIter++;
             }
             return result;
         }
    }
    public static void main(String[] args) {
            // Ab Vorgang 21 wird zur grosseren Zeitunterschied!
            int vorgang = 7;

            long startTime, endTime;

            startTime = System.currentTimeMillis();
            BigInteger RekFib = fib1(vorgang);
            endTime = System.currentTimeMillis();

            System.out.println("Anzahl an Vorgängen: "+schleifeRek);
            System.out.println("Zeit für Rekursiv: " + (endTime - startTime) + " ms");
            System.out.println("Rekursiv: "+ RekFib +"\n");


            startTime = System.currentTimeMillis();
            BigInteger IterFib = fib2(vorgang);
            endTime = System.currentTimeMillis();

            System.out.println("Anzahl an Vorgängen: "+schleifeIter);
            System.out.println("Zeit für Iterativ: " + (endTime - startTime) + " ms");
            System.out.println("Iterativ: "+ IterFib);
        }
    }

