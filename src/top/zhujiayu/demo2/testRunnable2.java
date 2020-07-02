package top.zhujiayu.demo2;

/**
 * @auther zjy
 * @date 2020/7/2
 **/

public class testRunnable2 implements Runnable{

    private int i = 10;

    @Override
    public void run() {
        while (i > 0) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":" + i--);
        }
    }

    public static void main(String[] args) {

        testRunnable2 testRunnable2 = new testRunnable2();

        new Thread(testRunnable2, "zhangsan").start();
        new Thread(testRunnable2, "lisi").start();
        new Thread(testRunnable2, "wangwu").start();
    }
}
