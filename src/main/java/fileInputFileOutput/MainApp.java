package fileInputFileOutput;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("Start");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("text.txt");

            PrintStream printStream = new PrintStream(fileOutputStream); //пример обертки

            printStream.println("gdfhdghdhdhdfghdghdhdhdhdhdhgdhgd");

            byte[] myString = "hello world".getBytes(StandardCharsets.UTF_8);

            fileOutputStream.write(myString);

            printStream.close();

            fileOutputStream.flush();
            fileOutputStream.close();

            //   fileOutputStream.write(45);
        //    fileOutputStream.write(65);
        //    fileOutputStream.write(95);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileInputStream fileInputStream = new FileInputStream("text.txt");
            int output;
            while ((output = fileInputStream.read())!=-1) {
                System.out.print((char) output);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("End");
    }
}
