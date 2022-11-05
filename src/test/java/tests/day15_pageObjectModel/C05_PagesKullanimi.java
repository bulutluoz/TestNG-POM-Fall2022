package tests.day15_pageObjectModel;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C05_PagesKullanimi {

    @Test
    public void test01(){
        //1- https://www.facebook.com/ adresine gidin
        Driver.getDriver().get("https://www.facebook.com/");
        //2- POM’a uygun olarak email, sifre kutularini ve giris yap butonunu locate edin

        //3- Faker class’ini kullanarak email ve sifre degerlerini yazdirip, giris butonuna basin
        Faker faker=new Faker();
        FacebookPage facebookPage=new FacebookPage();
        facebookPage.cerezler.click();

        facebookPage.facebookEmailKutusu.sendKeys(faker.internet().emailAddress());
        facebookPage.facebookPasswordKutusu.sendKeys(faker.internet().password());
        facebookPage.girisButonu.click();
        //4- Basarili giris yapilamadigini test edin
        Assert.assertTrue(facebookPage.girilemediYaziElementi.isDisplayed());

        ReusableMethods.bekle(5);
    }
}
