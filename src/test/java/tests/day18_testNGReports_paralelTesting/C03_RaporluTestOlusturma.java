package tests.day18_testNGReports_paralelTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class C03_RaporluTestOlusturma extends TestBaseRapor {

    @Test
    public void test01(){
        extentTest=extentReports.createTest("Dropdown Testi","Dropdown'da istenen element oldugunu test etme");
        // amazon anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        extentTest.info("amazon ansayfaya gidildi");
        // arama kutusunun yanindaki dropdown menuyu locate edin
        // dropdown menudeki tum options listesini olusturup
        AmazonPage amazonPage=new AmazonPage();
        Select select=new Select(amazonPage.dropdownMenu);
        extentTest.info("Dropdown menu locate edildi");
        List<WebElement> optionsElementList= select.getOptions();

        // menude Electronics basligi oldugunu test edin
        List<String> optionsStringListesi= ReusableMethods.getElementsText(optionsElementList);
        extentTest.info("Dropdown menudeki tum option'lar bir list olarak kaydedildi");
        Assert.assertTrue(optionsStringListesi.contains(ConfigReader.getProperty("dropdownArananOption")));
        extentTest.pass("Dropdown menude aranan kelime oldugu test edildi");
        Driver.closeDriver();
    }
}
