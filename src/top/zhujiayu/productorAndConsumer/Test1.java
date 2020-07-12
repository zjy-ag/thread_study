package top.zhujiayu.productorAndConsumer;

import java.net.Inet4Address;

/**
 * @auther zjy
 * @date 2020/7/10
 **/

//管程法：利用缓冲区
public class Test1 {

    public static void main(String[] args) {

        Buffer buffer = new Buffer();

        new Thread(new Productor(buffer)).start();
        new Thread(new Consumer(buffer)).start();
    }

}

class Productor implements Runnable {

    Buffer buffer;

    public Productor(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i < 101; i++) {
            try {
                buffer.push();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}

class Consumer implements Runnable {

    Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i < 101; i++) {
            try {
                buffer.pop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}


class Buffer {

    int size = 10;
    int cnt = 0;

    public synchronized void push() throws InterruptedException {
        if (cnt == size) {
            this.wait();
        }

        cnt++;
        System.out.println("pro" + cnt);
        this.notifyAll();
    }

    public synchronized void pop() throws InterruptedException {
        if (cnt == 0) {
            this.wait();
        }

        System.out.println("cun" + cnt);
        cnt--;
        this.notifyAll();
    }

}
