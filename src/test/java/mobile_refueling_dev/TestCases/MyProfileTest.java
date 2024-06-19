package mobile_refueling_dev.TestCases;

import org.testng.annotations.Test;

public class MyProfileTest extends BaseTest {
    @Test
    public void testNavigateMyProfile() throws InterruptedException {

        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        loginLogoutPage.login(username.trim(), password.trim());
        myProfilePage = loginLogoutPage.navigateToMyProfile();
        myProfilePage.clickMyProfile();
        Thread.sleep(2000);
        loginLogoutPage.Logout();
    }
}
