import java.util.Scanner;

public class FindMinimum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Напишите первое число: ");
        int first = scanner.nextInt();

        System.out.print("Напишите второе число: ");
        int second = scanner.nextInt();

        System.out.print("Напишите третье число: ");
        int third = scanner.nextInt();

        int Minimum = Math.min(first, Math.min(second, third));

        System.out.println("Минимальное число: " + Minimum);
    }

}
