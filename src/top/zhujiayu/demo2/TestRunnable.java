package top.zhujiayu.demo2;

/**
 * @auther zjy
 * @date 2020/7/2
 **/

public class TestRunnable implements Runnable {

    long minPrime;

    TestRunnable(long minPrime) {
        this.minPrime = minPrime;
    }

    public void run() {
        for (int i = 0; i < minPrime; i++) {
            System.out.println("thread" + i);
        }
    }
}
