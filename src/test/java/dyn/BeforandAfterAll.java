package dyn;

import org.junit.After;
import org.junit.Before;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class BeforandAfterAll {
    public static WebDriver driver;
    public static Logger logger = Logger.getLogger(BeforandAfterAll.class);

    @Before

    public void firstPage() {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe"); // chrome driver ekleme kısmı
        driver = new ChromeDriver(); // driver adında yeni bir değişken oluşturacağız
        driver.manage().window().maximize(); // açılan browserın tam ekran olabilmesini sağlar
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get("https://www.lcwaikiki.com/tr-TR/TR"); // yönlendirilecek olan sayfanın linki bulunur.
        //Assert.assertEquals("LC Waikiki - Online Alışveriş Sitesi, Moda Senin Seçimin - LC Waikiki", driver.getTitle()); // karşılaştırma işlemi yapıyor title a bakılarak şart sağlandığı anlaşılıyor.


    }
    @After   // test işlemi tamamen bittikten sonra çalışacak işlemdir bütün işlemlerin kapatılmasının sağlar
    public void closeDiver() {
        //driver.close();  // sorun gerçekleştiğinde sorunun anlayabilmek için açılabn browserin kapanmaması için bu kısım çalıştırılmamaktadır.
        System.exit(0);  // çalıştırma işlemi sonlanır

    }


}
