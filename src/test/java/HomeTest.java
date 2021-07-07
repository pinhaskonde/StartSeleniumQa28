import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HomeTest {
    WebDriver wd;

    @BeforeMethod
    public void precondition(){
       wd = new ChromeDriver();
       wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");

    }

    @Test
//  Homework
    public  void homeTest() {
        List<WebElement> elements = wd.findElements(By.tagName("a"));
        WebElement about = elements.get(1);
        about.click();
        elements.get(1).click();

    }

    @Test
    public void locatorTest(){
        List<WebElement> elements = wd.findElements(By.tagName("a"));
        elements.get(2).click();


//        By.tagName()
        wd.findElement(By.tagName("a"));
        wd.findElement(By.tagName("h1"));
        wd.findElement(By.tagName("input"));
        wd.findElement(By.tagName("button"));

        wd.findElement(By.cssSelector("a"));
        wd.findElement(By.cssSelector("button"));

//        By.id
        wd.findElement(By.id("root"));
        wd.findElement(By.cssSelector("#root"));            //id="root" (of css element)
        wd.findElement(By.cssSelector("[id='root']"));

//        By.className()
        wd.findElement(By.className("container"));
        wd.findElement(By.className("active"));
        wd.findElement(By.cssSelector(".container"));
        wd.findElement(By.cssSelector(".active"));
        wd.findElement(By.cssSelector("[class='active']"));

//        By.name()
//        wd.findElement(By.name("namename"));    <- example
//        wd.findElement(By.cssSelector("[name='namename']"));   <- example

//        By.linkText()
        wd.findElement(By.linkText("HOME"));
        wd.findElement(By.linkText("ABOUT"));
        wd.findElement(By.partialLinkText("HO"));
        wd.findElement(By.cssSelector("[href='/home']"));


    }

    @Test
    public void loginTest(){
        wd.findElement(By.linkText("LOGIN")).click();

        List<WebElement> list = wd.findElements(By.tagName("input"));
        WebElement email = list.get(0);
        WebElement password = list.get(1);

        email.click();
        email.clear();
        email.sendKeys("maria@gmail.com+7");

        password.click();
        password.clear();
        password.sendKeys("Azs2hws$e");

        List<WebElement> buttons = wd.findElements(By.tagName("button"));
        buttons.get(0).click();
    }


    @Test
    public void homeLogin(){        //Homework
        WebElement login = wd.findElement(By.cssSelector("a[href='/login']"));
        login.click();
        WebElement email = wd.findElement(By.cssSelector("[placeholder$=\"Email\"]"));
        email.click();
        email.clear();
        email.sendKeys("maria@gmail.com+7");
        WebElement password = wd.findElement(By.cssSelector("[placeholder$=\"Password\"]"));
        password.click();
        password.clear();
        password.sendKeys("Azs2hws$e");
        WebElement buttonLogin = wd.findElement(By.cssSelector("div:nth-child(2) div button:nth-child(4)"));
        buttonLogin.click();

//        click on login                                    a[href='/login']
//        type email                                        [placeholder$="Email"]
//        type password                                     [placeholder$="Password"]
//        click button                                      div.class$='login_login__3EHKB' button:nth-child(4)
    }


    @AfterMethod
    public void postCondition() {
//        wd.quit();
    }

}
