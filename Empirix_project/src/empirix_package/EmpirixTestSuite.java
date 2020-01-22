package empirix_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class EmpirixTestSuite {
	
	public WebDriver driver;
	public String baseURL = "https://services-sso.empirix.com/";
	public String ChromeDriverPath = "C:\\Users\\gur15277\\Downloads\\chromedriver_win32_79\\chromedriver.exe";

	
	// Before annotation used to launch browser before executing any test case
	@BeforeTest                  
	@Parameters("browser")
    public void launchBrowser(String browser) throws Exception {
		//Launching browser 

		if(browser.equalsIgnoreCase("firefox")){
		
		System.setProperty("webdriver.chrome.driver",ChromeDriverPath);
		driver = new ChromeDriver();
		
		} else if(browser.equalsIgnoreCase("chrome")){
		
			System.setProperty("webdriver.chrome.driver",ChromeDriverPath);
			driver = new ChromeDriver();		
			
		}  else {
			//Handling of wrong input
			throw new Exception("Browser is not correct");
		}
		}

	//Login to empirix training site
	@Test (priority=1)
	public void login_to_empirix() throws InterruptedException {
	    
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 600);
		
		driver.get(baseURL);
		//Thread.sleep(30000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='callback_0']")));
		driver.findElement(By.xpath("//input[@name='callback_0']")).sendKeys("QA_traininguser15");
		driver.findElement(By.xpath("//input[@name='callback_1']")).sendKeys("Empirix!");
		driver.findElement(By.xpath("//input[@name='callback_2']")).click();
		//Thread.sleep(60000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Dashboard")));
	}
	
	//To test that empirix training site page opened in both English and Japanese language
	@Test   (priority=4)
	public void Switch_Language() throws InterruptedException {
	        //English to Japanese page verification done	
		    WebDriverWait wait = new WebDriverWait(driver, 600);
			driver.findElement(By.xpath("//a[@class='dropdown-toggle ng-binding']")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Japanese')]")).click();
			driver.switchTo().alert().accept();
			Thread.sleep(15000);
			
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'テスト')]")));
			
			if(driver.findElements(By.linkText("ダッシュボード")).size() != 0) {
				
				System.out.println("SUCCESS :: Japanese language selected");
				
			} else {
				 
				System.out.println("FAILED :: Japanese language not selected");
			
			}
		
			//Japanese to English conversion verification done
			
			driver.findElement(By.xpath("//a[@class='dropdown-toggle ng-binding']")).click();
			driver.findElement(By.xpath("//a[contains(text(),'English')]")).click();
			driver.switchTo().alert().accept();
			//Thread.sleep(15000);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Dashboard")));
			
			if(driver.findElements(By.linkText("Dashboard")).size() != 0){
				
				System.out.println("SUCCESS :: English language selected");
				
			} else {
				
				System.out.println("FAILED :: English language selected");
			}

	}

	//Test to verify all tabs working and opened correctly
	@Test   (priority=3)
	public void Verify_Tabs() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 600);
	
			if(driver.findElements(By.linkText("Dashboard")).size() != 0){
				System.out.println("Dashboard is Present");
				
				}else{
				System.out.println("Dashboard is Absent");
				}
			
			
			if(driver.findElements(By.linkText("Alerts")).size() != 0){
				System.out.println("Alerts is Present");
				driver.findElement(By.linkText("Alerts")).click();
				//Thread.sleep(5000);
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[contains(text(),'Alert Status')]")));
				
				if(driver.findElements(By.xpath("//th[contains(text(),'Alert Status')]")).size() != 0) {
					System.out.println("Alerts tab was opened successfully");
					
				} else {
					System.out.println("Alerts tab was not opened correctly");
					
				}
				
			}else{
				System.out.println("Alerts is Absent");
				}
			
			
			
			if(driver.findElements(By.linkText("Tests")).size() != 0){
				System.out.println("Tests is Present");
				driver.findElement(By.linkText("Tests")).click();
				//Thread.sleep(5000);
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Test')]")));
				
				if(driver.findElements(By.xpath("//h4[contains(text(),'Test')]")).size() != 0) {
					System.out.println("Tests tab was opened successfully");
					
				} else {
					System.out.println("Tests tab was not opened correctly");
					
				}
				
			}else{
				System.out.println("Tests is Absent");
				}
			if(driver.findElements(By.linkText("Variables")).size() != 0){
				System.out.println("Variables is Present");
				driver.findElement(By.linkText("Variables")).click();
				//Thread.sleep(5000);
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ng-scope']//h4[contains(text(),'Variable')]")));
				
				if(driver.findElements(By.xpath("//div[@class='ng-scope']//h4[contains(text(),'Variable')]")).size() != 0) {
					System.out.println("Variables tab was opened successfully");
					
				} else {
					System.out.println("Variables tab was not opened correctly");
				}
			}else{
				System.out.println("Variables is Absent");
				}
			
			if(driver.findElements(By.linkText("Notifications")).size() != 0){
				System.out.println("Notifications is Present");
				driver.findElement(By.linkText("Notifications")).click();
				//Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Notification')]")));
				
				if(driver.findElements(By.xpath("//h4[contains(text(),'Notification')]")).size() != 0) {
					System.out.println("Notification tab was opened successfully");
					
				} else {
					System.out.println("Notification tab was not opened correctly");
				}
				}else{
				System.out.println("Notifications is Absent");
				}
			


			//Tabs verification for Japanese language started
			driver.findElement(By.xpath("//a[@class='dropdown-toggle ng-binding']")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Japanese')]")).click();
			driver.switchTo().alert().accept();
			//Thread.sleep(10000);
						
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("ダッシュボード")));
			
			if(driver.findElements(By.linkText("ダッシュボード")).size() != 0){
				System.out.println("Dashboard is Present on Japanese language page");
				
				}else{
				System.out.println("Dashboard is Absent on Japanese language page");
				}
			
			
			if(driver.findElements(By.linkText("アラート")).size() != 0){
				System.out.println("Alerts is Present on Japanese language page");
				driver.findElement(By.linkText("アラート")).click();
				//Thread.sleep(5000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//th[contains(text(),'アラートステータス')]")));
				
				if(driver.findElements(By.xpath("//th[contains(text(),'アラートステータス')]")).size() != 0) {
					System.out.println("Alerts tab was opened successfully on Japanese language page");
					
				} else {
					System.out.println("Alerts tab was not opened correctly on Japanese language page");
					
				}
				
			}else{
				System.out.println("Alerts is Absent on Japanese language page");
				}
			
			
			
			if(driver.findElements(By.linkText("テスト")).size() != 0){
				System.out.println("Tests is Present on Japanese language page");
				driver.findElement(By.linkText("テスト")).click();
				//Thread.sleep(5000);
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'テスト')]")));
				
				if(driver.findElements(By.xpath("//h4[contains(text(),'テスト')]")).size() != 0) {
					System.out.println("Tests tab was opened successfully on Japanese language page");
					
				} else {
					System.out.println("Tests tab was not opened correctly on Japanese language page");
					
				}
				
			}else{
				System.out.println("Tests is Absent on Japanese language page");
				}
			if(driver.findElements(By.linkText("変数")).size() != 0){
				System.out.println("Variables is Present on Japanese language page");
				driver.findElement(By.linkText("変数")).click();
				Thread.sleep(5000);
				
				//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("h4[contains(text(),'変数')]")));
				
				if(driver.findElements(By.xpath("//h4[contains(text(),'変数')]")).size() != 0) {
					System.out.println("Variables tab was opened successfully on Japanese language page");
					
				} else {
					System.out.println("Variables tab was not opened correctly on Japanese language page");
				}
			}else{
				System.out.println("Variables is Absent on Japanese language page");
				}
			
			if(driver.findElements(By.linkText("通知")).size() != 0){
				System.out.println("Notifications is Present on Japanese language page");
				driver.findElement(By.linkText("通知")).click();
				//Thread.sleep(5000);
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'通知')]")));
				
				if(driver.findElements(By.xpath("//h4[contains(text(),'通知')]")).size() != 0) {
					System.out.println("Notification tab was opened successfully on Japanese language page");
					
				} else {
					System.out.println("Notification tab was not opened correctly on Japanese language page");
				}
				}else{
				System.out.println("Notifications is Absent on Japanese language page");
				}
			
			//Back to English language
			driver.findElement(By.xpath("//a[@class='dropdown-toggle ng-binding']")).click();
			driver.findElement(By.xpath("//a[contains(text(),'English')]")).click();
			driver.switchTo().alert().accept();
			Thread.sleep(15000);
			
	}

	//Test to verify that client link is working fine or not
	@Test (priority=2)  
	public void Verify_Client_details() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 600);
		driver.findElement(By.xpath("//a[@class='dropdown-toggle ng-binding']")).click();
		driver.findElement(By.xpath("//a[@href='/client']")).click();
		//Thread.sleep(5000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='panel-title'][text()='Client Details']")));
		
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

	//Close the browser after test completion
	@AfterTest
	public void close_browser_empirix() {
		System.out.println("Closing the opened browsers");
		driver.close();
	}

}


