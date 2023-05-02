package com.tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class SignUpTest {

	AndroidDriver driver;

	@BeforeMethod
	public void setup() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability("appPackage", "com.wdiodemoapp");
		cap.setCapability("appActivity", "com.wdiodemoapp.SplashActivity");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability("noReset", true);

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}
	
	
	public void tap(WebElement ele)
	{
		AndroidTouchAction tou = new AndroidTouchAction(driver);
		tou.tap(TapOptions.tapOptions().withElement(ElementOption.element(ele))).perform();
		
	}

	@Test
	public void SignUp() {

		AndroidTouchAction to = new AndroidTouchAction(driver);

		
		
		
		WebElement log = driver.findElement(By.xpath("//android.widget.Button[@content-desc='Login']"));
		tap(log);
		

		WebElement signUp = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='button-sign-up-container']"));
		tap(signUp);
		
		driver.findElement(MobileBy.AccessibilityId("input-email")).sendKeys("AbdulMa@gmail.com");
		
		
		driver.findElement(MobileBy.AccessibilityId("input-password")).sendKeys("AbdulMa123");
		
		driver.findElement(MobileBy.AccessibilityId("input-repeat-password")).sendKeys("AbdulMa123");
		
		WebElement signUpBtn = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc='button-SIGN UP']"));
		tap(signUpBtn);
		
		
		String text = driver.findElement(By.id("android:id/message")).getText();
		System.out.println(text);
		Assert.assertEquals(text, "You successfully signed up!");
		
		
		WebElement okBBtn = driver.findElement(By.id("android:id/button1"));
		tap(okBBtn);
		
		
		LongPressOptions lo = new LongPressOptions();
		lo.withDuration(Duration.ofSeconds(5000)).withElement(ElementOption.element(okBBtn));
		
		to.longPress(lo).release().perform();
		
		
		
		
		

	}

}
