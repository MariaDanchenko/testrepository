import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите длину прямоугольника: ");
        double length = scanner.nextDouble();

        System.out.print("Введите ширину прямоугольника: ");
        double width = scanner.nextDouble();

        double area = length * width;

        System.out.println("Площадь прямоугольника: " + area);

        scanner.close();
    }
}

