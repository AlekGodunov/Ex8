package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.time.Duration;

import junit.framework.TestCase;

public class CoreTestCase extends TestCase {

    protected AppiumDriver driver;
    private static String AppiumURL = "http://127.0.0.1:4723/wd/hub";


    @Override
    protected void setUp() throws Exception {

        super.setUp();
        DesiredCapabilities capabilites = new DesiredCapabilities();

        capabilites.setCapability("platformName","Android");
        capabilites.setCapability("deviceName","AndroidTestDevice");
        capabilites.setCapability("platformVersion","8.0");
        capabilites.setCapability("automationName","Appium");
        capabilites.setCapability("appPackage","org.wikipedia");
        capabilites.setCapability("appActivity",".main.MainActivity");
        capabilites.setCapability("app","/Users/Godunov/IdeaProjects/Ex8/apks/org.wikipedia.apk");

        driver = new AndroidDriver(new URL(AppiumURL), capabilites);
        this.rotateScreenPortrait();
    }

    @Override
    protected void tearDown() throws Exception {

        driver.quit();
        super.tearDown();
    }

    protected void rotateScreenPortrait(){

        driver.rotate(ScreenOrientation.PORTRAIT);

    }

    protected void rotateScreenLandscape(){

        driver.rotate(ScreenOrientation.LANDSCAPE);

    }

    protected void backgrounApp(int seconds){

        driver.runAppInBackground(seconds);

    }

    public static void waitInSeconds(int secondsToWait){

        int waitIntervalMillis = secondsToWait * 1000;
        try {
            Thread.sleep(waitIntervalMillis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}