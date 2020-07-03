package top.zhujiayu.demo4;

import javafx.scene.input.DataFormat;
import top.zhujiayu.demo2.testRunnable2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @auther zjy
 * @date 2020/7/3
 **/

public class SleepTest {

    public static void main(String[] args) throws InterruptedException {

        Date date;

        while (true) {
            date = new Date(System.currentTimeMillis());
            System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
            Thread.sleep(1000);
        }

    }

}
