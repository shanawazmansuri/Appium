package com.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;

public class Swipe {
	
	AndroidDriver driver;

	@BeforeMethod
	public void setup() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.VERSION, "13");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability("appPackage", "com.wdiodemoapp");
		cap.setCapability("appActivity", "com.wdiodemoapp.SplashActivity");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability("noReset", true);

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}

	@Test
	public void SignUp() {

		driver.findElement(By.xpath("//android.widget.Button[@content-desc='Login']")).click();

		driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='button-sign-up-container']")).click();
		driver.findElement(MobileBy.AccessibilityId("input-email")).sendKeys("AbdulMa@gmail.com");
		
		
	}
		

}
