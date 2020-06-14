package SoftAssertPractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.SQLOutput;

public class PracticeOne {

    // If hard assert fails it will not go and execute the next line in Test annotation
    // but it will continue to execute the another test annotation

    @Test
    public void test2(){
        Assert.assertEquals(3,4,"The integer number verification");
        Assert.assertTrue("Techtorial".startsWith("Tech"),"Boolean condition verified");
        Assert.assertEquals("Tech","Tec","String values are verified");

    }

    @Test
    public void test3(){
        Assert.assertEquals(4,4,"The integer number verification");

    }

    @Test
    public void test1(){

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(3,4,"The integer number verification");
        softAssert.assertTrue("Techtorial".startsWith("Tech"),"Boolean condition verified");
        softAssert.assertEquals("Tech","Tech","String values are verified");
        // assertAll should be at the end of your test
        // Assert all will assert previous all verifications

        softAssert.assertAll(); // this line throwed the exception since line 32 verification is not passed
        System.out.println("Hello world"); // this line 38 will not be executed.
    }
}
