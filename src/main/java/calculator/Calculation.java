package calculator;

public class Calculation {
    float a;
    float b;
    char oper;

    public Calculation(float a, float b, char oper) {
        this.a = a;
        this.b = b;
        this.oper = oper;
    }

   public float operaton(){
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
   }
}
