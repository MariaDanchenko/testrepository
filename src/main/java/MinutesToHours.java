import java.util.Scanner;

public class MinutesToHours {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество минут: ");
        int minutes = scanner.nextInt();

        int hours = minutes / 60;
        int remainingMinutes = minutes % 60;

        System.out.println(minutes + " минут = " + hours + " часов и " + remainingMinutes + " минут");

        scanner.close();
    }
}
