package dataProviders;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider
    public Object[][] simpleDataProvider(){
        return new Object[][]{
                {"String", 1},
                {"String", 2},
                {"String", 3}
        };
    }

    @DataProvider(parallel = true)
    public Object[][] checkIndexPageByDataProvider(){
        return new Object[][]{
                {0, "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project"},
                {1, "To be flexible and\n" +
                        "customizable"},
                {2, "To be multiplatform"},
                {3, "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…"}
        };
    }
}
