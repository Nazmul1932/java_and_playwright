package mobile_refueling_dev.TestCases;

import com.microsoft.playwright.Page;
import mobile_refueling_dev.pages.LoginLogoutPage;
import mobile_refueling_dev.pages.MerchantRegistrationPage;
import mobile_refueling_dev.pages.MyProfilePage;
import mobile_refueling_dev.utils.PlayWrightFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {
    PlayWrightFactory playWrightFactory;
    Page page;
    protected LoginLogoutPage loginLogoutPage;
    protected MyProfilePage myProfilePage;
    protected MerchantRegistrationPage merchantRegistrationPage;
    protected Properties properties;

    @BeforeTest
    public void setUp() {
        playWrightFactory = new PlayWrightFactory();
        properties = playWrightFactory.initProperties();
        page = playWrightFactory.initBrowser(properties);
        loginLogoutPage = new LoginLogoutPage(page);
    }

    @AfterTest
    public void tearDown() {
        playWrightFactory.stopTracing();
        if (page != null) {
            page.context().browser().close();
        }
    }
}
