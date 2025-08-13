public class OperatorPrecedence {
    public static void main(String[] args) {

        int a = 5, b = 10, c = 2;

        int result1 = (a + b) * c + c; //(5+10)*2+2 = 32
        int result2 = ++a + b * c; //6+10*2 = 26
        boolean result3 = (a + b) > (c * 15); //(5+10)>(2*15) 15>30 false
        boolean result4 = (a != b) == (c < b); //5 не равно 10 = 2<10 true
        boolean result5 = (a < b) && (c > 0) || (b == 10); //5<10 и 2>0 или 10=10 true

        System.out.println("(a + b) * c + c = " + result1);
        System.out.println("++a + b * с = " + result2);
        System.out.println("(a + b) > (c * 10) : " + result3);
        System.out.println("(a != b) == (c < b) : " + result4);
        System.out.println("(a < b) && (c > 0) || (b == 10) : " + result5);

    }

}
