package tests.day19_dataProvider;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_DataProvider {
    @DataProvider
    public static Object[][] AranacakKelimeProvider() {

        Object[][] arananKelimeler= {{"Nutella"},{"Java"},{"Apple"},{"Samsung"},{"TV"}};

        return arananKelimeler;
    }


    // Amazon anasayfaya gidin
    // Nutella, Java, Apple, Samsung, TV icin arama yapin
    // Arama sonuclarinin aranan kelime icerdigini test edin




    @Test(dataProvider = "AranacakKelimeProvider")
    public void aramaTesti(String aranacakKelime){
        // Amazon anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        // Nutella, Java, Apple, Samsung, TV icin arama yapin
        AmazonPage amazonPage=new AmazonPage();
        amazonPage.aramaKutusu.sendKeys(aranacakKelime + Keys.ENTER);
        // Arama sonuclarinin aranan kelime icerdigini test edin

        String actualSonucYazisi=amazonPage.aramaSonucElementi.getText();
        ReusableMethods.bekle(3);
        Assert.assertTrue(actualSonucYazisi.contains(aranacakKelime));

    }
}
