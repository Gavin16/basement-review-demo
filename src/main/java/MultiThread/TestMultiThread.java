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
    }

    /**
     * System 类中静态方式使用
     * System.out
     * System.currentTimeMillis()
     * System.lineSeparator()
     * System.nanoTime()
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

    }




}
