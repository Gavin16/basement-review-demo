import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import domain.PersonDto;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        // Gson
        PersonDto pd = new PersonDto();
        pd.setAge("27");;
        pd.setBirthday(new Date());
        pd.setName("sdf");


        Gson gson = new Gson();
        String jsonStr = gson.toJson(pd);

        System.out.println(jsonStr);

        String jstr = "{\"name\":\"sdf\",\"birthday\":\"Sep 13, 2018 10:48:44 PM\",\"age\":\"27\"}";
        PersonDto pdr = gson.fromJson(jstr,PersonDto.class);

        System.out.println(pdr.toString());
        Gson gson1 = new GsonBuilder().create();

    }
}
