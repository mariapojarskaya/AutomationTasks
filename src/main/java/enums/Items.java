package enums;


import java.util.Arrays;
import java.util.List;

public enum Items {

    HOME("HOME"),
    CONTACT("CONTACT FORM"),
    SERVICE("SERVICE"),
    METALS("METALS & COLORS");

    public final String text;

    Items(String text) { this.text = text;}

    public static List<String> getList(){
        String[] texts = {
                HOME.text,
                CONTACT.text,
                SERVICE.text,
                METALS.text
        };
        List<String> content = Arrays.asList();
        return content;
    }
}
