package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {


    static WebDriver driver;
    public static WebDriver getDriver(){
        WebDriverManager.chromedriver().setup();

        if(driver==null) {// method ilk cagrildiginda driver degeri atanmamis oldugundan deger ata
                          // sonraki calistirmalarda degeri atanmis oldugundan 18.satir calismayacak
            driver = new ChromeDriver();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
      return driver;
    }

    public static void closeDriver(){
        if (driver!=null){
            driver.close();
            driver=null;
        }

    }
}
