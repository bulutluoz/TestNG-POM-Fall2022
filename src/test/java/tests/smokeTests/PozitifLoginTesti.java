package tests.smokeTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MyCoursedemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class PozitifLoginTesti {


    @Test
    public void pozitifLoginTesti(){
        // Mycoursedemy anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("myUrl"));
        // login linkine basin
        MyCoursedemyPage myCoursedemyPage=new MyCoursedemyPage();
        myCoursedemyPage.loginLinki.click();
        // Kullanici email'i olarak valid email girin
        myCoursedemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("myGecerliEmail"));
        // Kullanici sifresi olarak valid sifre girin
        myCoursedemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("myGecerliPassword"));
        // Login butonuna basarak login olun
        myCoursedemyPage.loginButonu.click();
        // Basarili olarak giris yapilabildigini test edin

        Assert.assertTrue(myCoursedemyPage.coursesLinki.isDisplayed());

        ReusableMethods.bekle(5);
        Driver.closeDriver();
    }
}
