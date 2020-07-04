package top.zhujiayu.demo4;

import java.sql.SQLOutput;

/**
 * @auther zjy
 * @date 2020/7/4
 **/

public class PriorityTest{

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getPriority());

        MyPriority myPriority = new MyPriority();

        Thread thread1 = new Thread(myPriority, "a");
        thread1.setPriority(Thread.MAX_PRIORITY);

        Thread thread2 = new Thread(myPriority, "b");
        thread2.setPriority(9);

        Thread thread3 = new Thread(myPriority, "c");
        thread3.setPriority(2);

        Thread thread4 = new Thread(myPriority, "d");
        thread4.setPriority(Thread.MIN_PRIORITY);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();


    }

    static class MyPriority implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().getPriority());
        }
    }
}
