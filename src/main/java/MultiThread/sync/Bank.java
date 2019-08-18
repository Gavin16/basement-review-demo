package MultiThread.sync;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {

    private final double[] accounts;

    private Condition sufficientFund;

    private ReentrantLock rl = new ReentrantLock();

    private static int pFlag = 1;

    public Bank(int num,double initBalance) {
        this.accounts = new double[num];
        this.sufficientFund = rl.newCondition();
        Arrays.fill(accounts,initBalance);

    }

    public void transfer(int from, int to, double amount){
        rl.lock();
        try{
            // 如果当前情况不满足转账的条件, 可以让await 进入等待状态,等其他线程先执行
            // 直到满足条件了,再继续往下执行
            // 那么当前的可重入锁是否已经释放了呢?  必须释放 不然所有线程都无法执行方法
            while (accounts[from] < amount)
                sufficientFund.await();

            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf("%10.2f from %d to %d.",amount,from,to);
            accounts[to] += amount;
            System.out.printf(" Total balance : %10.2f%n",getTotalBalance());
            // signalAll 不会直接激活线程,而是通知因为等待而阻塞的线程;之后它们还是需要竞争去获得对象的访问
            sufficientFund.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            rl.unlock();
        }
    }

    private double getTotalBalance() {
        rl.lock();
        try{
            double sum = 0;
            for(double amount : accounts){
                sum += amount;
            }
            return sum;
        }finally {
            rl.unlock();
        }

    }

}
