package mobile_refueling_dev.pages;

import com.microsoft.playwright.Page;

import static mobile_refueling_dev.pages.Locators.LocatorsOfLoginLogoutPage.*;

public class LoginLogoutPage {

    private final Page page;
    public LoginLogoutPage(Page page) {
        this.page = page;
    }
    public void login(String username, String password) {
        page.locator(xpathOfUsername).fill(username);
        page.locator(xpathOfPassword).fill(password);
        page.locator(xpathOfSignIn).click();
        assert page.textContent(xpathOfConveniencePay).equals("Convenience Pay");
    }
    public void Logout() {
        page.locator(xpathOfMyProfile).click();
        page.locator(xpathOfLogout).click();
    }
    public MyProfilePage navigateToMyProfile() {
        return new MyProfilePage(page);
    }
    public MerchantRegistrationPage merchantRegistrationPage() {
        return new MerchantRegistrationPage(page);
    }
}
