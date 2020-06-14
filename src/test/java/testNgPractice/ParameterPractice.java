package testNgPractice;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterPractice {

    // We need to give the value to our parameter annotation from xml runner class.
    // If you use the Parameter annotation, you should provide the value inside your runner classes.
    //@Parameter("name")--> name is the key.
    @Parameters({"fname","lname"})
    @Test
    public void test1(String name, String lstName){
        System.out.println("Name is " +name);
        System.out.println("Last name is "+lstName);

    }


}
