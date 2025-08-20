package Utils;


import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/*public class TestRetry implements IRetryAnalyzer {

    private static int retryCount = 1;
    private static int maxRetryCount = 3;//最大重试次数
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(retryCount<maxRetryCount && iTestResult.getThrowable()instanceof java.net.ConnectException){
            //判断用例执行中抛出的异常如果属于链接超时异常的子类，就重试三次；此处判断条件可根据自身需求来设定重试的条件
            retryCount++;
            return true;
        }
        return false;
    }*/
public class Retry implements IRetryAnalyzer {

    private int retryCnt = 0;
    private int maxRetryCnt = 3;


    @Override
    public boolean retry(ITestResult iTestResult) {
        if (retryCnt<maxRetryCnt){
            retryCnt++;
            return true;
        }
        return false;
    }

    // 用于重置retryCnt
    public void reset() {
        retryCnt = 0;
    }
}
