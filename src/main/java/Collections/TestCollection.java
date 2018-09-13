package Collections;

import java.math.BigDecimal;
import java.util.*;

/**
 * @Title: ${FILE_NAME}
 * @Package: Collections
 * @Description:
 * @author: Eta
 * @date: 2018/9/13 10:27
 */
public class TestCollection {


    public static void main(String[]args){
//        testList();
//        testList1();
        testSet();
    }

    /**
     * List
     *     ListIterator 中next()与previous()混用注意指针位置
     *
     */
    public static void testList(){
        List<BigDecimal> decList = new ArrayList<BigDecimal>();
        decList.add(new BigDecimal(123));
        decList.add(new BigDecimal(535));
        decList.add(new BigDecimal(657));
        // 与itearator 有何不同
        ListIterator<BigDecimal> decListIt = decList.listIterator();
        //
        while(decListIt.hasNext()){
            BigDecimal bd = decListIt.next();
            int id = decListIt.nextIndex();
            System.out.println("第"+id+"个元素的取值为："+bd);
        }

    }



    public static void testList1(){
        String[] strArr = {"abcd","ywer","fhids"};
        List<String> strList = new ArrayList<String>(Arrays.asList(strArr));

        System.out.println(strList.contains("abcd"));

        List<String> subList = strList.subList(0,2);
        System.out.println(subList);

        System.out.println(strList.lastIndexOf("abcd"));
    }


    public static void testSet(){

        Integer[] intArr = {12,11,12,34,34,57};

        Set<Integer> intSet = new HashSet<Integer>(Arrays.asList(intArr));
        
        System.out.println(intSet);

        // set中元素排序
        


    }
}
