package part1_automationQuiz;



import Utils.Page;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * 基础类:作为启动浏览器,善后处理的工作,用于被测试类继承
 */

public class BaseTest {


    WebDriver driver=null;
    PracticePage page=null;;



    @BeforeTest
    public void setup(){


        BrowserType.setupChromeBrowser();
        driver = new ChromeDriver();


        // 初始化 EdgeDriver
       /* BrowserType.setupEdgeBrowser();
        driver = new EdgeDriver();*/



        page=new PracticePage();

        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice/");


    }


    @AfterClass
    public void tearDown(){
        //driver.quit();
    }
    public void takeScreenshot(String filename) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("screenshots/" + filename + ".png"));
        } catch (Exception e) {
            System.out.println("截图失败: " + e.getMessage());
        }
    }

    public void click(String xpath)

    {
        driver.findElement(By.xpath(xpath)).click();
        sleep(1);
    }

    public void sendKeys(String xpath,String content)

    {
        driver.findElement(By.xpath(xpath)).sendKeys(content);
        sleep(1);
    }
    public void sleep(int seconds){
        // System.out.println("休眠: "+seconds+"s");
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();


        }
    }

}

