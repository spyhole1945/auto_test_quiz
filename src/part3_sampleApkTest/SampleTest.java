package part3_sampleApkTest;


import com.enmoli.uitest.base.Page;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;



public class SampleTest  {

    private AndroidDriver<WebElement> driver;
    DesiredCapabilities capabilities =null;
    SamplePage page=null;

    @BeforeTest
    public void setUp() throws MalformedURLException {

        //设置自动化相关参数
        capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "7HX0219928011774");
        //设置安卓系统版本和平台
        capabilities.setCapability("platformVersion", "12");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        //设置app的主包名和主类名
        capabilities.setCapability("appPackage", "cn.ianzhang.android");
        capabilities.setCapability("appActivity", "cn.ianzhang.android.MainActivity");
        driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @Test
    public void startJob() {



        page = new SamplePage(driver);
        Page.init(driver, page);

        //点击第一个按钮"NEXT"
        page.clickIsExist(page.Button_first);
        String ButtonText1=page.Button_second.getText();
        System.out.println("第二个按钮名称: "+ButtonText1);
        Assert.assertEquals(ButtonText1,"PREVIOUS");


        page.click(page.Button_second);
        String ButtonText2=page.Button_first.getText();
        System.out.println("第一个按钮名称: "+ButtonText2);
        Assert.assertEquals(ButtonText2,"NEXT");

    }

    @AfterTest
    public void tearDown()
    {

    }


}
