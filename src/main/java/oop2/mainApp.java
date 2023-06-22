package oop2;

import java.util.Scanner;

public class mainApp {

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        /*String s0 = "Hello world";
        String s1 = "Hello";
        s1 += " world";
        String s2 = scanner.nextLine();
        String s3 = "Hello world";



        System.out.println(s0==s1);
        System.out.println(s0==s2);
        System.out.println(s0==s3);

        System.out.println("++++++++++++++++++++++++");

        System.out.println(s0.equals(s1));
        System.out.println(s0.equals(s2));
        System.out.println(s0.equals(s3));*/

        long startTime = System.nanoTime();
        String exemple = "Exemple";

        for (int i = 0; i < 50000; i++) {
            exemple += i;
        }
        float delta = System.nanoTime() - startTime;
        System.out.println(exemple);
        System.out.println("Время: "+delta*0.000001f);

        StringBuilder exemple1 = new StringBuilder("Exemple");

        startTime = System.nanoTime();

        for (int i = 0; i < 50000; i++) {
            exemple1.append(i);
        }
        delta = System.nanoTime() - startTime;
        System.out.println(exemple1.toString());
        System.out.println("Время: "+delta*0.000001f);
        System.out.println(exemple.equals(exemple1.toString()));

    }
}
