package BIOTest.client;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[]args){
        int port = 8087;
        Socket client = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            client = new Socket("127.0.0.1", port);

            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(new OutputStreamWriter(client.getOutputStream()),true); // 记得autoFlush

            out.println("QUERY TIME ORDER");
            System.out.println("Send order to server successfully..");
            String resp = in.readLine();
            System.out.println("Now is :" + resp);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in = null;
            }

            if(out != null){
                out.close();
                out = null;
            }

            if(client != null){
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                client = null;
            }
        }
    }
}
