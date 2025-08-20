package Utils;

//import com.enmoli.uitest.Utils.StringUtil;
/*import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

*/

import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.util.*;

/**
 * ʹ��dataProviderʱ��ÿ��case���н�����ǿ���������Դ��������ʧ�ܣ������Խ��������ô���
 *//*
public class TestngListener extends TestListenerAdapter {

    @Override
    public void onTestSuccess(ITestResult tr) {
     *//*   super.onTestSuccess(tr);
        // ����dataProvider��������ÿ�γɹ�������Retry����
        Retry retry = (Retry) tr.getMethod().getRetryAnalyzer();
        retry.reset();*//*



    }

    @Override
    public void onTestFailure(ITestResult tr) {
       // JavaMail.send((tr.getName()+"case fail"),"");

        super.onTestFailure(tr);
        // ����dataProvider��������ÿ��ʧ�ܺ�����Retry����
        Retry retry = (Retry) tr.getMethod().getRetryAnalyzer();
        retry.reset();


    }

    @Override
    public void onFinish(ITestContext testContext) {
       // JavaMail.send(StringUtil.getAppname(Page.appPackage)+"-"+testContext.getName()+": finished","Test result URL: http://192.168.83.184:8080/reporter/");

    }
    @Override
    public void onStart(ITestContext testContext)
    {
      //  JavaMail.send((StringUtil.getAppname(Page.appPackage)+"-"+testContext.getName()+": Start"),"");
    }*/
public class TestngListener extends TestListenerAdapter {


    //ʧ����������ʵ��
    public void onFinish(ITestContext testContext) {
    /*    super.onFinish(testContext);

        // List of test results which we will delete later
        ArrayList<ITestResult> testsToBeRemoved = new ArrayList<ITestResult>();
        // collect all id's from passed test
        Set<Integer> passedTestIds = new HashSet<Integer>();
        for (ITestResult passedTest : testContext.getPassedTests()
                .getAllResults()) {
//			logger.info("PassedTests = " + passedTest.getName());
            passedTestIds.add(getId(passedTest));
        }

        Set<Integer> failedTestIds = new HashSet<Integer>();
        for (ITestResult failedTest : testContext.getFailedTests()
                .getAllResults()) {
//			logger.info("failedTest = " + failedTest.getName());
            int failedTestId = getId(failedTest);

            // if we saw this test as a failed test before we mark as to be
            // deleted
            // or delete this failed test if there is at least one passed
            // version
            if (failedTestIds.contains(failedTestId)
                    || passedTestIds.contains(failedTestId)) {
                testsToBeRemoved.add(failedTest);
            } else {
                failedTestIds.add(failedTestId);
            }
        }

        // finally delete all tests that are marked
        for (Iterator<ITestResult> iterator = testContext.getFailedTests()
                .getAllResults().iterator(); iterator.hasNext();) {
            ITestResult testResult = iterator.next();
            if (testsToBeRemoved.contains(testResult)) {
//				logger.info("Remove repeat Fail Test: " + testResult.getName());
                iterator.remove();
            }
        }*/
        // TODO Auto-generated method stub
        System.out.println("ִ�� OnFinish.");
        Set<ITestResult> failedTests = testContext.getFailedTests().getAllResults();

        for(ITestResult temp : failedTests){

            ITestNGMethod method = temp.getMethod();
            if(testContext.getFailedTests().getResults(method).size() > 1){

                failedTests.remove(temp);
            }else{
                if(testContext.getPassedTests().getResults(method).size() > 0){
                    failedTests.remove(temp);
                }
            }
        }

    }
    private int getId(ITestResult result) {
        int id = result.getTestClass().getName().hashCode();
        id = id + result.getMethod().getMethodName().hashCode();
        id = id
                + (result.getParameters() != null ? Arrays.hashCode(result
                .getParameters()) : 0);
        return id;
    }
}
