package Utils;

public class PropertiesUtils {
    public  static String getProperty(String key){


        String rootPath = System.getProperty("user.dir").replace("\\", "/");
        Configuration rc = new Configuration(rootPath+"/config/InfoConfig.properties");//相对路径
        String propertie =rc.getValue(key);
        return propertie;
    }
    public  static String getProperty(String filename,String key){


        String rootPath = System.getProperty("user.dir").replace("\\", "/");

        Configuration rc = new Configuration(rootPath+"/config/"+filename+".properties");//相对路径
        String propertie =rc.getValue(key);
        return propertie;
    }
    public static void setProperties(String key,String value){
        //System.out.println(userInfo);
        //   Configuration rc=new Configuration(userInfo);
        String rootPath = System.getProperty("user.dir").replace("\\", "/");
        String filePath =rootPath+"/configration.properties";
        Configuration rc = new Configuration(filePath);//相对路径

        rc.setValue(key,value);
        rc.saveFile(filePath,"修改时间:");
    }
}
