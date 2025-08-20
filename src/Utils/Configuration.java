package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/** */

/**
* 读取properties文件
* @author Qutr
*
*/
public class Configuration
{
private Properties propertie;
private FileInputStream inputFile;
private FileOutputStream outputFile;

/** *//**
* 初始化Configuration类
*/
public Configuration()
{
propertie = new Properties();
}
/** *//**
* 初始化Configuration类
*/
/*public Configuration()
{
Properties propertie = new Properties();
//InputStream in=Object.class.getResourceAsStream("config/test.properties");
//InputStream in = Configuration.class.getResourceAsStream("/test.properties");
InputStream in = Configuration.class.getClassLoader().getResourceAsStream("test.properties");  
*//**
 * 调试
 *//*
BufferedReader br=new BufferedReader(new InputStreamReader(in) );
StringBuffer sb=new StringBuffer();
try {
	while(br.readLine()!=null){
		sb.append(br.readLine());
	}
	System.out.println(sb.toString());
} catch (IOException e1) {
	// TODO 自动生成的 catch 块
	e1.printStackTrace();
}

/////////////////////////////////////////////////////////////////////////////////

try {
	propertie.load(in);
	
} catch (IOException e) {
	// TODO 自动生成的 catch 块
	e.printStackTrace();
}
}
*/
/** *//**
* 初始化Configuration类
* @param filePath 要读取的配置文件的路径+名称
*/
public Configuration(String filePath)
{
propertie = new Properties();
try {
inputFile = new FileInputStream(filePath);
propertie.load(inputFile);
inputFile.close();
} catch (FileNotFoundException ex) {
System.out.println("读取属性文件—>失败！- 原因：文件路径错误或者文件不存在");
ex.printStackTrace();
} catch (IOException ex) {
System.out.println("装载文件—>失败!");
ex.printStackTrace();
}
}//end ReadConfigInfo()

/** *//**
* 重载函数，得到key的值
* @param key 取得其值的键
* @return key的值
*/
public String getValue(String key)
{
if(propertie.containsKey(key)){
String value = propertie.getProperty(key);//得到某一属性的值
return value;
}
else
return "";
}//end getValue()

/**
* 重载函数，得到key的值
* @param fileName properties文件的路径+文件名
* @param key 取得其值的键
* @return key的值
*/
public String getValue(String fileName, String key)
{
try {
String value = "";
inputFile = new FileInputStream(fileName);
propertie.load(inputFile);
inputFile.close();
if(propertie.containsKey(key)){
value = propertie.getProperty(key);
return value;
}else
return value;
} catch (FileNotFoundException e) {
e.printStackTrace();
return "";
} catch (IOException e) {
e.printStackTrace();
return "";
} catch (Exception ex) {
ex.printStackTrace();
return "";
}
}//end getValue()

/** *//**
* 清除properties文件中所有的key和其值
*/
public void clear()
{
propertie.clear();
}//end clear();

/** *//**
* 改变或添加一个key的值，当key存在于properties文件中时该key的值被value所代替，
* 当key不存在时，该key的值是value
* @param key 要存入的键
* @param value 要存入的值
*/
public void setValue(String key, String value)
{
propertie.setProperty(key, value);
}//end setValue()

/** *//**
* 将更改后的文件数据存入指定的文件中，该文件可以事先不存在。
* @param fileName 文件路径+文件名称
* @param description 对该文件的描述
*/
public void saveFile(String fileName, String description)
{
try {
outputFile = new FileOutputStream(fileName);
propertie.store(outputFile, description);
outputFile.close();
} catch (FileNotFoundException e) {
e.printStackTrace();
} catch (IOException ioe){
ioe.printStackTrace();
}
}//end saveFile()

public static void ConfigProperties()
{
Configuration rc = new Configuration("config/config.properties");//相对路径
                                       
String ServerHost = rc.getValue("ServerHost");//以下读取properties文件的值
String UserName= rc.getValue("UserName");
String ServerPort = rc.getValue("ServerPort");
String Password  = rc.getValue("Password");
String FromAddress  = rc.getValue("FromAddress");
String ToAddress = rc.getValue("ToAddress");
String Subject = rc.getValue("Subject");
String Content = rc.getValue("Content");
String receivers =rc.getValue("receivers");
String[] Receivers=receivers.split(",");


/*System.out.println("ip = " + ip + "ip-test leng = " + "ip-test".length());//以下输出properties读出的值
System.out.println("ip’s length = " + ip.length());
System.out.println("host = " + host);
System.out.println("tab = " + tab);
*/
System.out.println(ServerHost+" "+UserName);
System.out.println(Subject);
System.out.println(Content);
for(int i=0;i<Receivers.length;i++){
	System.out.println(Receivers[i]);
}
//
/*Configuration cf = new Configuration();
String ipp = cf.getValue("config/test.properties", "ip");
System.out.println("ipp = " + ipp);
// cf.clear();
cf.setValue("min", "999");
cf.setValue("max", "1000");
cf.saveFile("config/save.perperties", "test");*/

// Configuration saveCf = new Configuration();
// saveCf.setValue("min", "10");
// saveCf.setValue("max", "1000″);
// saveCf.saveFile(".\config\save.perperties");

}//end main()

	public static void main(String[] args) {
		Configuration rc=new Configuration("config/config");
	//	String chromePath=rc.getValue("ChromeDriverPath");

		rc.setValue("projectName","仟金所001");
		rc.saveFile("config/config","test");
		System.out.println("测试value:  "+rc.getValue("projectName"));
	//	System.out.println("Chrome路径是:"+chromePath);
	//	System.out.println(rc.getValue("password"));
		/*rc.setValue("testKey","testValue");
		rc.saveFile("config/config.properties","测试Key:测试Value");
		System.out.println("测试value:  "+rc.getValue("testKey"));*/
	}

}//end class ReadConfigInfo