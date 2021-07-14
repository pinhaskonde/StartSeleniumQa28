import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class MyTestTableCssSelector {
    static WebDriver wd;

    @BeforeMethod
    public static void preCondition(){
        wd = new ChromeDriver();
        wd.navigate().to("https://www.w3schools.com/css/css_table.asp");
    }

    @Test
    public static void testCondition(){
        List<WebElement> list = wd.findElements(By.cssSelector("tr td"));
        for(WebElement el : list){
            if (el.getText().startsWith("C")){
                System.out.println(el.getText());
            }
        }
    }

    @AfterMethod
    public static void postCondition(){
        wd.quit();
    }
}
