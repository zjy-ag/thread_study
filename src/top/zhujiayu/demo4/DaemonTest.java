package top.zhujiayu.demo4;

/**
 * @auther zjy
 * @date 2020/7/5
 **/

public class DaemonTest {

    public static void main(String[] args) {

        Thread me = new Thread( () -> {
            while (true) {
                System.out.println("waiting！");
            }
        });

        Thread you = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("day" + i);
            }
        });

        me.setDaemon(true);//默认为false，非守护线程
        me.start();
        you.start();
    }
}
