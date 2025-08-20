package part1_automationQuiz;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by fanxuejuan on 2025/8/13.
 */
public class Case2_TestExceptions extends BaseTest {

    @Test(priority = 1)
    public void testException1() throws InterruptedException{


       // setup();

        click(page.Link_TestExceptionsPage);
        click(page.Button_Add);

        String expectMessage="Row 2 was added";
        String message=null;
        try{
            driver.findElement(By.xpath(page.Row2Add)).isDisplayed();
             message=driver.findElement(By.xpath(page.Message_rowAdd)).getText();

        }catch ( NoSuchElementException e)
        {
            e.printStackTrace();
        }

        System.out.println(message);
        Assert.assertTrue(message.contains(expectMessage));
        takeScreenshot("TestExceptionCase_01");

    }
    @Test(priority = 2)
    public void testException2() throws InterruptedException{



        click(page.Link_TestExceptionsPage);
        click(page.Button_Add);

        sleep(4);

        WebElement row2=driver.findElement(By.xpath(page.Row2Add));
        try{
            row2.isDisplayed();
            sendKeys(page.Row2Add,"alex");
            sleep(4);
            driver.findElement(By.name("Save")).click();
           // driver.findElement(By.xpath("/html/body/div/div/section/section/div/div[3]/div/button[1]")).click();

        }catch ( NoSuchElementException e)
        {
            e.printStackTrace();
        }
        String expectMessage="Row 2 was saved";
        String message=driver.findElement(By.xpath(page.AddSuccess)).getText();
        System.out.println(message);
        takeScreenshot("TestExceptionCase_02");
        Assert.assertTrue(message.contains(expectMessage));


    }
    @Test(priority = 3)
    public void testException3() throws InterruptedException{


       // setup();

        click(page.Link_TestExceptionsPage);

        WebElement row1=driver.findElement(By.xpath(page.Row1));
        try{
            row1.clear();
            sendKeys(page.Row1,"alex");
            sleep(5);
            driver.findElement(By.name("Save")).click();
            // driver.findElement(By.xpath("/html/body/div/div/section/section/div/div[3]/div/button[1]")).click();

        }catch (WebDriverException e)
        {
            e.printStackTrace();
            takeScreenshot("TestExceptionCase_03");
        }
        String expectMessage="Row 1 was saved";
        String message=driver.findElement(By.xpath(page.AddSuccess)).getText();
        System.out.println(message);
        Assert.assertTrue(message.contains(expectMessage));




    }
    @Test(priority = 4)
    public void testException4() throws InterruptedException{


        click(page.Link_TestExceptionsPage);
        WebElement instructions=driver.findElement(By.xpath(page.instructions));
        System.out.println("说明是否显示? "+instructions.isDisplayed());
        click(page.Button_Add);
        System.out.println("说明是否显示? "+instructions.isDisplayed());
        takeScreenshot("TestExceptionCase_04");





    }
    @Test(priority = 5)
    public void testException5() throws InterruptedException{


        click(page.Link_TestExceptionsPage);
        click(page.Button_Add);


        WebDriverWait wait = new WebDriverWait(driver, 3);
        try{

        WebElement row2=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(page.Row2Add)));

        Assert.assertTrue( row2.isDisplayed());
        sendKeys(page.Row2Add,"alex");


        }catch ( WebDriverException e)
        {
            e.printStackTrace();
            takeScreenshot("TestExceptionCase_05");
        }


    }
}
