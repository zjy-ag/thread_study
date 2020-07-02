package top.zhujiayu.demo1;

/**
 * @auther zjy
 * @date 2020/6/22
 **/

public class TestThread1 extends Thread{

    private long minPrime;

    public TestThread1(long minPrime) {
        this.minPrime = minPrime;
    }

    @Override
    public void run() {
        for (int i = 0; i < minPrime; i++) {
            System.out.println("thread" + i);
        }
    }
}
