package part3_sampleApkTest;



import com.enmoli.uitest.base.Page;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class SamplePage extends Page {
    public SamplePage(AndroidDriver driver) {super(driver);}



    //直播
   @AndroidFindBy(id = "cn.ianzhang.android:id/button_first")
    public AndroidElement Button_first;


    //头像
    @AndroidFindBy(id = "cn.ianzhang.android:id/button_second")
    AndroidElement Button_second;











}
