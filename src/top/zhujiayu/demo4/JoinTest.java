package top.zhujiayu.demo4;

/**
 * @auther zjy
 * @date 2020/7/4
 **/

public class JoinTest implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("join " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        JoinTest joinTest = new JoinTest();
        Thread thread = new Thread(joinTest);
        thread.start();

        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                thread.join();//先执行start才能执行join
            }
            System.out.println(i);
        }
    }
}
