import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class W3school {

    WebDriver wd;

    @BeforeMethod
    public  void precondition(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://www.w3schools.com/css/css_table.asp");
    }

    @Test
    public  void w3schoolTest(){
        List<WebElement>elements = wd.findElements(By.cssSelector("tr"));                           //numbers of rows
        System.out.println("Numbers of rows in the table: " + elements.size());

        List<WebElement>columns = wd.findElements(By.cssSelector("tr th"));                         //numbers of columns
        System.out.println("Numbers of columns in the table: " + columns.size());

        String row3 = wd.findElement(By.cssSelector("tbody tr:nth-child(4)")).getText();            //print row 3
        System.out.println("Row #3: " + row3);

        List<WebElement> lastColumns = wd.findElements(By.cssSelector("tbody td:last-child"));      //print lastColumns
        int colNumb = 0;
        for (WebElement element :lastColumns) {
            colNumb++;
            System.out.println("Last column in the row #" + colNumb + ": " + element.getText());
        }

        String str = wd.findElement(By.cssSelector("tbody td:nth-child(2)")).getText();             //print Maria Anders
        System.out.println("M.A.: "+str);

    }

    @AfterMethod
    public void postCondition(){
        wd.quit();
    }
}
