import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstTest {

    WebDriver wd;

    @BeforeMethod
    public void precondition(){
        wd = new ChromeDriver();

        //login before
    }

    @Test
    public  void startGoogle(){
        wd.get("https://www.google.com/");
//        wd.navigate().to("https://www.google.com/");

        //ad new contact
    }

    @Test
    public void loginTest(){
        //ad new contact
    }

    @AfterMethod
    public  void postCondition(){
//        wd.quit();
        wd.close();
    }
}
