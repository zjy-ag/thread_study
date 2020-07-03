package top.zhujiayu.demo4;

import sun.jvm.hotspot.runtime.VM;

/**
 * @auther zjy
 * @date 2020/7/3
 **/

public class StopTest implements Runnable {

    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            System.out.println("线程开始！！！");
        }
        System.out.println("线程结束！！！");
    }


    public void stop() {
        flag = false;
    }


    public static void main(String[] args) {

        StopTest stopTest = new StopTest();
        new Thread(stopTest).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
            if (i == 900) {
                stopTest.stop();
            }
        }
    }
}

