package domain;

import java.util.Date;

/**
 * @Title: ${FILE_NAME}
 * @Package: domain
 * @Description:
 * @author: Eta
 * @date: 2018/9/13 22:43
 */
public class PersonDto {

    private String name;

    private Date birthday;

    private String age;

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
