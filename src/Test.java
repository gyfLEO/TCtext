import java.io.File;
import java.io.IOException;

class RunnableTest implements Runnable{
    private Thread t;
    private String threadName;

    RunnableTest(String var){
        threadName = var;
        System.out.println("创建了一个线程" + threadName);
    }

    @Override
    public void run() {
        System.out.println("执行run方法：" + threadName);
            try{
                for (int i=0; i<4; i++) {
                    System.out.println("threadname" + threadName + i);
                    Thread.sleep(4000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Thread " +  threadName + " interrupted.");
            }
        System.out.println("Thread" + threadName + "exiting");
    }

    public void start() {
        System.out.println("执行start方法：" + threadName);
        if(t==null){
            t = new Thread(this, threadName);
            t.start();
        }
    }
}

class ThreadTest extends Thread{
    private int ticket = 10;
    @Override
    public void run(){
        for(int i=0; i<10;i++){
            synchronized (this){
                if(this.ticket>0){
                    try {
                        Thread.sleep(5000);
                        System.out.println(Thread.currentThread().getName()+"卖票---->"+(this.ticket--));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

public class Test{
    public static void main(String[] args) throws IOException {
//        RunnableTest run = new RunnableTest("one");
//        run.start();
//        new RunnableTest("one").start();
//        RunnableTest run1 = new RunnableTest("two");
//        run1.start();
        ThreadTest t1 = new ThreadTest();
        new Thread(t1,"线程1").start();
        new Thread(t1,"线程2").start();

    }
}