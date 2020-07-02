package top.zhujiayu.demo1;

/**
 * @auther zjy
 * @date 2020/6/22
 **/

public class main {

    public static void main(String[] args) {

        TestThread1 testThread1 = new TestThread1(100);
        //testThread1.run();
        testThread1.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("main" + i);
        }
    }
}
