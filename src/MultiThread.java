import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

class MyRunnable1 implements Runnable {
    private  long startNum;
    private long endNum;
    private int threadNum;
    public static long totalTime;

    MyRunnable1(long num1, long num2, int name) {
        this.startNum = num1;
        this.endNum = num2;
        this.threadNum = name;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        Prime1 p = new Prime1(startNum, endNum, threadNum);
        try {
            p.PrimeNumbers();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("写入成功！");
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");
        totalTime += (endTime - startTime);
        System.out.println("total time is:" + totalTime + "ms");
    }
}

class Prime1 {
    private long start;
    private long begin;
    private int threadNum;


    public Prime1(long a, long b, int c){
        this.start = a;
        this.begin = b;
        this.threadNum = c;
    }


    public void PrimeNumbers() throws IOException {
        StringBuffer str = new StringBuffer("");
        for(; start<=begin; start++){
            if(isPrimeNumber(start)){
                str.append(start);
                str.append(" ");
            }
        }
        FileIO1.createFile(threadNum);
        FileIO1.writeFile(str, threadNum);
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

class FileIO1 {

//    private static final File FILE_NAME = new File("D:/zuoye/singleThread.txt");
    public static void createFile(int threadNum){

        File FILE_NAME = new File("D:/zuoye/multiThread_" + threadNum + ".txt");
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

    public static void writeFile(StringBuffer fileContent, int threadNum) throws IOException {
        File FILE_NAME = new File("D:/zuoye/multiThread_" + threadNum + ".txt");
        FileOutputStream fop = new FileOutputStream(FILE_NAME);
        OutputStreamWriter writer = new OutputStreamWriter(fop, "UTF-8");
        writer.append(fileContent);
        writer.close();
        fop.close();
    }
}

public class MultiThread {
    public static void main(String[] args) {
        System.out.println("多线程作业");
        Scanner input = new Scanner(System.in);
        System.out.println("请输入一个较大的整数，比如5000万或更大：");
        long num = input.nextLong();
        System.out.println("输入要工作的线程数：");
        long threadNum = input.nextLong();
        long startNum = 1;
        long avg = num/5;
        long endNum = avg;
        for (int i=0; i<threadNum; i++) {
            Thread thread = new Thread(new MyRunnable1(startNum, endNum, i+1));
            thread.start();
            startNum = endNum + 1;
            endNum += avg;
        }
    }
}
