package baseUtils;  
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.support.PageFactory;  


public class BasePage   {  
   WebDriver driver;  
   BrowserFactory bFactory = new BrowserFactory();      
   public void init() {   
	   this.driver = bFactory.getDriver();   
	   PageFactory.initElements(driver, this);     
   } 
   
   public WebDriver getDriver(){
	   return driver;
   }
  } 
 