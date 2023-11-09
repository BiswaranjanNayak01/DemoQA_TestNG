package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AlertFrmWindowPage {
    WebDriver driver;
    public AlertFrmWindowPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
