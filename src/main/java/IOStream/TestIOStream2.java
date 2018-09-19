package IOStream;

import domain.PersonDto;

import java.io.*;
import java.net.URL;
import java.util.Date;

/**
 * @Title: ${FILE_NAME}
 * @Package: IOStream
 * @Description:
 * @author: Minsky
 * @date: 2018/9/17 22:33
 */
public class TestIOStream2 {

    public static void main(String[]args)throws IOException{
//        TestStream();
//        test01();
//        test02();
        testObjectInputStream();
        testObjectOutputStream();
    }

    /**
     * 字符流
     *  StringReader 从一个字符串获取输入
     *  FileReader 从一个文件中获取输入流
     */
    private static void TestStream(){
        URL url = TestIOStream.class.getClassLoader().getResource("iotest2.txt");

        String str ="StringRead test!";
        StringReader sr = new StringReader(str);

        char[] recArr = new char[1024];
        int len = -1;
        try {
            while((len = sr.read(recArr))!=-1){
                System.out.println(new String(recArr,0,len));
            }

            sr.close();

            // 读取文件
            File f = new File(url.getFile());
            FileReader fr = new FileReader(f);

            // 直接使用 InputStreamReader子类读取文件
//            while((len = fr.read(recArr))!=-1){
//                System.out.println(new String(recArr,0,len));
//            }

            // 使用缓冲流 BufferedReader
            BufferedReader br = new BufferedReader(fr);
            String read ;
            while(null != (read = (br.readLine()))){
                System.out.println(read);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 执行每次读写1024的节点流的时间消耗
     */
    private static void test01() throws IOException{
        URL url = TestIOStream.class.getClassLoader().getResource("spring-framework-reference.pdf");
        File fr = new File(url.getFile());
        File fw = new File("D:\\spring-copy1.pdf");
        if (!fw.exists()){
            fw.createNewFile();
        }

        long startTm = System.currentTimeMillis();
        try (InputStream in = new FileInputStream(fr);
                OutputStream out = new FileOutputStream(fw)){

            byte[] bs = new byte[1024];
            int len = -1;

            while((len = (in.read(bs)))!=-1){
                out.write(bs,0,len);
            }

            long endTm = System.currentTimeMillis();
            System.out.println("test01 time Cost is:"+(endTm - startTm)+"ms");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**
     * 使用缓冲流读写文件，打印时间消耗
     */
    private static void test02()throws IOException{
        URL url = TestIOStream.class.getClassLoader().getResource("spring-framework-reference.pdf");
        File fr = new File(url.getFile());
        File fw = new File("D:\\spring-copy1.pdf");

        if (!fw.exists()){
            fw.createNewFile();
        }

        long startTm = System.currentTimeMillis();
        try (FileInputStream fi = new FileInputStream(fr);
             BufferedInputStream bis = new BufferedInputStream(fi);
             FileOutputStream fos = new FileOutputStream(fw);
             BufferedOutputStream bos = new BufferedOutputStream(fos)){

//            FileOutputStream fos1 = new FileOutputStream("");

            byte[] bs = new byte[1024];
            int len = -1;
            while((len=(bis.read(bs)))!=-1){
                bos.write(bs,0,len);
            }

            System.out.println("test02 time Cost is:"+(System.currentTimeMillis() - startTm)+"ms");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     *  ObjectOutputStream 和 ObejctInputStream
     *  对象的序列化 和 反序列化
     */
    private static void testObjectInputStream()throws IOException{
        String url = "D:\\temp\\person.dat";
        File f = new File(url);

        if(!f.exists()){
            f.createNewFile();
        }

        try(FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            PersonDto person = new PersonDto("zhsan",new Date(),"27");
            // 新建的对象序列化到本地
            oos.writeObject(person);

            // 从本地读取
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            // 读取出来的对象需要做强制类型转换
            PersonDto p = (PersonDto)ois.readObject();

            System.out.println(String.valueOf(p));
            fos.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * transient 属性不能序列化
     * 静态属性不能序列化
     * @throws IOException
     */
    private static void testObjectOutputStream()throws IOException{
        String url = "D:\\temp\\person.dat";
        File f = new File(url);

        if(!f.exists()){
            f.createNewFile();
        }

        // 读取序列化后的结果
        try (FileOutputStream fos = new FileOutputStream(f);
             ObjectOutputStream oos = new ObjectOutputStream(fos);
             FileInputStream fis = new FileInputStream(f);
             ObjectInputStream ois = new ObjectInputStream(fis)){

            PersonDto person = new PersonDto("刘大腕",new Date(),"22");
            oos.writeObject(person);

            PersonDto.setHeight("182");

            PersonDto pp = (PersonDto)ois.readObject();
            System.out.println(pp.getHeight());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
