package tests.day15_pageObjectModel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_PagesKullanimi {

    // Amazon anasayfaya gidin
    // 3 test method'u olusturun
    // Herbir method'da Nutella, Java, Bicycle icin arama yapip,
    // sonuclarin arama yaptigimiz kelimeleri icerdigini test edin
    AmazonPage amazonPage=new AmazonPage();
    @Test(dependsOnMethods = "bicycleTesti")
    public void nutellaTesti(){
        amazonPage.aramaKutusu.clear();
        amazonPage.aramaKutusu.sendKeys("nutella"+Keys.ENTER);
        String actualAramaSonucu= amazonPage.aramaSonucElementi.getText();
        String expectedKelime="nutella";
        Assert.assertTrue(actualAramaSonucu.contains(expectedKelime));


        ReusableMethods.bekle(5);
        Driver.closeDriver();
    }

    @Test(dependsOnMethods = "bicycleTesti",groups = "smoke")
    public void javaTesti(){
        amazonPage.aramaKutusu.clear();
        amazonPage.aramaKutusu.sendKeys("java"+Keys.ENTER);
        String actualAramaSonucu= amazonPage.aramaSonucElementi.getText();
        String expectedKelime="java";
        Assert.assertTrue(actualAramaSonucu.contains(expectedKelime));
    }

    @Test(groups = "smoke")
    public void bicycleTesti(){
        Driver.getDriver().get("https://www.amazon.com");
        amazonPage.aramaKutusu.sendKeys("bicycle"+ Keys.ENTER);
        String actualAramaSonucu= amazonPage.aramaSonucElementi.getText();
        String expectedKelime="bicycle";
        Assert.assertTrue(actualAramaSonucu.contains(expectedKelime));

    }
}
