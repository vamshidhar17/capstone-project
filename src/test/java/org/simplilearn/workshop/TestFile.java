package org.simplilearn.workshop;




import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
public class TestFile {
@Test
public void LoginTest() throws InterruptedException
{
System.getProperty("webdriver.chrome.driver","c:\\testtools\\chromedriver.exe");
WebDriver driver=new ChromeDriver();
driver.get("http://localhost:8082/login.jsp");
Thread.sleep(5000);
driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/div[1]/input")).sendKeys("vamshi");
driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/div[2]/input")).sendKeys("vamshi123");
driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/div[3]/button")).click();

try
{
WebDriverWait wait=new WebDriverWait(driver,60);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("https://localhost:8082/logging")));
System.out.println("Login Successfull");
}
catch(Exception e)
{
System.out.println("Error in browser ||\n Please have a look");
}
Thread.sleep(5000);
driver.quit();

}
}