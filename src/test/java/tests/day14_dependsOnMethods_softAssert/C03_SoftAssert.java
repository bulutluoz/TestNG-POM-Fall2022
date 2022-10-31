package tests.day14_dependsOnMethods_softAssert;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C03_SoftAssert {

    @Test
    public void hardAssertTesti(){
        // verilen bir sifrenin sartlari saglayip saglamadigini test edin
        // 1- Ilk harf Buyuk harf olmali
        // 2- Son harf kucuk harf olmali
        // 3- sifre bosluk icermemeli
        // 4- uzunlugu en az 8 karakter olmali
        /*
          assertion islemi yapilirken
          ilk bulunan hatada kodun calismasi durdurulur (stop execution)

            Assert class'indaki method'lar static olduklari icin
            classIsmi.methodIsmi ile cagrilirlar
         */

        String sifre="JavAahjava";
        // 1- Ilk harf Buyuk harf olmali
        boolean ilkHarfKontrolu= sifre.charAt(0)>='A' && sifre.charAt(0)<='Z';
        Assert.assertTrue(ilkHarfKontrolu,"Ilk harf buyuk harf olmali");

        // 2- Son harf kucuk harf olmali
        boolean sonHarfKontrolu= sifre.charAt(sifre.length()-1)>='a' && sifre.charAt(sifre.length()-1)<='z';
        Assert.assertTrue(sonHarfKontrolu,"Son harf kucuk harf olmali");

        // 3- sifre bosluk icermemeli

        Assert.assertFalse(sifre.contains(" "),"Sifre bosluk icermemeli");
        // 4- uzunlugu en az 8 karakter olmali
        Assert.assertTrue(sifre.length()>=8, "uzunluk en az 8 karakter olmali");

        // 5- tum sartlari sagliyorsa sifre basari ile kaydedildi yazdirin
        System.out.println("Sifreniz basari ile kaydedildi");
    }

    @Test
    public void softAssertTesti(){

        /*
          jUnit'de de kullandigimiz Assert class'i ilk failed olan assertion'da
          calismayi durdurur ve hata mesaji verir

          Eger ilk hatada durmasini degil, devam edip sona kadar tum testleri yapmasini
          ve en sonunda durumu raporlayip, failed olan varsa
          calismayi durdurmasini istiyorsaniz
          SoftAssert class'ini kullanabilirsiniz

          SoftAssert clas'indaki method'lar static degildir,
          SoftAssert class'indaki method'lari kullanmak icin obje olusturmaliyiz


          Genellikle
          hard Assertion kullanmamiz istendiginde test edin (Test)
          soft Assertion kullanmamiz istendiginde dogrulayin (Verify) kelimeleri kullanilir.
         */
        // A.adim softAssert objesi olustur
        SoftAssert softAssert= new SoftAssert();

        // B.istenen tum assertion'lari softAssert objesini kullanarak yapin
        String sifre="JavAahJava";
        // 1- Ilk harf Buyuk harf olmali
        boolean ilkHarfKontrolu= sifre.charAt(0)>='A' && sifre.charAt(0)<='Z';
        softAssert.assertTrue(ilkHarfKontrolu,"Ilk harf buyuk harf olmali");

        // 2- Son harf kucuk harf olmali
        boolean sonHarfKontrolu= sifre.charAt(sifre.length()-1)>='a' && sifre.charAt(sifre.length()-1)<='z';
        softAssert.assertTrue(sonHarfKontrolu,"Son harf kucuk harf olmali");

        // 3- sifre bosluk icermemeli

        softAssert.assertFalse(sifre.contains(" "),"Sifre bosluk icermemeli");
        // 4- uzunlugu en az 8 karakter olmali
        softAssert.assertTrue(sifre.length()>=8, "uzunluk en az 8 karakter olmali");

        // C. Tum testler bitince, isimiz bitti yapilan tum assert'leri raporla dememiz gerekir
        //    bir tane bile failed varsa bu satirda kodun calismasi durdurulur

        softAssert.assertAll();



        // 5- tum sartlari sagliyorsa sifre basari ile kaydedildi yazdirin
        System.out.println("Sifreniz basari ile kaydedildi");

    }
}
