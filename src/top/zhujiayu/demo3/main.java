package top.zhujiayu.demo3;

/**
 * @auther zjy
 * @date 2020/7/2
 **/

public class main {

    public static void main(String[] args) {

        new Thread(() -> System.out.println("run")).start();

        System.out.println("----------------");

        Company company = new Company(new Bride());
        company.happyMarry();

    }
}

interface Marry {

    void happyMarry();
}

class Bride implements Marry {

    @Override
    public void happyMarry() {
        System.out.println("做新娘");
    }
}

class Company implements Marry {

    private Bride bride;

    public Company(Bride marry) {
        this.bride = marry;
    }

    @Override
    public void happyMarry() {
        System.out.println("我是婚庆公司");
        bride.happyMarry();
    }
}
