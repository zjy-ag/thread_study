package top.zhujiayu.productorAndConsumer;

/**
 * @auther zjy
 * @date 2020/7/12
 **/

//信号灯法
public class Test2 {

    public static void main(String[] args) {

        Flag flag = new Flag();

        new Thread(new Productor2(flag)).start();
        new Thread(new Consumer2(flag)).start();
    }
}

class Consumer2 implements Runnable{

    Flag flag;

    public Consumer2(Flag flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                flag.consumerDo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Productor2 implements Runnable{

    Flag flag;

    public Productor2(Flag flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                flag.productorDo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Flag {

    boolean flag = false;

    public synchronized void productorDo() throws InterruptedException {
        if (flag == false) {
            wait();
        }
        System.out.println("productor");
        flag = false;
        this.notifyAll();
    }

    public synchronized void consumerDo() throws InterruptedException {
        if (flag == true) {
            wait();
        }
        System.out.println("consumer");
        flag = true;
        this.notifyAll();
    }
}
