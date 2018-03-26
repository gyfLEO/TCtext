import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Counter {
    private void count(String var){
        Pattern p1 = Pattern.compile("[a-zA-Z]");
        Pattern p2 = Pattern.compile("\\s");
        Pattern p3 = Pattern.compile("\\d");
        Matcher letter_num = p1.matcher(var);
        Matcher space_num = p2.matcher(var);
        Matcher number_num = p3.matcher(var);
        int letter_count = 0;
        int space_count = 0;
        int number_count = 0;
        while(letter_num.find()) {
            letter_count++;

        }
        while(space_num.find()) {
            space_count++;

        }
        while(number_num.find()) {
            number_count++;

        }
        int effect_num = letter_count + space_count + number_count;
        System.out.println("英文个数 " + letter_count);
        System.out.println("空格个数 " + space_count);
        System.out.println("数字个数 " + number_count);
        System.out.println("其他个数 " + (var.length() - effect_num));
    }

    public static void main(String[] args) {
        do {
            Scanner input = new Scanner(System.in);
            System.out.println("输入一段字符串：");
            String a = input.nextLine();
            Counter c = new Counter();
            c.count(a);
        }while(true);
    }

}
