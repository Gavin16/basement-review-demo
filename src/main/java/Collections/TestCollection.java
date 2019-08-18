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

        // 删除集合元素
        List<String> strList = new ArrayList();
        strList.add("aa");
        strList.add("bb");
        strList.add("cc");
        strList.add("dd");
        strList.add("ee");
        Iterator<String> iterator = strList.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
            iterator.remove();
        }
        System.out.println("list size = "+ strList.size());

        testList();

//        compareArrayListAndLinkedList();
        testLinkedList();

        testTreeSet();

        System.out.println("=====================");
        equalsTest();

        ifHashCodeEquals();

        hashMapAndTreeMapTest();
    }


    /**
     * HashMap 和 TreeMap 比较,TreeMap 相对HashMap的优势是否是有序？？？
     */
    private static void hashMapAndTreeMapTest(){

        HashMap<Item,String> hMap = new HashMap<Item, String>();
        TreeMap<Item,String> tMap = new TreeMap<Item, String>();


        Item item1 = new Item();
        Item item2 = new Item();
        Item item3 = new Item();
        Item item4 = new Item();

        item1.setDesc("1234");
        item1.setNum(82903);

        item2.setDesc("2345");
        item2.setNum(5742);

        item3.setDesc("3456");
        item3.setNum(6754);

        item4.setDesc("4567");
        item4.setNum(3387);

        hMap.put(item1,"nice");
        hMap.put(item2,"JOB");
        hMap.put(item3,"Good");
        hMap.put(item4,"OK");

        tMap.put(item1,"nice");
        tMap.put(item2,"JOB");
        tMap.put(item3,"Good");
        tMap.put(item4,"OK");

        hMap.forEach((k,v)->System.out.println(k+":"+v));
        System.out.println("=========treeMap=========");
        tMap.forEach((k,v)->System.out.println(k+":"+v));
    }


    private static void ifHashCodeEquals(){
        String str1 = "Aa";
        String str2 = "BB";

        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());

        HashMap<String,String> map = new HashMap<>();
        map.put(str1, "NiHao");
        map.put(str2, "DaLao");

    }

    private static void equalsTest(){
        // 测试比较重写equals 和 hash 方法是否有效
        Item item1 = new Item();
        Item item2 = new Item();

        item1.setDesc("item");
        item1.setNum(20);

        item2.setDesc("item");
        item2.setNum(20);

        System.out.println(item1.equals(item2));



        Set<Item> set = new TreeSet<Item>();
        set.add(item1);
        set.add(item2);
        System.out.println(set.size());

        System.out.println("-----------------");

        HashSet<RawItem>  set1 = new HashSet<RawItem>();
        RawItem rawItem1 = new RawItem();
        RawItem rawItem2 = new RawItem();

        rawItem1.setDesc("aaa");
        rawItem1.setNum(111);

        rawItem2.setDesc("aaa");
        rawItem2.setNum(111);

        set1.add(rawItem1);
        set1.add(rawItem2);

        System.out.println(rawItem1.equals(rawItem2));
        System.out.println(set1.size());

        set1.forEach(e -> System.out.println(e.getDesc()));
        set1.removeIf(e -> e.getNum()==111);
        System.out.println(set1.isEmpty());
    }

    private static void testTreeSet(){
        TreeSet<String> tSet = new TreeSet<>();
        tSet.add("111");
        tSet.add("999");
        tSet.add("000");
        tSet.add("fuish");
        tSet.add("ahsdkfhsd");
        tSet.add("bfhweifhi");
        tSet.add("csfihweio");
        tSet.add("dweofeonv");
        tSet.add("egrtegzdgdsdg");

        System.out.println("--------------");
        for(String str : tSet){
            System.out.println(str);
        }


        System.out.println("--------------");
        HashSet<String> hSet = new HashSet<>();
        hSet.add("111");
        hSet.add("999");
        hSet.add("000");
        hSet.add("fuish");
        hSet.add("ahsdkfhsd");
        hSet.add("bfhweifhi");
        hSet.add("csfihweio");
        hSet.add("dweofeonv");
        hSet.add("egrtegzdgdsdg");

        for(String str : hSet){
            System.out.println(str);
        }
    }

    private static void testLinkedList(){

        // 比较linkedList 的
        List<String> aList = new LinkedList<>();
        aList.add("111");
        aList.add("222");
        aList.add("333");

        List<String> bList = new LinkedList<>();
        bList.add("aaa");
        bList.add("bbb");
        bList.add("ccc");
        bList.add("ddd");

        // merge two list into one

        ListIterator<String> aItr = aList.listIterator();
        Iterator<String> bItr = bList.iterator();

        while(bItr.hasNext()){

            if(aItr.hasNext()){
                aItr.next();
            }
            aItr.add(bItr.next());
        }

        System.out.println(aList);

        // remove every second word from b
        bItr = bList.iterator();
        while(bItr.hasNext()){
            bItr.next();

            if(bItr.hasNext()){
                bItr.next();
                bItr.remove();
            }
        }


        System.out.println(bList);

        aList.removeAll(bList);
        System.out.println(aList);

        aItr = aList.listIterator(2);
        String aa = aItr.next();
        System.out.println(aa);

        // 反向迭代列表
        aItr = aList.listIterator(aList.size()-1);
        while(aItr.hasPrevious()){
            System.out.println(aItr.previous());
        }

    }


    private static void compareArrayListAndLinkedList(){
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new LinkedList<>();
        Long start1 = System.nanoTime();
        for(int i = 0 ; i < 10000 ; i++){
            list1.add(i);
        }
        Long end1 = System.nanoTime();
        System.out.println("ArrayList init time cost: " + (end1 - start1));


        Long start2 = System.nanoTime();
        for(int j = 0 ; j < 10000 ; j++){
            list2.add(j+1);
        }
        Long end2 = System.nanoTime();
        System.out.println("LinkedList init time cost: " + (end2 - start2));
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
        // 与itearator 有何不同: ListIterator 在Iterator的基础上针对list 提供了更多操作：
        // 譬如: previous(),nextIndex(),add(),set()等
        ListIterator<BigDecimal> decListIt = decList.listIterator();

        while(decListIt.hasNext()){
            BigDecimal bd = decListIt.next();

            int id = decListIt.nextIndex();
            System.out.println("第"+id+"个元素的取值为："+bd);
        }

        List<Integer> intList = new LinkedList<>();
        intList.add(123);
        intList.add(345);
        intList.add(456);

        if(intList instanceof RandomAccess){
            System.out.println("--支持 randomAccess--" + intList.get(1));
        }else{
            ListIterator<Integer> iterator = intList.listIterator();
            while(iterator.hasNext()){
                Integer value = iterator.next();
                if(iterator.nextIndex()==2){
                    iterator.set(100);
                    System.out.println("---不支持 randomAccess---"+value);
                }
            }
        }
        System.out.println(intList);

        // 两个迭代器对同一个list 进行操作
        ListIterator<Integer> itr1 = intList.listIterator();
        ListIterator<Integer> itr2 = intList.listIterator();

        itr1.next();
        itr1.set(666);
//        itr1.add(111);
        Integer next = itr2.next();
        System.out.println(next);

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
