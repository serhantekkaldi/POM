package tests.day16;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ConcortHotelPage;
import pages.QAConcortPage;

public class C02_WebTable {
    @Test
    public void test() throws InterruptedException {
        // https://qa-environment.concorthotel.com/ adresine gidin
        //        username : manager
        //        Password : Manager1!
        QAConcortPage qaConcortPage=new QAConcortPage();
        qaConcortPage.ConcortHotelLogin();
        qaConcortPage.hotelManagement.click();
        qaConcortPage.hotelRoomLink.click();
        // table() methodu olusturun
        //      - Tüm table body sinin boyutunu(sütun sayisini) bulun. /tbody
        for (WebElement each:qaConcortPage.basliklarListesi
             ) {
            System.out.println(each.getText());
        }
        //      - Table daki tüm body'i ve basliklari(headers) konsolda yazdirin.
        // aciklama: Eger tüm tablo body sini hücrelere ayirmadan tek bir String olarak görmek istersek tüm body i tek
        // bir WebElement olarak locate edebiliriz.
        // BU yaklasim , tabloda HAPPY HOTEL var mi gibi sorular icin ideal bir cözümdür.
        System.out.println(qaConcortPage.tBodyTumu.getText());
        Thread.sleep(2000);
        Assert.assertTrue(qaConcortPage.tBodyTumu.getText().contains("Star Hotel"));

        for (WebElement each:qaConcortPage.basliklarListesi
        ) {
            System.out.println(each.getText());
        }
        // printRows() metodu olusturun // tr
        //      - table body sinde bulunan toplam satir(row) sayisini bulun
        System.out.println("Tablodaki satir sayisi: " + qaConcortPage.satirlarListesi.size());

        //      - table body sinde bulunan satirlari(rows)  konsolda yazdirin
        System.out.println("Birinci satir: " + qaConcortPage.birinciSatir.getText());

        // eger tüm satirlari yazdirmak istersek
        for (int i=0; i<qaConcortPage.satirlarListesi.size(); i++){
            System.out.println(i+1 + ".satir" + qaConcortPage.satirlarListesi.get(i).getText());
        }


    }
}
