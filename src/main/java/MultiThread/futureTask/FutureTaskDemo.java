package MultiThread.futureTask;

import java.util.concurrent.*;

public class FutureTaskDemo {

    public static void main(String[]args) throws ExecutionException, InterruptedException {
        //
        FutureTask<String> ft1 = new FutureTask<String>(new Task1());
        FutureTask<String> ft2 = new FutureTask<String>(new Task2());
        FutureTask<String> ft3 = new FutureTask<String>(new Task3());

        ExecutorService es = Executors.newCachedThreadPool();
        // 这里FutureTask 实例可以有三种调用方式
        // 第一种调用 是将FutureTask 视为一个Runnable对象,可以将FutureTask 提交到线程池
        // 第二种调用 future实现了Runnable接口中本身可以在被调用线程中执行run方法,这样就相当于是同步任务的执行
        // 第三种调用 使用了ThreadPoolExecutor 中的execute方法直接调用,调用方式也是通过线程池中的工作者线程完成的
        es.submit(ft1);
        ft2.run();
        es.execute(ft3);

        Thread.sleep(1000);
        String s1 = ft1.get();
        String s2 = ft2.get();
        String s3 = ft3.get();


        es.shutdownNow();
        System.out.println("s1："+s1);
        System.out.println("s2："+s2);
        System.out.println("s3："+s3);
    }


    static class Task1 implements Callable{

        @Override
        public Object call() throws Exception {
            System.out.println("Thread-1:"+Thread.currentThread().getName());
            return "Task1--calling";
        }
    }


    static class Task2 implements Callable{

        @Override
        public Object call() throws Exception {
            System.out.println("Thread-2:"+Thread.currentThread().getName());
            return  "Task2--calling";
        }
    }

    static class Task3 implements Callable{
        @Override
        public Object call() throws Exception {
            System.out.println("Thread-3:"+Thread.currentThread().getName());
            return  "Task3--calling";
        }
    }
}
