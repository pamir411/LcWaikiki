package dyn;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Methods extends BeforandAfterAll {

    public static WebDriverWait wait = new WebDriverWait(driver, 30);

    public static void hoverElement(By by) {
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(by);
        action.moveToElement(we).build().perform();
        logger.info(by+"elementin üzerine geldi");
    }

    public static WebElement findElement(By by) {
        return driver.findElement(by);


    }
    public static void waitVisibilityClick(By by) {
        WebElement web=wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        web.click();
        logger.info(by+"görüldü ve tıklan");
    }

    public static void waitClicableClick(By by) {
        WebElement we =wait.until(ExpectedConditions.elementToBeClickable(by));
        we.click();
        logger.info(by+"ggörüldü ven tıklandı!");

    }

    public static void waitVisibilitySendKey(By by, String key) {
        WebElement we= wait.until(ExpectedConditions.elementToBeClickable(by));
        we.sendKeys(key);
        logger.info(by+"'lı  görüldü   "+key+" değerimiz girildi");

    }

    public static void waitClicableSubmit(By by) {
        WebElement we= wait.until(ExpectedConditions.elementToBeClickable(by));
        we.submit();
        logger.info(by+"submit butonun tıklandı ");
    }
    public static String getPrice(By priceText)
    {
        String elementString = findElement(priceText).getText();
        return elementString;

    }
    public static void clearToElement(By key) {

        findElement(key).clear();
    }



}
