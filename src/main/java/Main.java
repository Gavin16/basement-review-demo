import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import domain.PersonDto;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        // test String intern method

        String str1 = "Hello there";

        String str2 = "Hello there";

        String str3 = "Hello there".intern();

        String str4 = "Hello" + new String("there");

        String str5 = "Hello" + " there";

        System.out.println(str1 == str5);
    }
}
