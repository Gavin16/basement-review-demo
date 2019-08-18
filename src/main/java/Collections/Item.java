package Collections;

import java.util.Objects;

/**
 * 重写 hash equals 方法
 */
public class Item implements Comparable<Item> {

    private String desc;

    private Integer num;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public int compareTo(Item o) {

        int compare = Integer.compare(num, o.num);
        if(compare == 0){
            return desc.compareTo(o.desc);
        }else{
            return compare;
        }
    }

    /**
     *
     * @param o
     * @return
     */
    public boolean equals(Item o){
        if(this == o){
            return true;
        }
        if(null == o){
            return false;
        }
        if(this.getClass() != o.getClass()){
            return false;
        }

        return Objects.equals(desc,o.desc) && num == o.num;

    }

    public int hashCode(){
        return Objects.hash(desc,num);
    }
}
