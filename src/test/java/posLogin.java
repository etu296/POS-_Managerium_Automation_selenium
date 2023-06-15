import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.URL;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class posLogin {
    private static WindowsDriver posSession = null;
    public static String getDate(){
        LocalDate date = LocalDate.now();
        return date.toString();
    }
    @BeforeTest
    public static  void setUp(){
        try{
            DesiredCapabilities capabilities = new  DesiredCapabilities();
            capabilities.setCapability("app","C:\\Program Files\\WindowsApps\\CF9BD7D4-0F9A-4730-8950-05D032861D46_2.0.71.0_x64__4rafj02apad6w\\POS.exe");
            capabilities.setCapability("platformName","Windows");
            capabilities.setCapability("deviceName","WindowsPC");
            posSession = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
            posSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //    @AfterMethod
//    public void closeApp()
//    {
//        notepadSession.quit();
//        setUp();
//    }
//    @AfterSuite
//     public void treatDown()
//     {
//         notepadSession.quit();
//     }
    @Test(priority = 0, description = "test case-01, open POS & login")
    public  void loginPos()
    {
        posSession.findElementByName("User ID").sendKeys("01313225159");
        posSession.findElementByName("Password").sendKeys("123456");
        posSession.findElementByName("Login").click();


    }
    @Test(priority = 1, description = "test case-02, add item by typing barcode")
    public  void addItemPos()
    {
        posSession.findElementByName("Scan or enter Barcode (Alt+B) ........").sendKeys("1212");
        WebElement pressEnter1 = posSession.findElementByName("Scan or enter Barcode (Alt+B) ........");
        pressEnter1.sendKeys(Keys.ENTER);

    }

    @Test(priority = 2, description = "test case-03, add customer")
    public  void addCustomerPos()
    {
        posSession.findElementByName("Enter Customer No (Alt+M)....").sendKeys("999");
        WebElement pressEnter3 = posSession.findElementByName("Enter Customer No (Alt+M)....");
        pressEnter3.sendKeys(Keys.ENTER);

    }
    @Test(priority = 3, description = "test case-04, go to cash amount")
    public  void addQuantity()
    {
        WebElement pressF8 = posSession.findElementByName("1.0");
        pressF8.sendKeys(Keys.F8);
        pressF8.sendKeys("5");
        WebElement pressEnter4=posSession.findElementByName("1.0");
        pressEnter4.sendKeys(Keys.ENTER);

    }
    @Test(priority = 4, description = "test case-05, Exchange an invoice")
    public  void returnInvoice() throws InterruptedException
    {
        posSession.findElementByName("User ID").sendKeys("01313225159");
        posSession.findElementByName("Password").sendKeys("123456");
        posSession.findElementByName("Login").click();

        Thread.sleep(2000);
        posSession.findElementByName("Exchange /Return (F5)").click();
        posSession.findElementByName("Search Invoice").sendKeys("12823061515163300001");
        WebElement pressEnter5=posSession.findElementByName("Search Invoice");
        pressEnter5.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        posSession.findElementByAccessibilityId("btnExchangeView").click();
        Thread.sleep(2000);
        posSession.findElementByAccessibilityId("PrimaryButton").click();
        Thread.sleep(2000);
        posSession.findElementByName("Scan or enter Barcode (Alt+B) ........").sendKeys("1212");
        WebElement pressEnter6 = posSession.findElementByName("Scan or enter Barcode (Alt+B) ........");
        pressEnter6.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        WebElement pressF8 = posSession.findElementByName("1.0");
        pressF8.sendKeys(Keys.F8);
        pressF8.sendKeys("10");
        WebElement pressEnter4=posSession.findElementByName("1.0");
        pressEnter4.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        posSession.findElementByAccessibilityId("textBoxCashAmount").sendKeys("8");
        WebElement pressEnter7 =posSession.findElementByAccessibilityId("textBoxCashAmount");
        pressEnter7.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

//        posSession.findElementByName("Print").click();



    }

}