package enums;

public enum Titles {

    HOME_PAGE_TITLE("Home Page"),

    LOGIN_TITLE("PITER CHAILOVSKII"),

    SUBHEADER_LINK("https://github.com/epam/JDI"),

    DIFFERENT_ELEMENTS_TITLE("Different Elements"),

    USER_TABLE_PAGE_TITLE("User Table");

    public String title;

    Titles(String title) {

        this.title = title;
    }

    public String getTitle() {

        return title;
    }
}
