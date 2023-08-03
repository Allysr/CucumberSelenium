package baseUtil;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseUtil {
    public static final String LOGIN = "https://seubarriga.wcaquino.me/login";
    public WebDriver browser;

    public void loginPage(){
        System.setProperty("webdriver.chrome.driver","drive/chromedriver.exe");
        this.browser = new ChromeDriver();
        this.browser.navigate().to(LOGIN);
    }

    public void fecharNavegador(){
        this.browser.quit();
    }
}
