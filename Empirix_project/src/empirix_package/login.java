package empirix_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;	


@Test
public class login {
	
	public WebDriver driver;
	//Properties obj = new Properties();
	//FileInputStream objfile = new FileInputStream(System.getProperty("user.dir")+"\\variables.properties");
	//obj.load(objfile);
	
	@BeforeTest                            //Jumbled
    public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\gur15277\\Downloads\\chromedriver_win32_79\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	    
	public void login_to_empirix() throws InterruptedException {
	    
		driver.manage().window().maximize();

		driver.get("https://services-sso.empirix.com/openam/XUI/#login/&goto=https%3A%2F%2Fservices.empirix.com%3A443%2F");
		Thread.sleep(30000);
		driver.findElement(By.xpath("//input[@name='callback_0']")).sendKeys("QA_traininguser15");
		driver.findElement(By.xpath("//input[@name='callback_1']")).sendKeys("Empirix!");
		driver.findElement(By.xpath("//input[@name='callback_2']")).click();
		Thread.sleep(60000);
		String text = driver.findElement(By.linkText("Dashboard")).getText();	
		
		System.out.println(text);
		
		//if (text == "Dashboard") {
		
			driver.findElement(By.xpath("//a[@class='dropdown-toggle ng-binding']")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Japanese')]")).click();
			driver.switchTo().alert().accept();
			Thread.sleep(20000);		
			
			driver.findElement(By.xpath("//a[@class='dropdown-toggle ng-binding']")).click();
			driver.findElement(By.xpath("//a[contains(text(),'English')]")).click();
			driver.switchTo().alert().accept();
			Thread.sleep(15000);
			
			if(driver.findElements(By.linkText("Dashboard")).size() != 0){
				System.out.println("Dashboard is Present");
				}else{
				System.out.println("Dashboard is Absent");
				}
			if(driver.findElements(By.linkText("Alerts")).size() != 0){
				System.out.println("Alerts is Present");
				}else{
				System.out.println("Alerts is Absent");
				}
			if(driver.findElements(By.linkText("Tests")).size() != 0){
				System.out.println("Tests is Present");
				}else{
				System.out.println("Tests is Absent");
				}
			if(driver.findElements(By.linkText("Variables")).size() != 0){
				System.out.println("Variables is Present");
				}else{
				System.out.println("Variables is Absent");
				}
			if(driver.findElements(By.linkText("Notifications")).size() != 0){
				System.out.println("Notifications is Present");
				}else{
				System.out.println("Notifications is Absent");
				}
			
			driver.findElement(By.xpath("//a[@class='dropdown-toggle ng-binding']")).click();
			driver.findElement(By.xpath("//a[@href='/client']")).click();
			Thread.sleep(5000);
			if(driver.findElements(By.xpath("//h3[@class='panel-title'][text()='Client Details']")).size() != 0){
				
				if(driver.findElements(By.xpath("//label[contains(text(),'Empirix_QA_Training')]")).size() != 0) {
				System.out.println("Client Name is Present");		
				}
				else{
					System.out.println("Client Name is Absent");
					}
				
				if(driver.findElements(By.xpath("//label[contains(text(),'This client is for QA Test purposes')]")).size() != 0) {
					System.out.println("Description is Present");		
					}
					else{
						System.out.println("Description is Absent");
						}
				
				System.out.println("Client Details is Present");
				}else{
				System.out.println("Client Details is Absent");
				}

		

	}

	public void login_to_empirix_dup() throws InterruptedException {
		System.out.println("Test A");
		driver.manage().window().maximize();

		driver.get("https://services-sso.empirix.com/openam/XUI/#login/&goto=https%3A%2F%2Fservices.empirix.com%3A443%2F");
		Thread.sleep(30000);
		driver.findElement(By.xpath("//input[@name='callback_0']")).sendKeys("QA_traininguser15");
		driver.findElement(By.xpath("//input[@name='callback_1']")).sendKeys("Empirix!");
		driver.findElement(By.xpath("//input[@name='callback_2']")).click();
		Thread.sleep(60000);
		String text = driver.findElement(By.linkText("Dashboard")).getText();	
		
		System.out.println(text);
		
		//if (text == "Dashboard") {
		
			driver.findElement(By.xpath("//a[@class='dropdown-toggle ng-binding']")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Japanese')]")).click();
			driver.switchTo().alert().accept();
			Thread.sleep(20000);		
			
			driver.findElement(By.xpath("//a[@class='dropdown-toggle ng-binding']")).click();
			driver.findElement(By.xpath("//a[contains(text(),'English')]")).click();
			driver.switchTo().alert().accept();
			Thread.sleep(15000);
			
			if(driver.findElements(By.linkText("Dashboard")).size() != 0){
				System.out.println("Dashboard is Present");
				}else{
				System.out.println("Dashboard is Absent");
				}
			if(driver.findElements(By.linkText("Alerts")).size() != 0){
				System.out.println("Alerts is Present");
				}else{
				System.out.println("Alerts is Absent");
				}
			if(driver.findElements(By.linkText("Tests")).size() != 0){
				System.out.println("Tests is Present");
				}else{
				System.out.println("Tests is Absent");
				}
			if(driver.findElements(By.linkText("Variables")).size() != 0){
				System.out.println("Variables is Present");
				}else{
				System.out.println("Variables is Absent");
				}
			if(driver.findElements(By.linkText("Notifications")).size() != 0){
				System.out.println("Notifications is Present");
				}else{
				System.out.println("Notifications is Absent");
				}
			
			driver.findElement(By.xpath("//a[@class='dropdown-toggle ng-binding']")).click();
			driver.findElement(By.xpath("//a[@href='/client']")).click();
			Thread.sleep(5000);
			if(driver.findElements(By.xpath("//h3[@class='panel-title'][text()='Client Details']")).size() != 0){
				
				if(driver.findElements(By.xpath("//label[contains(text(),'Empirix_QA_Training')]")).size() != 0) {
				System.out.println("Client Name is Present");		
				}
				else{
					System.out.println("Client Name is Absent");
					}
				
				if(driver.findElements(By.xpath("//label[contains(text(),'This client is for QA Test purposes')]")).size() != 0) {
					System.out.println("Description is Present");		
					}
					else{
						System.out.println("Description is Absent");
						}
				
				System.out.println("Client Details is Present");
				}else{
				System.out.println("Client Details is Absent");
				}

		

	}

	
	@AfterTest
	public void close_browser_empirix() {
		System.out.println("Test B");
		driver.close();
	}

}

