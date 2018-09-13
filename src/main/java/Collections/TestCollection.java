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
//        testSet();
//        testQueue();
//        testStack();
        testMap();
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

    // set
    public static void testSet(){

        Integer[] intArr = {12,11,12,34,34,57};

        Set<Integer> intSet = new HashSet<Integer>(Arrays.asList(intArr));
        
        System.out.println(intSet);

        // set中元素排序
        intSet.add(27);

        System.out.println(intSet.contains(11));
        System.out.println(intSet.size());
    }


    // 队列queue的使用，队列大小
    public static void testQueue(){
        Queue<String> strQueue = new LinkedList<String>();

        strQueue.offer("sffs");
        strQueue.offer("ege");
        strQueue.offer("rrbtr");
        strQueue.offer("erte");

        for(String e : strQueue){
            System.out.println(e);
        }

        System.out.println(strQueue.poll());
        System.out.println(strQueue);
        System.out.println(strQueue.peek());
        strQueue.offer("hello");
        System.out.println(strQueue);

        System.out.println(strQueue.element());
        System.out.println(strQueue);

        System.out.println(strQueue.size());


    }

    /** stack */
    private static void testStack(){
        Stack<String> strStack = new Stack<>();

        strStack.push(" world");
        strStack.push("hello");

        System.out.println(strStack.empty());

        System.out.println(strStack);
        System.out.println(strStack.peek());
        System.out.println(strStack.pop());

        System.out.println(strStack.peek());
    }


    /** Map */
    private static void testMap(){
        Map<String,String> map = new HashMap<>();
        map.put("1","abc");
        map.put("2","def");
        map.put("3","ref");
        map.put("4","sed");

        Collection<String> valueList = map.values();
        Iterator<String> it = valueList.iterator();
        while(it.hasNext()){
            String str = it.next();
            System.out.println(str);
        }

        Set<String> strSet = new HashSet<>(valueList);
        System.out.println(strSet);

        // 将 key 对应的 oldValue 置换为 newValue
        map.replace("1","abc","123");
        System.out.println(map.keySet());
        System.out.println(map.values());

        // 若key 确实存在映射，则将key对应的映射值置换为 value
        String res = map.replace("1","233");
        System.out.println(res);
        System.out.println(map.keySet());
        System.out.println(map.values());

    }
}
