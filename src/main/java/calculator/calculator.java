package calculator;

import java.util.Scanner;



public class calculator {
    static float a;
    static float b;
    static float rez = 0;
    static char oper;

    public static void main(String[] args) {


        a = vvod();
        b = vvod();
        oper = operation();

        Calculation calculation = new Calculation(a, b, oper);
        rez = calculation.operaton();

        //rez = calculation(a,b,oper);


        System.out.println(rez);

    }

    private static float vvod() {
        float a;
        System.out.println("Введите число");
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();

        return a;
    }

    private static char operation() {
        System.out.println("Введите операцию");
        Scanner scanner = new Scanner(System.in);
        char oper = scanner.next().charAt(0);

        return oper;
    }

}

   /* private static float calculation (float a, float b, char oper) {




        float rez = 0;

        if(b==0 && oper=='/') {
            System.out.println("При делении на ноль получится бесконечность");

        } else if (oper == '+'){
            rez = a+b;
        } else if (oper == '-') {
            rez = a-b;
        } else if (oper=='/') {
            rez = a/b;
        } else if (oper=='*') {
            rez = a*b;
        }

        return rez;
    }*/




