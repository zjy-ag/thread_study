package top.zhujiayu.demo5;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.tools.example.debug.tty.TTY;

/**
 * @auther zjy
 * @date 2020/7/8
 **/


public class UnsafeBuyTicket {

    public static void main(String[] args) {

        BuyTicket buyTicket = new BuyTicket();

        new Thread(buyTicket, "zhangsan").start();
        new Thread(buyTicket, "lisi").start();
        new Thread(buyTicket, "lisi").start();

    }
}

class BuyTicket implements Runnable {

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

    public void buy() throws InterruptedException {
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
