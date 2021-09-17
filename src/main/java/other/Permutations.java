package other;

public class Permutations {
    public static void main(String[] args) {
        int[] pa = new int[] {1, 2, 3};
        prmt(pa, 0);
    }

    private static void prmt(int[] pa, int i) {
        if (i == pa.length - 1) {
            arraout(pa);
        } else {
            for (int j = i; j < pa.length; j++) {
                aswap(pa, i, j);
                prmt(pa, i + 1);
                aswap(pa, i, j);
            }
        }
    }

    private static void aswap(int[] pa, int i, int j) {
        int k = pa[i];
        pa[i] = pa[j];
        pa[j] = k;
    }

    private static void arraout(int[] pa) {
        String s = "[";

        for (int a : pa) {
            s += a + ", ";
        }

        s = s.substring(0, s.length() - 2);

        s += "]";

        System.out.println(s);
    }
}
