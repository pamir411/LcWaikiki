package dyn;

import org.openqa.selenium.By;

public class datas {
    public static final By LOGIN_BUTON = By.cssSelector("#header__container > div > header > div.header-middle > div > div.header-right > div:nth-child(2) > div:nth-child(1) > a");
    public static final By USERNAME_TEXT = By.id("LoginEmail");
    public static final String USERNAME = "latifbyk@gmail.com";
    public static final By PASSWORD_TEXT = By.id("Password");
    public static final String PASSWORD = "A11212345";
    public static final By SUBMIT_BUTON = By.id("loginLink");
    public static final By MYACCOUNT = By.xpath("//span[text()=\"Hesabım\"]");
    public static final By SEARCH_BAR = By.id("search_input");
    public static final String SEARCHWORD = "pantolon";
    public static final By SEARCH_BUTON = By.cssSelector("button.searchButton");
    public static final By NEXT_PAGE = By.xpath("//p[text()='Daha Fazla Ürün Gör']");
    public static final By RANDOM_STAFF = By.cssSelector("div[class='emi-item fav']");
    public static final By FIRST_ = By.xpath("//div[@class='col-md-4 price-area']//span[@class='price']");
    public static final By SECOND_ = By.cssSelector("span[class='rd-cart-item-price mb-15']");
    public static final By PANT_OPTION_SIZE = By.xpath("//div[@id='option-size']//a[@key='1']");
    public static final By ADD_BASKET = By.id("pd_add_to_cart");
    public static final By BASKET_TITLE = By.cssSelector("a[class='header-cart']");
    public static final By PRODUCT_INCREASE = By.cssSelector("a[class='oq-up plus']");
    public static final By ITEM_DELETE = By.cssSelector("a[title='Sil']");
    public static final By ITEM_DELETE_CONFIRM = By.cssSelector("a[class='inverted-modal-button sc-delete ins-init-condition-tracking']");

}
