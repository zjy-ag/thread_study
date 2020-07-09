package top.zhujiayu.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @auther zjy
 * @date 2020/7/9
 **/

public class lock {

    public static void main(String[] args) {

        testLock testLock = new testLock();

        new Thread(testLock).start();
        new Thread(testLock).start();
        new Thread(testLock).start();

    }
}

class testLock implements Runnable {

    int cnt = 10;

    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {

        while (true) {
            try {
                lock.lock();
                if (cnt > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(cnt--);
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }

}
