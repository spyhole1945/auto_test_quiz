package part2_cucumberQuiz.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;



@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/part2_cucumberQuiz/features/employeeClaims.feature", // 精确到具体文件
        glue = "part2_cucumberQuiz.steps.EmployeeClaimsSteps",
        plugin = {"pretty"}

)
public class TestRunner {
    static {
        // 诊断类路径
        System.out.println("Classpath: " + System.getProperty("java.class.path"));
    }
}



/*@CucumberOptions(features = "part2_cucumberQuiz/features/employeeClaims.feature",
        glue = "part2_cucumberQuiz.steps.EmployeeClaimsSteps",
        monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {
}*/


