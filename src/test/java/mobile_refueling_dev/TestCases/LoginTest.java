package mobile_refueling_dev.TestCases;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    @Test
    public void testLogin() {
        String username = properties.getProperty("username"); // Can be null
        String password = properties.getProperty("password"); // Can be null

        try {
            loginLogoutPage.login(
                    username != null ? username.trim() : null,
                    password != null ? password.trim() : null
            );
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        }
    }
}
