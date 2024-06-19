package mobile_refueling_dev.pages;

import com.microsoft.playwright.Page;

public class MyProfilePage {
    private final Page page;

    public MyProfilePage(Page page) {
        this.page = page;
    }

    private final String myProfileXpath = "//div[@class='cdk-overlay-container']//li[1]";
    private final String xpathOfMyProfile = "//html[1]/body[1]/uni-root[1]/uni-dashboard[1]/nz-spin[1]/div[1]/nz-layout[1]/uni-header[1]/nz-header[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/div[1]/span[1]";

    public void clickMyProfile() {
        page.locator(xpathOfMyProfile).click();
        page.locator(myProfileXpath).click();
    }

}
