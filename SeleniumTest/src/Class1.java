import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Class1 {

	public static void main(String[] args) throws InterruptedException {

		//Setup awal pada browser dan web yang digunakan
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		
		//Memasukkan username
		Thread.sleep(1000);
		WebElement username=driver.findElement(By.id("user-name"));
		username.sendKeys("problem_user");
		
		//Memasukkan password yang salah
		Thread.sleep(1000);
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("123");
		
		//Memilih password yang salah dan hapus
		Thread.sleep(3000);
		Actions actions = new Actions (driver);
		actions.click(driver.findElement(By.id("password")))
		.keyDown(Keys.CONTROL)
		.sendKeys("a")
		.keyUp(Keys.CONTROL)
		.sendKeys(Keys.BACK_SPACE)
		.build()
		.perform();
		
		//Memasukkan password yang sesuai
		Thread.sleep(1000);
		WebElement password2=driver.findElement(By.id("password"));
		password2.sendKeys("secret_sauce");
		
		//Menekan button login agar masuk dalam web
		Thread.sleep(1000);
		WebElement login=driver.findElement(By.id("login-button"));
		login.click();
		
		//Menekan side button
		Thread.sleep(1000);
		WebElement menu=driver.findElement(By.id("react-burger-menu-btn"));
		menu.click();
		
	}

}
