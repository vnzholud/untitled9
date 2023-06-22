package arrays150623;

import java.sql.Array;

public class povt_arrays {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };



        int summ = 0;
        summ = summa(arr);

        System.out.println(summ);
    }

    public static int summa(int array[][]) {
        int summ = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                summ += array[i][j];
            }

        }
        return summ;

        }

        public static void init() {


        }
}
