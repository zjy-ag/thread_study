package top.zhujiayu.demo5;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther zjy
 * @date 2020/7/8
 **/

public class UnsageList {
    public static void main(String[] args) throws InterruptedException {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                list.add(Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        System.out.println(list.size());
    }
}
