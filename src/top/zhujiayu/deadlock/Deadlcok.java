package top.zhujiayu.deadlock;

/**
 * @auther zjy
 * @date 2020/7/9
 **/

public class Deadlcok {

    public static void main(String[] args) {

        new Thread(new eat(1), "zhangdan").start();
        new Thread(new eat(0), "lisi").start();

    }
}

class Icecream {

}

class PhotatoChips {

}

class eat implements Runnable {

    //用static保证资源只有一份
    static Icecream icecream = new Icecream();
    static PhotatoChips photatoChips = new PhotatoChips();

    int choice;

    public eat(int choice) {
        this.choice = choice;
    }

    @Override
    public void run() {
        if (choice == 0) {
            synchronized (icecream) {
                System.out.println(Thread.currentThread().getName() + "lock I");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (photatoChips) {
                System.out.println(Thread.currentThread().getName() + "lock P");
            }
        } else {
            synchronized (photatoChips) {
                System.out.println(Thread.currentThread().getName() + "lock P");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (icecream) {
                System.out.println(Thread.currentThread().getName() + "lock I");
            }
        }
    }

    //锁里加锁，此方式死锁，
    /*@Override
    public void run() {
        if (choice == 0) {
            synchronized (icecream) {
                System.out.println(Thread.currentThread().getName() + "lock I");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (photatoChips) {
                    System.out.println(Thread.currentThread().getName() + "lock P");
                }
            }
        } else {
            synchronized (photatoChips) {
                System.out.println(Thread.currentThread().getName() + "lock P");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (icecream) {
                    System.out.println(Thread.currentThread().getName() + "lock I");
                }
            }
        }
    }*/

}
