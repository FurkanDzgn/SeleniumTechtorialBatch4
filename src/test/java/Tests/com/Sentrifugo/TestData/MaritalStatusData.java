package Tests.com.Sentrifugo.TestData;

import org.testng.annotations.DataProvider;

public class MaritalStatusData {

    @DataProvider(name = "maritalTest")
    public Object[][] getData(){

        return new Object[][]{
                {"SS","SSingle","test1"},
                {"MM","MMaried","test2"},
                {"DD","DDivorced","test3"},
                {"ww","WWidowed","test4"},
                {"KK","KKiwi","test5"}
        };

    }

}
