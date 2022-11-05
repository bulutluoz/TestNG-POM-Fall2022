package tests.day15_pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

public class C01_DriverIlkClass {
        /*
      POM de 4 farkli dosyadan ihtiyacimiz olan bilgileri aliriz
      1- Driver class == driver
      2- pages package altindaki page class'lari == locate
      3- configurtaion.properties dosyasi == test datalari
      4- Reusable methods class == ihtiyac duyabilecegimiz pratik method'lar

      Daha once kullandigimiz extends keyword ile inheritance sadece 1 class'a olabileceginden
      POM'de tercih edilmemistir

      Java'da bir class'daki class uyelerini kullanmanin farkli yollari vardir

      1- extends ile inherit edip direk kullanma
      2- class uyelerini static tanimlayip classAdi.uyeAdi seklinde kullanabiliriz
      3- istedigimiz class'dan obje olusturarak class uyelerini kullanabiliriz

      POM 2 yontemi de kullanir.
     */

    @Test
    public void test01() throws InterruptedException {

        Driver.getDriver().get("https://www.amazon.com");
        /*
          Driver class'indaki getDriver() icerisinde
          driver= new ChromeDriver(); satiri her calistiginda yeni bir driver olusturur
          yani yeni bir browser acar

          Bizim istedigimiz
          bir test calismaya basladiginda driver'a bir kere new ChromeDriver() ile deger atasin
          sonraki calistirmalarda bu satiri pass gecsin


         */
        // arama kutusuna Nutella yazdirip aratalim
        Thread.sleep(3000);
        WebElement aramaKutusu= Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        Driver.getDriver().get("https://www.wisequarter.com");

        Driver.closeDriver();
    }

    @Test
    public void test2(){


        Driver.closeDriver();
    }
}
