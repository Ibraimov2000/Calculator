import com.sun.jdi.connect.Connector;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Calculate {
    public static boolean isArabic = true;

    public static String[] parsing(String input){
        String[] parsed = input.split(" ");
        if(parsed.length != 3){
            Scanner scanner_again = new Scanner(System.in);
            System.out.println("Введите выражение, разделяя пробелом.");
            input  = scanner_again.nextLine();
            return parsing(input);
        }
        else {
            return parsed;
        }
    }

}
