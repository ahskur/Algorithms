import java.lang.Math;

public class RationalNumber implements Comparable<RationalNumber> {
    private int num = 0;
    private int denom = 1;

    public RationalNumber() {}
    public RationalNumber(int n, int d) {
        if (d == 0) {
            throw new IllegalArgumentException("Denominator darf nicht 0 sein!");
        }
        // Simplify the fraction
        int a = Math.abs(n);
        int b = Math.abs(d);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        if (n * (d / a) < 0) {
            this.num = -Math.abs(n / a);
        } else {
            this.num = Math.abs(n / a);
        }
        this.denom = Math.abs(d / a);
    }

    public int getNum() {
        return num;
    }

    public int getDenom() {
        return denom;
    }

    public int compareTo(RationalNumber n) {
        int thisValue = this.num * n.denom;
        int otherValue = this.denom * n.num;
        return Integer.compare(thisValue, otherValue);
    }

    public RationalNumber add(RationalNumber r) {
        int newNum = (this.num * r.denom) + (r.num * this.denom);
        int newDenom = this.denom * r.denom;
        return new RationalNumber(newNum, newDenom);
    }

    public RationalNumber div(RationalNumber r) {
        int newNum = this.num * r.denom;
        int newDenom = this.denom * r.num;
        return new RationalNumber(newNum, newDenom);
    }

    public String toString() {
        return num + "/" + denom;
    }

    public static void main(String[] args) {
        // Testrahmen
        RationalNumber r1 = new RationalNumber(1, 2);
        RationalNumber r2 = new RationalNumber(-3, 4);

        System.out.println("r1: " + r1);
        System.out.println("r2: " + r2);

        RationalNumber sum = r1.add(r2);
        RationalNumber quotient = r1.div(r2);

        System.out.println("Summe: " + sum.toString());
        System.out.println("Quotient: " + quotient.toString());

        System.out.println("Vergleich: " + r1.compareTo(r2));
    }
}

