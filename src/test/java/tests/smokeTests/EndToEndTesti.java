package tests.smokeTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MyCoursedemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class EndToEndTesti {
    /*
      E2E (End to end testi, uctan uca bir islevin tum asamalarini
      gerceklestirerek, islevin calistigini test etmek demektir

       Bir uygulamada bircok e2e testi olabilir
     */

    @Test
    public void e2eKursOlusturmaTesti(){
        // MyCoursedemy sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("myUrl"));
        // gecerli kullanici adi ve sifre girerek sisteme login olun
        MyCoursedemyPage myCoursedemyPage= new MyCoursedemyPage();
        myCoursedemyPage.loginMethodu();
        // Instructor linkini tiklayin
        myCoursedemyPage.instructorLinki.click();
        // course manager linkine tiklayin
        myCoursedemyPage.courseManagerLinki.click();
        // add New Course butonuna tiklayin
        myCoursedemyPage.addNewCourseButonu.click();
        // course title bilgisi girin
        myCoursedemyPage.courseTitleKutusu.sendKeys(ConfigReader.getProperty("myCourseTitle"));
        // category menusune tiklayin
        myCoursedemyPage.categoryMenusu.click();
        // ilgili kurs kategorisini secin
        myCoursedemyPage.categorySecimi.click();
        // next butonuna basalim
        myCoursedemyPage.ilkNextButonu.click();
        // tekrar next butonuna basalim
        myCoursedemyPage.ilkNextButonu.click();
        // tekrar next butonuna basalim
        myCoursedemyPage.ilkNextButonu.click();
        // price kutusuna fiyati yazdiralim
        myCoursedemyPage.coursePrice.sendKeys(ConfigReader.getProperty("myCoursePrice"));
        // indirim kutusuna %50 yazalim
        myCoursedemyPage.discountKutusu.sendKeys(ConfigReader.getProperty("myDiscount"));
        // tekrar next butonuna basalim
        myCoursedemyPage.ilkNextButonu.click();
        // tekrar next butonuna basalim
        myCoursedemyPage.ilkNextButonu.click();
        // meta keywords kutusuna java kursu yazdiralim
        myCoursedemyPage.metaKeywordsKutusu.sendKeys(ConfigReader.getProperty("myMetaKeywords"));
        // tekrar next butonuna basalim
        myCoursedemyPage.ilkNextButonu.click();
        // submit butonuna basalim
        myCoursedemyPage.submitButonu.click();
        // yeni kursun olusturuldugunu test edin
        Assert.assertTrue(myCoursedemyPage.backToCourseListButonu.isEnabled());

        Driver.closeDriver();
    }
}
