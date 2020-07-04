package top.zhujiayu.demo4;

/**
 * @auther zjy
 * @date 2020/7/4
 **/

public class YielsTest {

    public static void main(String[] args) {

        MyYield myYield = new MyYield();

        new Thread(myYield, "a").start();
        new Thread(myYield, "b").start();
    }
}

//礼让不一定成功，看cpu心情
class MyYield implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":before");
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + ":after");
    }

}
