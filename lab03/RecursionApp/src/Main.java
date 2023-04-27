import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int res1 = 0;
        int res2 = 0;
        int num1 = 0;
        int num2 = 0;

        Scanner scan = new Scanner(System.in);

        Factorial fact = new Factorial();
        Fibonacci fib = new Fibonacci();
        SumN sumn = new SumN();
        SumAB sumab = new SumAB();

        do{
            System.out.print("Enter a number to find the factorial: ");
            num1 = scan.nextInt();
        } while (num1 < 0);

        res1 = fact.recursionExecute(num1);
        res2 = fact.cycleExecute(num1);

        assert res1 == res2: "different values";

        System.out.printf("Number: %s", num1);
        System.out.printf("\nFactorial: %s\n", res1);

        do{
            System.out.print("\nEnter the index of the Fibonacci number: ");
            num1 = scan.nextInt();
        } while (num1 < 0);

        res1 = fib.recursionExecute(num1);
        res2 = fib.cycleExecute(num1);

        assert res1 == res2: "different values";

        System.out.printf("Number: %s", num1);
        System.out.printf("\nFibonacci: %s\n", res1);

        do{
            System.out.print("\nEnter the number to sum: ");
            num1 = scan.nextInt();
        } while (num1 < 0);

        res1 = sumn.execute(num1);

        System.out.printf("Number: %s", num1);
        System.out.printf("\nSum: %s\n", res1);

        do{
            System.out.print("\nEnter the first number: ");
            num1 = scan.nextInt();
        } while (num1 < 0);
        do{
            System.out.print("Enter the second number: ");
            num2 = scan.nextInt();
        } while (num2 < 0);

        res1 = sumab.execute(num1, num2);

        System.out.printf("Numbers: %s and %s", num1, num2);
        System.out.printf("\nSum: %s\n", res1);
    }
}