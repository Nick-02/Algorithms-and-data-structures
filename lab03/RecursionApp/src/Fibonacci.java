public class Fibonacci {
    public int recursionExecute(int n) {
        if (n <= 1) {
            return n;
        }

        return recursionExecute(n - 1) + recursionExecute(n - 2);
    }

    public int cycleExecute(int n) {
        if (n <= 1) {
            return n;
        }

        int a = 0;
        int b = 1;
        for (int i = 0; i < n - 1; i++)
        {
            int c = a + b;
            a = b;
            b = c;
        }

        return b;
    }
}
