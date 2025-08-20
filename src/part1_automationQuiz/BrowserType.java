package part1_automationQuiz;

import Utils.Page;

/**
 * Created by fanxuejuan on 2025/8/20.
 */
public class BrowserType {
    public static void setupChromeBrowser()
    {
        String ChromeDriverPath= Page.getPropertie("config/configration.properties","ChromeDriverPath");
        System.setProperty("webdriver.chrome.driver",ChromeDriverPath);
    }
    public static void setupEdgeBrowser()
    {
        String EdgeDriverPath= Page.getPropertie("config/configration.properties","EdgeDriverPath");
        System.setProperty("webdriver.edge.driver", EdgeDriverPath);
    }
}
