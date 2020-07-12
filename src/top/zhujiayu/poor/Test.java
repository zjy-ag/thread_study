package top.zhujiayu.poor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @auther zjy
 * @date 2020/7/12
 **/

public class Test {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute(new thread());
        executorService.execute(new thread());
        executorService.execute(new thread());
        executorService.execute(new thread());

        executorService.shutdown();
    }
}

class thread implements Runnable {
    @Override
    public void run() {
        System.out.println("run");
    }
}
