package za.co.bbd.junit;

public class Multiplier {
    public int multiply(int a, int b) {
        if (a < 0 || b < 0 || a >= 100 || b >= 100) {
            throw new IllegalArgumentException("We aren't allowed weird numbers");
        }
        if (a % 2 == 0 || b % 2 == 0)
            return 0;
        return a * b;
    }
}
