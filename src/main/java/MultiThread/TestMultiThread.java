package MultiThread;

import java.util.Map;
import java.util.Properties;

/**
 * @Title: ${FILE_NAME}
 * @Package: MultiThread
 * @Description:
 * @author: Eta
 * @date: 2018/9/13 15:45
 */
public class TestMultiThread {
    public static void main(String[]args){
//        testSystem();
//        TheadPriorityTest();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.printf("2.Welcome! This is %s.%n", Thread.currentThread());
            }
        });

        System.out.println(Thread.currentThread().getPriority());

        thread.setName("Thread-Test");
        thread.start();
        thread.run();
        System.out.printf("1.Welcome! This is %s.%n", Thread.currentThread());

    }

    /**
     * System 类中静态方式使用
     * System.out
     * System.currentTimeMillis()
     * System.lineSeparator()
     * System.nanoTime()
     * System.arraycopy()  数组拷贝
     * System.getProperties() 获取所有property属性
     */
    private static void testSystem(){
        Map<String,String> envMap   = System.getenv();

        for(Map.Entry<String,String> entry : envMap.entrySet()){
            System.out.println(entry.getKey()+":"+entry.getValue());
        }

        System.out.println("===================================");
        Properties properties = System.getProperties();

        System.out.println(properties.getProperty("java.library.path"));

        System.out.println(System.nanoTime());

        // System中获取系统换行符
        String lineSperator = System.lineSeparator();

        System.out.println(Thread.currentThread().getState());
    }


    private static void TheadPriorityTest(){
        Thread thread = Thread.currentThread();
        thread.setPriority(Thread.MIN_PRIORITY);
        System.out.println("hello");
        System.out.println(thread.getPriority());
        System.out.println(Thread.MAX_PRIORITY);
        System.out.println(thread.getUncaughtExceptionHandler());
        thread.start();
    }



}
