import java.util.Scanner;

public class NumCounter {
    public int convert(String var){
        return Integer.parseInt(var);
    }

    private void count(String var){
//        List<Integer> list = new ArrayList();
        String[] a = var.split(",");
        int[] arr = new int[a.length];
        int i = 0;
        for (String str:a) {
            arr[i] = convert(str);
            i++;
        }
        int sum=0;
        int max=arr[0];
        int min=arr[0];
        for (int n=0;n<arr.length;n++){
            sum+=arr[n];
            if(arr[n] > max){
                max = arr[n];
            }
            if(arr[n] < min){
                min = arr[n];
            }
        }
        if(max<10){
            System.out.println(max);
            System.out.println(min);
            System.out.println(sum);
        }else if(max>100){
            System.out.println(sum);
            System.out.println(min);
            System.out.println(max);
        }else {
            System.out.println(min);
            System.out.println(max);
            System.out.println(sum);
        }
    }

    public static void main(String[] args) {
        do{
            Scanner input = new Scanner(System.in);
            System.out.println("输入任意数字，并且这些数字以“，”分割:");
            String str = input.nextLine();
            NumCounter n = new NumCounter();
            n.count(str);
        }while(true);
    }
}
