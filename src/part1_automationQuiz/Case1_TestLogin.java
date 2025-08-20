package part1_automationQuiz;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


/**
 * Created by fanxuejuan on 2025/8/13.
 */
public class Case1_TestLogin extends BaseTest {

    @Test(priority = 1)
    public void testCase1() throws InterruptedException{



        click(page.Link_TestLoginPage);

        sendKeys(page.TextBox_username,"student");

        sendKeys(page.TextBox_password,"Password123");

        click(page.Button_submit);

        String expectURL="practicetestautomation.com/logged-in-successfully/";
        Assert.assertTrue(driver.getCurrentUrl().contains(expectURL));

        takeScreenshot("TestLoginCase_01");

        click(page.Button_logout);


    }
    @Test(priority = 2)
    public void testCase2() throws InterruptedException{


        sendKeys(page.TextBox_username,"incorrectUser");

        sendKeys(page.TextBox_password,"Password123");

        click(page.Button_submit);

        String expectMessage="Your username is invalid!";
        WebElement message=driver.findElement(By.xpath(page.Message_error));
        Assert.assertTrue(message.getText().contains(expectMessage));
        Assert.assertTrue(message.isDisplayed());
        takeScreenshot("TestLoginCase_02");



    }
    @Test(priority = 3)
    public void testCase3() throws InterruptedException{


        sendKeys(page.TextBox_username,"student");

        sendKeys(page.TextBox_password,"incorrectPassword");

        click(page.Button_submit);

        String expectMessage="Your password is invalid!";
        WebElement message=driver.findElement(By.xpath(page.Message_error));
        Assert.assertTrue(message.getText().contains(expectMessage));
        Assert.assertTrue(message.isDisplayed());
        takeScreenshot("TestLoginCase_03");
        driver.navigate().back();



    }
}
