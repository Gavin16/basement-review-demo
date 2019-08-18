package Collections.concurrent;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentTest {

    public static void main(String[]args){
        ConcurrentHashMap hMap = new ConcurrentHashMap();

        Runnable r = ()->{

        };

        Thread thread = new Thread(r);
        thread.getState();
    }
}
