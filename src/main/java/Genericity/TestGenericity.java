package Genericity;

/**
 * @Title: ${FILE_NAME}
 * @Package: Genericity
 * @Description: 泛型的使用，主要包括泛型类，泛型方法和泛型接口
 *
 *
 *
 * @author: Eta
 * @date: 2018/9/13 15:42
 */
public class TestGenericity {

    public static void main(String[] args){

    }

    /**
     * 返回泛型类型中值最小的元素
     */
    public static <T extends Comparable> T min(T[] a){
        if(a == null || a.length == 0){
            return null;
        }

        T smallest = a[0];

        for(int i =1 ; i < a.length ;i++){
            if(smallest.compareTo(a[i]) > 0){
                smallest = a[i];
            }
        }
        return smallest;
    }


    public static void printInfo(Pair<? extends Person> pair){

    }

}
