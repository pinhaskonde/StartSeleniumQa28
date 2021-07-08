import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class IndexCss {
    WebDriver wd;

    @BeforeMethod
    public  void precondition (){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("file:///Users/workspace/Downloads/index.html");
    }

    @Test
    public void itemTest (){
        WebElement item1 = wd.findElement(By.cssSelector("#nav ul li:first-child"));
        item1.click();
        String item1Text = item1.getText();

        WebElement alert = wd.findElement(By.cssSelector("#alert"));
        String alertText  = alert.getText();

//        if(alertText.contains(item1Text)){
//            System.out.println("Test passed");
//        }else {
//            System.out.println("Test failed");
//        }

        Assert.assertTrue(alertText.contains(item1Text));
    }

    @Test
    public void formTest (){
        WebElement name = wd.findElement(By.name("name"));
        WebElement surename = wd.findElement(By.cssSelector("[name='surename']"));
        name.click();
        name.clear();
        name.sendKeys("Hello");
        surename.click();
        surename.clear();
        surename.sendKeys("Hello");

        wd.findElement(By.cssSelector("button.btn")).click();

        WebElement alert = wd.findElement(By.cssSelector("#alert"));
        String alertText  = alert.getText();

        Assert.assertFalse(alertText.contains("ggg"));
    }

    @Test
    public void tableTest(){
        List<WebElement> rows = wd.findElements(By.cssSelector("#country-table"));
        int numberRows = rows.size();
        System.out.println("Rows in table: "+ numberRows);

        List<WebElement> colums = wd.findElements(By.cssSelector("tr:first-child td"));
        int numberColums = colums.size();
        System.out.println("Colums in table: "+ numberColums);

        String text = wd.findElement(By.cssSelector("tr:last-child td:nth-child(2)")).getText();
        Assert.assertEquals(text,"Chine");

        List<WebElement> lastRow = wd.findElements(By.cssSelector("tr:last-child td"));

        for(WebElement el : lastRow){
            System.out.println(el.getText());
        }

        List<WebElement> lastColumns = wd.findElements(By.cssSelector("td:last-child"));

        for(WebElement el : lastColumns){
            System.out.println(el.getText());
        }

    }


    @AfterMethod
    public void postCondition(){
//        wd.close();
    }

}
