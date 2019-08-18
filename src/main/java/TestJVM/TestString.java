package TestJVM;

public class TestString {

    /**
     * 研究一下
     * @param args
     */
    public static void main(String[]args){
        String s1 = new StringBuilder().append("ja").append("va1").toString();
//        String s1 = new String("java1");
        System.out.println(s1.intern() == s1);

        String s2 = new StringBuilder().append("ja").append("va").toString();
//        String ss2  = s1.substring(0, 4);
//        String s2 = new String("java");
        System.out.println(s2.intern() == s2);

        String s3 = new StringBuilder("java2").toString();
        System.out.println(s3 == s3.intern());

        String s4 = new StringBuilder().append("java3").toString();
        System.out.println(s4 == s4.intern());


        int aa  = 512;
        System.out.println(aa >>> 11);

        tableSizeFor(1);

    }


    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        System.out.println(n+1);
        return n;
    }
}
