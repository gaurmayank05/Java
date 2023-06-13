//package ErrorHandling;

import java.util.Scanner;
import java.lang.ArithmeticException;

class Calculate {
    void divide(int n1, int n2) {
        try {
            int div;
            div = n1 / n2;
            System.out.println("Division =" + div);
        } catch (ArithmeticException ae) {
            System.out.println(ae.getMessage());
        } finally {
            System.out.println("Finally Block");
        }
    }
}

public class TryCatchE {
    public static void main(String[] args) {
        Scanner s1 = new Scanner(System.in);
        Calculate c1 = new Calculate();
        System.out.println("Enter First Number: ");
        int n1 = s1.nextInt();
        System.out.println("Enter second Number: ");
        int n2 = s1.nextInt();
        c1.divide(n1, n2);
        s1.close();
    }
}