package locks;

/**
 * @Date 2019/10/28
 * @Author YF
 * @Description
 */
public class SaleTiketDemo2 {
    public static void main(String[] args) {

        Quantity quantity = new Quantity();

        new Thread(() ->{ for (int i = 0; i < 10 ; i++) {
            try {
                quantity.add();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        },"生产者").start();

        new Thread(() ->{ for (int i = 0; i < 10 ; i++) {
            try {
                quantity.reduce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        },"消费者").start();

    }
}

class Quantity{
    private int num = 0;

    public synchronized void add() throws InterruptedException {
            if(num != 0) {
                this.wait();
            }
            num++;
            System.out.println(Thread.currentThread().getName()+"生产了一个蛋糕"+"目前总共有："+num+"个!");
            this.notifyAll();

    }
    public synchronized void reduce() throws InterruptedException {
            if (num == 0){
                this.wait();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+"购买了1个蛋糕，"+"还剩下"+num+"个！");
            this.notifyAll();
    }
}
