import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.Buffer;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение: ");
        String input = scanner.nextLine();
        while(!input.isEmpty()){
            String[] parsed = Calculate.parsing(input);
            String operator = parsed[1];
            int operand1 = 0;
            int operand2 = 0;

            Operations operations;
            try{
                operand1 = Integer.parseInt(parsed[0]);
                operand2 = Integer.parseInt(parsed[2]);
                operations = new Arabic(operand1,operand2);
            }
            catch (NumberFormatException e){
                Calculate.isArabic = false;
                System.out.println("Введены римские цифры.");
                operations = new Romes(parsed[0],parsed[2]);
            }

            if(operator.equals("+"))
                operations.plus();
            if(operator.equals("-"))
                operations.minus();
            if(operator.equals("*"))
                operations.multiply();
            if(operator.equals("/"))
                operations.divide();

            if(Calculate.isArabic){
                System.out.println("Ответ: "+ operations.getResult());
            }
            else{
                System.out.println("Ответ: "+operations.getStringResult());
            }
            System.out.println();
            System.out.println("Введите следующее выражение: ");
            input = scanner.nextLine();
        }
        System.out.println("Вы вышли из калькулятора.");
     }

}