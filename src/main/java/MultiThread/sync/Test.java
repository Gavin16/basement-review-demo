package MultiThread.sync;

public class Test {

    private static final int ACOUNT_NUM = 100;

    private static final int INIT_BALANCE=1000;

    private static final int MAX_AMOUNT=1000;

    private static final int DELAY=10;



    public static void main(String[]args){

        Bank bank = new Bank(ACOUNT_NUM,INIT_BALANCE);

        for(int i = 0; i < ACOUNT_NUM; i++){

            int from = i;
            Runnable r = () ->{
                try{
                    while(true){
                        double randAmount = MAX_AMOUNT*Math.random();
                        int to = (int) (ACOUNT_NUM*Math.random());

                        bank.transfer(from, to, randAmount);

                        Thread.sleep((long) (DELAY*Math.random()));
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                }

            };
            Thread thread = new Thread(r);
            thread.start();

        }

    }
}
