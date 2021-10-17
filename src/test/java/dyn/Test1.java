package dyn;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;


import static dyn.datas.*;  // giriş bilgileri veya site içerisinde seçimi sağlamak için buton isimlerinin tutulduğu kısımdır.

public class Test1 extends BeforandAfterAll { // BeforandAterAlldan türetildiğini göstermekteyiz.
    public static String firstt;
    public static String secondd;


    @Test    // açılış ve kapapnış işlemleri arasında gerçekleştirilen kısımdır. testler bu etiket sayesinde yapılır.
    public void login() throws InterruptedException {     // Login kısmına gerçekleştirilecek işlemlerin bulunduğu kısımdır.
        Methods.waitClicableClick(By.xpath("//button[text()=\"Anladım\"]"));   // çerezlere erişmek için izin isteğinin bulunduğu kısmın yapılan işlemlere engel olma ihtimaline karşı denenmiş bir click methodudur.
        Methods.waitClicableClick(LOGIN_BUTON);   // Login üzerine gelindikten sonra click işleminin yapıldığı methodun bulunduğu kısımdır.
        Methods.waitVisibilitySendKey(USERNAME_TEXT, USERNAME);    // Login ekranına giriş sağlandıktan sonra bizdenn istenen eposta adresinin daha önceden datasda kaydettiğimiz bilgiler içinden çekilerek uygun kısma yazdırılması.
        Methods.waitVisibilitySendKey(PASSWORD_TEXT, PASSWORD);     //key olarak vermiş olduğumuz değişkenleri kullananblmek için waitVisibilitySendKey kullanılmıştır.
        Methods.waitClicableSubmit(SUBMIT_BUTON);                   //text box üzerinden bilgilerin girildikten sonra onaylamak için butona tıklamamızı sağlamaktadır. gerçekleştirilen işlemler sayfanın tamamen açıldıktan sonra gerçekleşmesi gerekmektedir.Aynı zamanda işlemler gerçekleştirildikten sonra beklenilmesi gerekmektedir böylelikle üst üste işlem yığını oluşmamış olur bu bekleme gözle görülecekten bile daha azdır.
        Assert.assertEquals(Methods.findElement(MYACCOUNT).isDisplayed(), true);     // giriş işlemi yapıldıktan sonra test işleminin işleyişinin doğru olması için giriş işleminden sonra yönlendirilen anan sayfada giriş işlemi doğru olduğunu sağ üst köşede giriş yapmış olduğumuz butonun hesabıma dönmesi ile anlamış oluruz bu işlem eğer yanlış ise bize hata geri dönüş exeptini fırlatır.
        logger.info("Login işlemi başarılı!");    // loglama ilede bu işlemlerin gerçekleştiğine dair geri dönüş infosu elde etmiş oluruz.
        searchAndSelectProduct();
    }

    @Test
    public void searchAndSelectProduct() throws InterruptedException {              // arama kısnda gerçekleştirilecek olan işlemlerin bulunduğu sınıf
        Methods.waitClicableClick(By.xpath("//button[text()=\"Anladım\"]"));        //çerezlerin kapatılmasını sağlamak için yazılmış bir method
        Methods.clearToElement(SEARCH_BAR);                                         // aramam kısmının bulunduğu kısımda otomatik gelen yazıyı siler.
        Methods.waitVisibilitySendKey(SEARCH_BAR,SEARCHWORD);                       // burada ise search bara tıklandıktan sonra datasda daha önceden belirtmiş olduğumuz kelime olarka pantalon kelimesini datasdan çekip searc ba kısmına yazdırmamızı sağlamaktadır.
        Methods.waitVisibilityClick(SEARCH_BUTON);                                  // burada ise yazılmış olan kelimeden sonra arama işlemini yapabilemek için gerçekleştirilen method yazılmıştır.
        Methods.hoverElement(NEXT_PAGE);
        Methods.waitVisibilityClick(NEXT_PAGE);
        List<WebElement> links = driver.findElements(RANDOM_STAFF);
        System.out.println("boyutu : " + links.size());
        Random productSize = new Random();
        int randomNumber = productSize.nextInt(links.size());
        System.out.println("Random üretilen Sayı:" + randomNumber);
        Methods.waitClicableClick(By.xpath("/html/body/div[5]/div[3]/div[2]/div[7]/div/div[1]/div["+randomNumber+"]"));
        addBasket();
    }

    @Test
    public void addBasket() throws InterruptedException {
        Thread.sleep(3000);
        firstt = Methods.getPrice(FIRST_);
        System.out.println("ilk sayfa fiyat "+firstt);
        Methods.waitClicableClick(PANT_OPTION_SIZE);
        Methods.waitClicableClick(ADD_BASKET);
        goBasket();
    }

    @Test
    public void goBasket() throws InterruptedException {

        Methods.waitClicableClick(BASKET_TITLE);
        secondd = Methods.getPrice(SECOND_);
        System.out.println("sepette indirim varsa duruma göre ikinci fiyat "+secondd);
        checkPriceControl();
    }

    @Test
    public void checkPriceControl() throws InterruptedException {
        System.out.println(firstt+"ilk sayfa fiyat");
        System.out.println(secondd+"sepette indirim varsa duruma göre ikinci fiyat");

        if (firstt == secondd) {
            logger.info("ilk ve ikinci aynı");

        } else {
            logger.error("sıkıntı yok");
        }
        checkItemAndPrice();
    }


    @Test
    public void checkItemAndPrice()throws InterruptedException{
        Methods.waitClicableClick(PRODUCT_INCREASE);
        Thread.sleep(5000);
        Methods.waitClicableClick(ITEM_DELETE);
        Methods.waitClicableClick(ITEM_DELETE_CONFIRM);
    }



}
