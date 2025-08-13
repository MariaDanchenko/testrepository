import java.util.Scanner;

public class CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Напишите температуру в градусах Цельсия: ");
                int Celsius = scanner.nextInt();

        int Fahrenheit = Celsius * 9 / 5 + 32;

        System.out.println(Celsius + "°C = " + Fahrenheit + "℉ ");
    }

}
