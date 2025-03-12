package habitnu_assignment;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import org.openqa.selenium.WebDriver;

public class ListenerClass implements ITestListener {

    public static void takeScreenshot(WebDriver driver, String screenshotType, String description) {
		try {
			File theDir = new File("/screenshots");
			if (!theDir.exists()) {
				theDir.mkdirs();
			}

			TakesScreenshot scrShot = ((TakesScreenshot) driver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

			File DestFile = new File("screenshots/screenshot.png");
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenshot(AppTest.driver, "TestFail", result.getName());
    }
}