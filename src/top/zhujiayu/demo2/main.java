package top.zhujiayu.demo2;

/**
 * @auther zjy
 * @date 2020/7/2
 **/

public class main {

    public static void main(String[] args) {

        long minPrime = 100;

        TestRunnable testRunnable = new TestRunnable(minPrime);
        new Thread(testRunnable).start();

        for (int i = 0; i < minPrime; i++) {
            System.out.println("main" + i);
        }

        System.out.println("--------------");

    }
}
