package BIOTest.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class ScokerServer {

    public static void main(String[]args){
        int port = 8087;
        ServerSocket server = null;

        try {
            server = new ServerSocket(port);
            System.out.println("Time server is start in port:" + port);

            Socket socket = null;

            while(true){
                socket = server.accept();
                new Thread(new TimeServerTask(socket)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(server != null){
                System.out.println("Time server close..");
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    static class TimeServerTask implements Runnable{

        private Socket socket;

        public TimeServerTask(Socket socket){
            this.socket = socket;
        }


        @Override
        public void run() {
            BufferedReader in = null;
            PrintWriter out = null;

            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(),true);// 记得autoFlush

                String currentTime = null;
                String order = null;

                while(true){

                    order = in.readLine();
                    if(order == null){
                        break;
                    }

                    System.out.println("Time server receive order: "+order);

                    currentTime = "QUERY TIME ORDER".equalsIgnoreCase(order) ?new Date(System.currentTimeMillis()).toString() : "BAD ORDER";

                    out.println(currentTime);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(in != null){
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if(out != null){
                    out.close();
                }

                if(socket != null){
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
