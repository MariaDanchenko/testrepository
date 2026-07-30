import java.util.Scanner;

public class CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Напишите температуру в градусах Цельсия: ");
                int celsius = scanner.nextInt();

        int fahrenheit = celsius * 9 / 5 + 32;

        System.out.println(celsius + "°C = " + fahrenheit + "℉ ");
    }

}
