package TestJVM;

public class TestAllocation {

    private static final int _1MB = 1024*1024;

    public static void main(String[]args){
        testAllocation();
    }


    public static void testAllocation(){
        byte[] alloc1,alloc2;

        alloc1 = new byte[_1MB/4];
        alloc2 = new byte[5*_1MB];
//        alloc3 = new byte[4*_1MB];
//        alloc3 = null;
//        alloc3 = new byte[4*_1MB];
    }
}
