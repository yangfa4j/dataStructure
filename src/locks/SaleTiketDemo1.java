package locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Date 2019/10/24
 * @Author YF
 * @Description
 */
public class SaleTiketDemo1 {
    /**
     * 三个售票员 卖出 30 张票
     * @param args
     */
    public static void main(String[] args) {
        Tiket tiket = new Tiket();
       new Thread(() -> { for (int i = 1; i <= 40; i++) tiket.sale();  },"AAA").start();
       new Thread(() -> { for (int i = 1; i <= 40; i++) tiket.sale();  },"BBB").start();
       new Thread(() -> { for (int i = 1; i <= 40; i++) tiket.sale();  },"CCC").start();
       

    }
}

class Tiket{
    private int number = 30;
    private Lock lock = new ReentrantLock();


    public void sale(){
        lock.lock();
      try {
          if (number > 0){
              System.out.println(Thread.currentThread().getName()+"\t卖出第："+(number--)+"\t 还剩下："+number);
          }
      }catch (Exception e){
          e.printStackTrace();
      }finally {
          lock.unlock();
      }
    }
}
