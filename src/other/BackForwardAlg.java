package other;

public class BackForwardAlg {

    public static int BackForwardAlg(int n) {
        if (n <= 10) {
            return n;
        }
        if (n % 2 == 0) {
            return BackForwardAlg(n / 2);
        } else {
            return BackForwardAlg(n + 3);
        }
    }
}
