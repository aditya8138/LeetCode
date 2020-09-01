public class Test {
    public static int findLatestStep(int[] arr, int m) {
        int last = -1;
        int[] bits = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            bits[arr[i] - 1] = 1;
            if (containsSub(bits, m)) {
                last = i + 1;
            }
        }
        return last;
    }

    public static boolean containsSub(int[] bits, int m) {
        for (int i = 0; i < bits.length; i++) {
            if (m == 0) {
                break;
            } else {
                if (bits[i] == 1) {
                    m--;
                } else {
                    m++;
                }
            }
        }
        return m == 0;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 2, 4};
        findLatestStep(arr, 1);
    }
}
