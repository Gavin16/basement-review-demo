package domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title: ${FILE_NAME}
 * @Package: domain
 * @Description:
 * @author: Eta
 * @date: 2018/9/13 22:43
 */
public class PersonDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name = "张三";

    private transient Date birthday;

    private String age;

    public static String height = "177";

    public static String getHeight() {
        return height;
    }

    public static void setHeight(String height) {
        PersonDto.height = height;
    }

    public PersonDto() {
    }

    public PersonDto(String name, Date birthday, String age) {
        this.name = name;
        this.birthday = birthday;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", age='" + age + '\'' +
                '}';
    }
}
