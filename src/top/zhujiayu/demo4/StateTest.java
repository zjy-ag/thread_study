package top.zhujiayu.demo4;

/**
 * @auther zjy
 * @date 2020/7/4
 **/

public class StateTest {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread.State state = thread.getState();
        System.out.println(state);

        thread.start();
        System.out.println(thread.getState());

        while (state != Thread.State.TERMINATED) {
            state = thread.getState();
            System.out.println(state);
            Thread.sleep(1000);
        }
    }
}
