package top.zhujiayu.demo5;

/**
 * @auther zjy
 * @date 2020/7/8
 **/

public class SafeByTicket {

    public static void main(String[] args) {
        SafeBuyTicket buyTicket = new SafeBuyTicket();

        new Thread(buyTicket, "zhangsan").start();
        new Thread(buyTicket, "lisi").start();
        new Thread(buyTicket, "lisi").start();

    }
}


class SafeBuyTicket implements Runnable {

    private boolean flag = true;
    private int cnt = 10;

    @Override
    public void run() {
        while (flag) {
            try {
                buy();
            } catch (InterruptedException e) {

            }
        }
    }

    //只需要在修改操作的代码块增加synchronized关键字即可加锁
    //在方法上加锁就是所这个方法的class，synchronized(this)
    public synchronized void buy() throws InterruptedException {
        if (cnt <= 0) {
            flag = false;
            return;
        }
        cnt--;
        System.out.println(
                Thread.currentThread().getName() + "买到了倒数第" + cnt + "张票");
        Thread.sleep(100);
    }
}
