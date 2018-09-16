package IOStream;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @Title: ${FILE_NAME}
 * @Package: IOStream
 * @Description:
 * @author: Eta
 * @date: 2018/9/13 15:38
 */
public class TestIOStream {

    public static void main(String[]args){
//        testIOStream();
//        testIOStream1();
        testCharIOStream();
    }

    /** 字节流 输入输出流
     *  InputStream 与 OutPutStream 继承关系,
     *
     *  InputStream ---- SequenceInputStream  顺序输入流
     *               |
     *               --- FileInputStream 文件输入流
     *               |
     *               --- ByteArrayInputSteam 字节数组输入流
     *               |
     *               --- StringBufferInputStream 字符串缓冲输入流
     *               |
     *               --- PipedInputStream 管道输入流
     *
     *  OutputStream 继承关系类似
     */
    private static void testIOStream(){
        // 读取resource 路径下的文件, FileInputStream
        String filePath = "iotest.txt";
        URL url = TestIOStream.class.getClassLoader().getResource(filePath);
        try {
            // File 用来文件和路径抽象化  使文件的读写从操作系统独立出来
            File f = new File(url.getFile());
            showFile(f);
            FileInputStream fin = new FileInputStream(f);

            byte[] filerd = readStream(fin);
            String text =  new String(filerd);

            System.out.println(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * ByteArrayInputStream的使用
     *
     * ByteArrayInputStream 通过构造方法从 byte数组中获取数据构造一个输入流
     *      类似的ByteArrayInputStream 也是通过几个read方法将数据写入到buffer 数组中
     *      如果所有数据都在byte 数组从可以通过这种方式构造输入流
     */
    private static void testIOStream1(){
        // ByteArrayInputStream
        // 数据来源仍然从文件中获取
        String filePath = "iotest1.txt";
        URL url = TestIOStream.class.getClassLoader().getResource(filePath);
        showURL(url);
        File f  = new File(url.getFile());

        // 使用try - with - resource 语句 自动关闭输入流
        try{
            FileInputStream fin = new FileInputStream(f);
            // FileInputStream 中提取byte数组
            // 取大一点 一次性保存所有从文件中读取的
            byte[]buffer1 = new byte[10240];
            byte[]buffer2 = new byte[10240];

            ByteArrayInputStream bis = null;
            int len = -1;
            int pos = 0;
            while((len = fin.read(buffer1))!=-1){
                // 读取出来的数据转存到 ByteArrayInputStream
                bis = new ByteArrayInputStream(buffer1);
                // 从 ByteArrayInputStream中读取数据到 buffer2 中
                bis.read(buffer2,pos,len);
                pos += len;
            }
            String buff2str = new String(buffer2);
            System.out.println("buffer2:"+buff2str);
            // 读取ByteArrayInputStream 后将字节数组的数据再写出
            bis.close();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }



    private static void showURL(URL url){
        System.out.println("File:"+url.getFile());
        System.out.println("Path:"+url.getPath());
        System.out.println("authority:"+url.getAuthority());
        System.out.println("host:"+url.getHost());
        System.out.println("port:"+url.getPort());
        System.out.println("++++++++++++++++++++");
    }   

    private static void showFile(File f) {
        System.out.println("name:"+f.getName());
        System.out.println("parent:"+f.getParent());
        System.out.println("path:"+f.getPath());
        System.out.println("absolutePath:"+f.getAbsolutePath());
        System.out.println("=========================");
    }


    private static byte[] readStream(InputStream ins) throws IOException{

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len ;

        while((len = ins.read(buffer))!= -1){
            // 将读取出来的buffer中长度为len的字节 写入OutputStream
            bos.write(buffer,0,len);
        }

        bos.close();
        ins.close();
        return bos.toByteArray();
    }



    /**
     * 字符流 IO Stream
     *  Reader ----- PipedReader
     *           |
     *           --- CharArrayReader
     *           |
     *           ---  StringReader
     *           |
     *           ---  InputStreamReader
     *           |
     *           ---  BufferedReader
     *           |
     *           ---  FilterReader
     *
     *  按流的方向分为：输入流和输出流
     *  按流的数据单位不同分为：字节流和字符流
     *  按流的功能不同分为:节点流和处理流
     *
     *
     */
    private static void testCharIOStream(){
        // InputStreamReader
        URL url = TestIOStream.class.getClassLoader().getResource("iotest2.txt");
        File f = new File(url.getPath());
        try {
            FileInputStream fis = new FileInputStream(f);

            // 从InputStreamReader中读取字符
            InputStreamReader isr = new InputStreamReader(fis);
            // 使用 缓冲流来对
            BufferedReader bd = new BufferedReader(isr);
            String str = "";

            while(null !=(str = bd.readLine())){
                System.out.println(str);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();

        }
    }


}
