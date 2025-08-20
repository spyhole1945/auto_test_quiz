package Utils;

/**
 * Created by idoudou on 16/11/29.
 */
public class SystemInfo {
    /**
     *
     * @return ����ϵͳ����
     */
    public String getOSName() {
        return System.getProperty("os.name");
    }

    /**
     *
     * @return ����ϵͳ�汾
     */
    public String getOSVersion() {
        return System.getProperty("os.version");
    }

    /**
     *
     * @return �û��˻�����
     */
    public String getOSUserName() {
        return System.getProperty("user.name");
    }

    /**
     *
     * @return �û���Ŀ¼
     */
    public String getOSUserHome() {
        return System.getProperty("user.home");
    }

    /**
     *
     * @return �û���ǰ����Ŀ¼
     */
    public String getOSUserDir() {
        return System.getProperty("user.dir");
    }

    /**
     *
     * @return Ĭ����ʱ�ļ�·��
     */
    public String getJavaTempDir() {
        return System.getProperty("java.io.tmpdir");
    }

    /**
     *
     * @return ��·��
     */
    public String getJavaClassPath() {
        return System.getProperty("java.class.path");
    }

    /**
     *
     * @return �����ʵ������
     */
    public String getJavaVMName() {
        return System.getProperty("java.vm.name");
    }

    /**
     *
     * @return ��װĿ¼
     */
    public String getJavaHome() {
        return System.getProperty("java.home");
    }

    /**
     *
     * @return ���л����汾
     */
    public String getJavaVersion() {
        return System.getProperty("java.version");
    }

    /**
     *
     * @return ���л�����Ӧ��
     */
    public String getJavaVendor() {
        return System.getProperty("java.vendor");
    }

    /**
     *
     * @return ���л�����Ӧ��url
     */
    public String getJavaVendorUrl() {
        return System.getProperty("java.vendor.url");
    }

    public static void main(String[] args) {
         SystemInfo si = new SystemInfo();

        String osName = si.getOSName();
        System.out.println("osName  : " + osName);
        String osVersion = si.getOSVersion();
        System.out.println("osVersion  : " + osVersion);
        String osUserName = si.getOSUserName();
        System.out.println("osUserName  : " + osUserName);
        String osUserHome = si.getOSUserHome();
        System.out.println("osUserHome  : " + osUserHome);
        String osUserDir = si.getOSUserDir();
        System.out.println("osUserDir  : " + osUserDir);
        String javaTempDir = si.getJavaTempDir();
        System.out.println("javaTempDir  : " + javaTempDir);
        String javaClassPath = si.getJavaClassPath();
        System.out.println("javaClassPath  : " + javaClassPath);
        String javaVMName = si.getJavaVMName();
        System.out.println("javaVMName  : " + javaVMName);
        String javaHome = si.getJavaHome();
        System.out.println("javaHome  : " + javaHome);
        String javaVersion = si.getJavaVersion();
        System.out.println("javaVersion  : " + javaVersion);
        String javaVendor = si.getJavaVendor();
        System.out.println("javaVendor  : " + javaVendor);
        String javaVendorUrl = si.getJavaVendorUrl();
        System.out.println("javaVendorUrl  : " + javaVendorUrl);


    }

}
