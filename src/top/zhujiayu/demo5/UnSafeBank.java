package top.zhujiayu.demo5;

/**
 * @auther zjy
 * @date 2020/7/8
 **/

public class UnSafeBank {

    public static void main(String[] args) {

        Account account = new Account(600);

        WithdrawMoney a = new WithdrawMoney(account, 500);
        WithdrawMoney b = new WithdrawMoney(account, 300);

        new Thread(a, "zhangsan").start();
        new Thread(b, "lisi").start();

    }
}

class Account {

    protected int totle;

    public Account(int totle) {
        this.totle = totle;
    }
}

class WithdrawMoney implements Runnable {

    Account account;
    int money;

    public WithdrawMoney(Account account, int money) {
        this.account = account;
        this.money = money;
    }

    @Override
    public void run() {
        synchronized (account) {//更改的是账户，所以要锁账户
            if (account.totle - money < 0) {
                System.out.println("钱不够");
                return;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            account.totle -= money;

            System.out.println(Thread.currentThread().getName() + ", 余额：" + account.totle);
        }
    }
}
