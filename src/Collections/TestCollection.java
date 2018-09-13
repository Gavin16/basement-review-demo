package Collections;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * @Title: ${FILE_NAME}
 * @Package: Collections
 * @Description:
 * @author: Eta
 * @date: 2018/9/13 10:27
 */
public class TestCollection {


    public static void main(String[]args){
        testList();
    }

    /**
     * List
     */
    public static void testList(){
        List<BigDecimal> decList = new ArrayList<BigDecimal>();
        decList.add(new BigDecimal(123));
        decList.add(new BigDecimal(535));
        decList.add(new BigDecimal(657));
        // 与itearator 有何不同
        ListIterator<BigDecimal> decListIt = decList.listIterator();
        while(decListIt.hasNext()){
            int id = decListIt.nextIndex();
            BigDecimal bd = decListIt.next();
            System.out.println("第"+id+"个元素的取值为："+bd);
            if(decListIt.hasPrevious()){
                System.out.println("前一个元素为："+decListIt.previous());
            }

        }
    }
}
