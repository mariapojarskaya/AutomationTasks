package enums;

import java.util.ArrayList;
import java.util.List;

public enum ImageTitles {
    FIRST_IMAGE_TITLE(
            "To include good practices\n" +
                    "and ideas from successful\n" +
                    "EPAM project"),
    SECOND_IMAGE_TITLE(
            "To be flexible and\n" +
                    "customizable"),
    THIRD_IMAGE_TITLE("To be multiplatform"),
    FOURTH_IMAGE_TITLE(
            "Already have good base\n" +
                    "(about 20 internal and\n" +
                    "some external projects),\n" +
                    "wish to get more…");

    private String imageTitle;

    public String getTitle() {
        return imageTitle;
    }

    ImageTitles(String imageTitle) {
        this.imageTitle = imageTitle;
    }

    public static List<String> getImageTitles() {
        List<String> imageItemTitles = new ArrayList<>();
        for (ImageTitles item : ImageTitles.values()) {
            imageItemTitles.add(item.getTitle());
        }
        return imageItemTitles;
    }
}