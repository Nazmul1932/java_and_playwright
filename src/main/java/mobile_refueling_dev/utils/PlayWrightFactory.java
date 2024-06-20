package mobile_refueling_dev.utils;

import com.microsoft.playwright.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Base64;
import java.util.Properties;

import static mobile_refueling_dev.utils.FilePath.CONFIGURATION_PATH;

public class PlayWrightFactory {

    private static final ThreadLocal<Playwright> playwrightThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<Browser> browserThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> browserContextThreadLocal = new ThreadLocal<>();
    private static final ThreadLocal<Page> pageThreadLocal = new ThreadLocal<>();

    private Properties properties;

    public static Playwright getPlaywright() {
        return playwrightThreadLocal.get();
    }

    public static Browser getBrowser() {
        return browserThreadLocal.get();
    }

    public static BrowserContext getBrowserContext() {
        return browserContextThreadLocal.get();
    }

    public static Page getPage() {
        return pageThreadLocal.get();
    }

    public Page initBrowser(Properties properties) {
        this.properties = properties;
        String browserName = properties.getProperty("browser").trim().toLowerCase();
        playwrightThreadLocal.set(Playwright.create());
        browserThreadLocal.set(initBrowserInstance(browserName));
        browserContextThreadLocal.set(initBrowserContext());
        pageThreadLocal.set(getBrowserContext().newPage());
        getPage().navigate(properties.getProperty("url").trim());
        return getPage();
    }

    private Browser initBrowserInstance(String browserName) {
        Browser browser;
        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions().setHeadless(false)
                .setArgs(Arrays.asList("--allow-running-insecure-content", "--ignore-certificate-errors"));
        browser = switch (browserName) {
            case "chromium" -> getPlaywright().chromium().launch(options);
            case "firefox" -> getPlaywright().firefox().launch(options);
            case "safari" -> getPlaywright().webkit().launch(options);
            case "chrome" -> {
                options.setChannel("chrome");
                yield getPlaywright().chromium().launch(options);
            }
            case "edge" -> {
                options.setChannel("msedge");
                yield getPlaywright().chromium().launch(options);
            }
            default -> throw new IllegalArgumentException("Unknown browser: " + browserName);
        };
        return browser;
    }

    private BrowserContext initBrowserContext() {
        return getBrowser().newContext(new Browser.NewContextOptions()
                .setRecordVideoDir(Paths.get("Videos/"))
                .setRecordVideoSize(1280, 720)
                .setIgnoreHTTPSErrors(true)
                .setBypassCSP(true)
                .setViewportSize(1500, 900));
    }

    public Properties initProperties() {
        properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(CONFIGURATION_PATH)) {
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration file not found.", e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load configuration file.", e);
        }
        return properties;
    }

    public static String takeScreenshot() {
        String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
        byte[] buffer = getPage().screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(true));
        return Base64.getEncoder().encodeToString(buffer);
    }
}
