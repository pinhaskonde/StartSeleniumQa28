import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class W3school {

    WebDriver wd;

    @BeforeMethod
    public  void precondition(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("");
    }

    @Test
    public  void w3schoolTest(){
        //numbers of rows

        //numbers of columns

        //print rows 3

        //print lastColumns

        //print Maria Anders
    }

    @AfterMethod
    public void postCondition(){

    }
}
