import java.util.Scanner;

public class FindMinimum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Напишите первое число: ");
        int First = scanner.nextInt();

        System.out.print("Напишите второе число: ");
        int Second = scanner.nextInt();

        System.out.print("Напишите третье число: ");
        int Third = scanner.nextInt();

        int Minimum = Math.min(First, Math.min(Second, Third));

        System.out.println("Минимальное число: " + Minimum);
    }

}
