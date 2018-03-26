import java.io.*;
import java.util.Scanner;

class MyRunnable implements Runnable {
    private long N;

    MyRunnable(long num) {
        this.N = num;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        Primes p = new Primes(N);
        try {
            p.PrimeNumbers();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("写入成功！");
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
    }
}

class Primes {
    private long begin;
    private long end;

    public Primes(long b){
        this.begin = 1;
        this.end = b;
    }

    public void PrimeNumbers() throws IOException {
        StringBuffer str = new StringBuffer("");
        for(; begin<=end; begin++){
            if(isPrimeNumber(begin)){
                str.append(begin);
                str.append(" ");
            }
        }
        FileIO.createFile();
        FileIO.writeFile(str);
    }

    public boolean isPrimeNumber(long num){
        if(num == 2) return true;
        if(num < 2 || num % 2 == 0) return false;
        for(int i=3; i<=Math.sqrt(num); i+=2){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
}

class FileIO {
    private static final File FILE_NAME = new File("D:/zuoye/singleThread.txt");

    public static void createFile(){
        if(!FILE_NAME.exists()){
            try {
                FILE_NAME.createNewFile();
                System.out.println("创建文件成功！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("文件存在！");
        }
    }

    public static void writeFile(StringBuffer fileContent) throws IOException {
        FileOutputStream fop = new FileOutputStream(FILE_NAME);
        OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
        writer.append(fileContent);
        writer.close();
        fop.close();
    }
}

public class SingleThread {
    public static void main(String[] args) {
        System.out.println("单线程作业");
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个较大的整数，比如5000万或更大");
        long num = input.nextLong();
        Thread thread = new Thread(new MyRunnable(num));
        thread.start();
    }
}


