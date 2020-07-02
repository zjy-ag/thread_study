package top.zhujiayu.demo1;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * @auther zjy
 * @date 2020/6/27
 **/


public class TestThread2 extends Thread{

    private String url;
    private String name;

    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownLoader webDownLoader = new WebDownLoader();
        webDownLoader.downloader(url, name);
        System.out.println("下载了" + name);
    }

    public static void main(String[] args) {
        TestThread2 testThread1 = new TestThread2("https://dss3.baidu.com/-rVXeDTa2gU2pMbgoY3K/it/u=384379748,2163410796&fm=202&mola=new&crop=v1", "1.jpg");
        TestThread2 testThread2 = new TestThread2("https://dss1.bdstatic.com/6OF1bjeh1BF3odCf/it/u=2916075195,2351126599&fm=74&app=80&f=JPEG&size=f121,90?sec=1880279984&t=4929bff12b5b28e7b81224f0103a6a81", "2.jpg");
        TestThread2 testThread3 = new TestThread2("https://dss3.baidu.com/-rVXeDTa2gU2pMbgoY3K/it/u=1594112360,1514463091&fm=202&src=608&crossm&mola=new&crop=v1", "3.jpg");

        testThread1.start();
        testThread2.start();
        testThread3.start();
    }
}

class WebDownLoader {

    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("异常");
        }
    }
}

