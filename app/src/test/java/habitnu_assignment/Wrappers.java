package habitnu_assignment;


import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Wrappers {
    
    
    public static void clickOnElement(WebDriver driver, By locator){
        
        try{
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

            WebElement clickableElement=driver.findElement(locator);
            clickableElement.click();
        }catch(Exception e){
            System.out.println("Exception! "+e.getMessage());
        }
    }

    public static String[] readData(int rownumToRead){

        String[] rowData=new String[2];

        try {
            File file =new File("./src/test/resources/TestData.xlsx");
            FileInputStream fileInputStream = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

            XSSFSheet sheet = workbook.getSheet("Data");
            XSSFRow row=sheet.getRow(rownumToRead);

            if (row != null) {
                rowData[0] = row.getCell(0).getStringCellValue();  // Departure
                rowData[1] = row.getCell(1).getStringCellValue();  // Destination
            }

            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rowData;
    }

    
}
