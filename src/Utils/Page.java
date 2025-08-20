package Utils;
/**
 * <p>The <b>Page Object</b> pattern represents the screens of your web app as a series of
 * objects.</p>
 *
 * <p>PageObjects can be thought of as facing in two directions simultaneously.
 * Facing towards the developer of a test, they represent the services offered
 * by a particular page. Facing away from the developer, they should be the only
 * thing that has a deep knowledge of the structure of the HTML of a page (or
 * part of a page) It's simplest to think of the methods on a Page Object as
 * offering the "services" that a page offers rather than exposing the details
 * and mechanics of the page.</p>
 *
 * @see <a href="http://code.google.com/p/webdriver/wiki/PageObjects">Page Objects Wiki</a>
 *
 * @author lizejun
 */


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public  class Page  {
	//public Logger logger= LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	protected WebDriver driver =null;
	public String index=null;
	public static String userInfo=null;
	public static String tempVideoCapurePath=null;
	public Screen screen = new Screen();

	/**
	 * 构造函数
	 * @param driver
	 */

	protected Page(WebDriver driver){
		if (null==driver){
			throw new IllegalArgumentException("WebDriver cannot be null");
		}
		this.driver=driver;
	}

	public Page(){}


	public static void setUserInfo(String userInfo) {
		Page.userInfo = userInfo;
	}
	/**
	 * 设置ChromeDriver 的路径
	 */
	public static void setSystemProperty(){
		String ChromeDriverPath = Page.getPropertie("config/configration.properties", "ChromeDriverPath");
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
	}
	public static void setFirefoxSystemProperty(){
		/*String FirefoxDriverPath = Page.getPropertie("config/configration.properties", "FirefoxDriverPath");
		System.setProperty("webdriver.chrome.driver", FirefoxDriverPath);*/
		String FirefoxDriverPath = Page.getPropertie("config/configration.properties", "FirefoxDriverPath");
		System.setProperty("webdriver.firefox.bin", FirefoxDriverPath);
	}
	public static WebDriver getDriver(String driverName)
	{
		if(driverName.equals("Chrome")) {
			String ChromeDriverPath = Page.getPropertie("config/configration.properties", "ChromeDriverPath");
			System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
			return new ChromeDriver();
		}else if(driverName.equals("IE"))
		{
			/*String IEDriverPath = Page.getPropertie("config/configration.properties", "IEDriverPath");
			System.setProperty("webdriver.ie.driver", IEDriverPath);*/
			System.setProperty("webdriver.ie.driver","C:\\Program Files\\Internet Explorer\\IEDriverServer.exe");
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			return  new InternetExplorerDriver(ieCapabilities);
		}

		return null;
	}
	public static WebDriver createDriver()
	{
		int driverType= Integer.parseInt(Page.getLoanPropertie("browserType"));
		switch (driverType) {
			case 1:
				Page.setSystemProperty();
				WebDriver driver=new ChromeDriver();
				return driver;
			case 2:

				Page.setFirefoxSystemProperty();
				WebDriver driver1=new FirefoxDriver();
				return  driver1;

		}
		return null;
	}
	public void switchtoFrame(WebElement webElement)
	{
		driver.switchTo().frame(webElement);
	}


	/**
	 *
	 */
	public void get(String url){
		driver.get(url);
		sleep(2);
	}

	/**
	 * 执行JavaScript代码
	 * @param javaScript
	 */
	public void executeScript(String javaScript)
	{
		((JavascriptExecutor)driver).executeScript(javaScript);
	}


	public void printTestResult(boolean testResult)
	{
		if(testResult){
			System.out.println("");
			System.out.println("测试用例: Pass ");
			System.out.println("");
		}
		else {
			System.out.println("");
			System.out.println("测试用例: Fail");
			System.out.println("");
		}
	}

	/**
	 * 返回driver
	 * @return
	 */
	public WebDriver getWebDriver(){
		return driver;
	}
	/**
	 * 获得当前地址
	 */
	public String getCurrentUrl(){
		return driver.getCurrentUrl();
	}
	/**
	 * 获得当前页面标题
	 */
	public String getTitle(){
		return driver.getTitle();
	}
	/**
	 * 获取Propertie
	 */
	public  static String getPropertie(String propertiePath, String key){
		Configuration rc = new Configuration(propertiePath);//相对路径
		String propertie =rc.getValue(key);
		return propertie;
	}
	public  static String getPropertie(String key){
		Configuration rc = new Configuration("config/configration.properties");//相对路径
		String propertie =rc.getValue(key);
		return propertie;
	}
	public  static String getLoanPropertie(String key){

		//System.out.println(userInfo);
		if(userInfo==null)
		{
			setUserInfo("config/UserInfo.properties");
		}
		//Configuration rc = new Configuration("config/UserInfo.properties");//相对路径
		//System.out.println("userInfo="+userInfo);
		Configuration rc = new Configuration(userInfo);//相对路径
		String propertie =rc.getValue(key);
		return propertie;
	}
	public  static String getERPProperty(String key){


		Configuration rc = new Configuration("config/ERPUserInfo.properties");//相对路径
		String propertie =rc.getValue(key);
		return propertie;
	}
	public static void setProperties(String fileName, String key, String value){
		Configuration rc=new Configuration(fileName);
		rc.setValue(key,value);
		rc.saveFile(fileName,"修改时间:");
	}
	public static void setProperties(String key, String value){
		//System.out.println(userInfo);
		if(userInfo==null)
		{
			setUserInfo("config/UserInfo.properties");
		}
		Configuration rc=new Configuration(userInfo);
		rc.setValue(key,value);
		rc.saveFile(userInfo,"修改时间:");
	}

	/**
	 * 执行autoIT
	 */
	public void runAutoIT(String filePath){
		Runtime rn = Runtime.getRuntime();
		Process p = null;
		try {
			//  p = rn.exec("\"D:/autoit2.exe\"");
			p=rn.exec(filePath);
		} catch (Exception e) {
			System.out.println("Error exec!");
		}
	}

	/**
	 *
	 * @param webElement:页面元素属性
	 * @return 根据页面元素属性返回该下拉框
	 */
	public Select select(WebElement webElement){
		sleep(1);
		Select select =new Select(webElement);
		return select;
	}

	public void click(WebElement webElement)  {
		sleep(2);
		webElement.click();
		//sleep(2);
	}
	public void click(WebElement webElement, int sleepTime){
		sleep(sleepTime);
		webElement.click();
		wait(200);
	}
	public void rightClick(WebElement webElement){
		sleep(2);
		Actions action = new Actions(driver) ;
		action.contextClick(webElement);
		wait(200);
	}

	/**
	 *
	 * @param webElement
	 */
	public void hover(WebElement webElement) {

		try{
			//WebElement element = driver.findElement(By.xpath(xpath));
			Actions action = new Actions(driver);
			action.moveToElement(webElement).perform();
		}catch(NoSuchElementException e){
			System.out.println("悬停对象不存在！");
		}catch (ElementNotVisibleException e) {
			System.out.println("XPath匹配多个悬停对象！");
		}

	}

	public void back(){
		driver.navigate().back();
	}
	/**
	 * 获取某个元素
	 */
	public WebElement findElement(By by){
		return driver.findElement(by);
	}
	/**
	 * 用于硬性等待
	 * @param seconds
	 */
	public void sleep(int seconds){
		System.out.println("休眠: "+seconds+"s");
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void wait(int miniSenconds)
	{
		try {
			Thread.sleep(miniSenconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 用于等待某个元素的出现,软等待
	 * @param by
	 * @return
	 */
	public boolean wait (final By by)
	{
		new WebDriverWait(driver,10).until(new ExpectedCondition<Boolean>(){
			public Boolean apply(WebDriver arg0){
				return arg0.findElement(by).isDisplayed();
			}
		});
		return true;
	}
	/**
	 * 处理页面上弹出的Alert()
	 */
	public Alert getAlert(){
		sleep(2);
		Alert alert=driver.switchTo().alert();
		return alert;
	}
	public void quit()
	{
		wait(500);
		driver.quit();
	}
	/**
	 *模拟键盘箭头向下,然后回车.即,模拟下拉选中
	 */
	public void KeyDownAndEnter(){
		sleep(1);
		Actions actions=new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	}
	/**
	 *模拟键盘箭头向下,然后回车.即,模拟下拉选中
	 */
	public void KeyDown(){
		sleep(1);
		Actions actions=new Actions(driver);
		actions.sendKeys(Keys.ARROW_DOWN).build().perform();
	}
	public void KeyEsc(){
		sleep(1);
		Actions actions=new Actions(driver);
		actions.sendKeys(Keys.ESCAPE).build().perform();
	}

	/**
	 * 最大化窗口
	 * @Title: KeyDownAndEnter
	 * @param  :
	 * @return void    返回类型
	 */
	public void windowMaximize(){
		driver.manage().window().maximize();
	}
	/**
	 * 模拟键盘回车
	 */
	public void keyEnter(){
		sleep(1);
		Actions actions=new Actions(driver);
		actions.sendKeys(Keys.ENTER).build().perform();
	}
	/**
	 * 关闭当前页面,并将焦点放到打开的新页面
	 */
	public void switchToNewPage(int num){
		sleep(2);
		String handles[]=new String[driver.getWindowHandles().size()];
		System.out.println("当前页面数量: "+handles.length);
		driver.getWindowHandles().toArray(handles);
		driver.switchTo().window(handles[num]);
		sleep(2);

	}
	public void switchToPage(String keyWord){
		sleep(2);
		String handles[]=new String[driver.getWindowHandles().size()];
		System.out.println("第一次页面数量: "+handles.length);
		driver.getWindowHandles().toArray(handles);
		for (String h:handles)
		{
			driver.switchTo().window(h);
			System.out.println(driver.getTitle());
			if(driver.getTitle().contains(keyWord))
			{
				break;
			}else if (driver.getTitle().contains("验证码中间页"))
			{
				confirmConsole();
			}
			sleep(2);
		}

		/*String handles1[]=new String[driver.getWindowHandles().size()];
		System.out.println("第二次页面数量: "+handles1.length);
		driver.getWindowHandles().toArray(handles1);
		driver.switchTo().window(handles[i]);*/
		sleep(2);

	}
	public void confirmConsole() {

		Scanner scanner = new Scanner(System.in);
		//JavaMail.send(  "需要人工操作", "");
		System.out.println("准备好了吗？ 按y键yes，按n键no");

		while (true) {
			String keyCode = scanner.next();

			if (keyCode.equals("y")) { // 回车键的键码是10
				System.out.println("yes");
				break;
			} else if (keyCode.equals("n")) { // ESC键的键码是27
				System.out.println("no");
				break;
			}
		}
	}

	public void refresh(){
		driver.navigate().refresh();
	}

	public void switchFrame(String frame){
		wait(200);
		driver.switchTo().frame(frame);

	}
	public void switchDefaultContent(){
		driver.switchTo().defaultContent();
	}

	public void switchBack(){
		sleep(1);
		driver.switchTo().defaultContent();
	}
	public void setScroll(String height){
		try {
			String setscroll = "document.documentElement.scrollTop=" + height;

			JavascriptExecutor jse=(JavascriptExecutor) driver;
			jse.executeScript(setscroll);
		} catch (Exception e) {
			System.out.println("Fail to set the scroll.");
		}
	}
	public void sendKeys(WebElement webElement, String text) {
		wait(200);
		webElement.clear();
		webElement.sendKeys(text);
		//sleep(1);
	}
	public void paste()
	{
		sleep(1);
		Actions actions=new Actions(driver);
		actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();

	}
	/*public void space()
	{
		sleep(1);
		Actions actions=new Actions(driver);
		actions.moveToElement().build().perform();
	}*/
	public void keyEvent(CharSequence... keysToSend)//Keys.CONTROL+"s"
	{
		sleep(1);
		Actions actions=new Actions(driver);
		actions.sendKeys(keysToSend).perform();
	}
	public void screenShot(String picName,String proName) throws FindFailed {

		String propName="config/"+proName+".properties";
		String filepath=  Page.getPropertie(propName,"screenShotsPath");
		String begin=Page.getPropertie(propName,"begin");
		String datestring= GetDateUtil.getdate2DaysBefore();
		//String datestring= AppstoreTest.getTodayDate();
		System.out.println("screenShot获取日期: "+datestring);
		//Screenshot screenshot= new AShot().shootingStrategy(ShootingStrategies.viewportPasting( 1000 )).takeScreenshot(driver);
		Screenshot screenshot= new AShot().shootingStrategy(ShootingStrategies.simple()).takeScreenshot(driver);

		try {
			ImageIO.write(screenshot.getImage(), "PNG" , new File(filepath+begin+picName+"_"+datestring+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void screenCaputre() throws FindFailed {
/*
		String propName="config/"+proName+".properties";
		String filepath=  Page.getPropertie(propName,"screenShotsPath");*/

		String rootPath = System.getProperty("user.dir").replace("\\", "/");
		tempVideoCapurePath = rootPath+"/sikuliIcon/"+"tempVideoCapure"+".png";

		//Screenshot screenshot= new AShot().shootingStrategy(ShootingStrategies.viewportPasting( 1000 )).takeScreenshot(driver);
		Screenshot screenshot= new AShot().shootingStrategy(ShootingStrategies.simple()).takeScreenshot(driver);
		//tempVideoCapurePath=filepath+"tempVideoCapure"+".png";
		System.out.println("tempVideoCapurePath: "+tempVideoCapurePath);
		try {
			ImageIO.write(screenshot.getImage(), "PNG" , new File(tempVideoCapurePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 判断某个元素是否存在
	 */
	public boolean isElementExist(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (Exception e) {
			//System.out.println("不存在此元素");
			return false;
		}
	}
	/**
	 * 判断某个元素是否存在
	 */
	public boolean isElementExist(WebElement webElement) {
		try {
			//driver.findElement(by);
			webElement.isDisplayed();
			System.out.println("元素存在了");
			return true;
		} catch (Exception e) {
			System.out.println("不存在此元素");
			return false;
		}
	}
	/**
	 * selenium 缩放浏览器
	 */
	public void zoom(float scale)
	{
		JavascriptExecutor driver_js= ((JavascriptExecutor) driver);
		//driver_js.executeScript("document.body.style.transform='scale(0.5)'");
		driver_js.executeScript("document.body.style.transform='scale("+scale+")'");

	}
	public void waitFor(String xpath)
	{
		while(!isElementExist(By.xpath(xpath)))
		{
			System.out.println("waiting ...");
			sleep(3);
           /* String verifyCode=Page.getPropertie("verifyCode");
            if(!verifyCode.equals(""))
            {
                char[] array= StringUtils.toCharArray(verifyCode);
                for (int i=0;i<array.length;i++)
                {
                    page.InputList_verifyCode.get(i).sendKeys(String.valueOf(array[i]));
                }
            }*/
		}

	}
	public void waitFor(WebElement webElement)
	{
		long startTime =  System.currentTimeMillis();

		while(!isElementExist(webElement))
		{
			System.out.println("waiting ...");
			sleep(3);

			/** 程序运行 processRun();*/

			/** 获取当前的系统时间，与初始时间相减就是程序运行的毫秒数，除以1000就是秒数*/
			long endTime =  System.currentTimeMillis();
			long usedTime = (endTime-startTime)/1000;
			System.out.println("已经等待: "+usedTime+"秒");
			if(usedTime>20)
			{
				driver.close();
				break;
			}
		}

		sleep(3);
		System.out.println("准备操作元素");
		sleep(3);
		//click(webElement);


	}



	public void spaceGap()
	{
		System.out.println("\n----------------------");
		System.out.println("---  next  -----------");
		System.out.println("----------------------");
	}
	public static void main(String[] args) {
		System.out.println();

	}





}
