import java.util.Scanner;

public class Prime {
    private int a;
    private int b;

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public Prime(){}

//    public Prime(int num1, int num2){
//        this.a = num1;
//        this.b = num2;
//    }

    private void PrimeNumbers(){
        System.out.println("["+ a + "," + b +"]的素数有：");
        for(; a<=b; a++){
            if(isPrimeNumber(a)){
                System.out.print(a + " ");
            }
        }
    }

    public boolean isPrimeNumber(int num){
        if(num == 2) return true;
        if(num < 2 || num % 2 == 0) return false;
        for(int i=3; i<=Math.sqrt(num); i+=2){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        do {
            Scanner x = new Scanner(System.in);
            Scanner y = new Scanner(System.in);
            System.out.println();
            System.out.println("请依次从小到大输入两个非负整数");
            int a = x.nextInt();
            int b = y.nextInt();
            System.out.println("您输入的是["+ a + "," + b +"]");
            if(a<b && a>0 && b>0) {
                Prime p = new Prime();
                p.setA(a);
                p.setB(b);
                p.PrimeNumbers();
            }else{
                System.out.println("请重新输入~");
            }
        }while(true);
    }
}
