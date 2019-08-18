package Collections;

public class RawItem {

    private String desc;

    private Integer num;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "RawItem{" +
                "desc='" + desc + '\'' +
                ", num=" + num +
                '}';
    }
}
