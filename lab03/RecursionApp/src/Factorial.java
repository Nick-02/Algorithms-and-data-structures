public class Factorial {
    public int recursionExecute(int n) {
        int res = 1;
        if (n == 1 || n == 0) {
            return res;
        }
        res = n * recursionExecute(n-1);
        return res;
    }

    public int cycleExecute(int n) {
        int res = 1;
        if (n == 0) {
            return res;
        }
        for (int i = 1; i <= n; i++) {
            res = res * i;
        }
        return res;
    }
}
