package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.*;
import java.util.List;
import java.util.Properties;

public class UtilityClass {
    public static String getValue(String key){
        String value = null;
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("src/main/resources/dataconfig.properties"));
            value = prop.getProperty(key);
        }catch (Exception e){}
        System.out.println(value);
        return value;
    }
    public static String getConfig(String key) {
        String value = null;
        try {
            Properties prop = new Properties();
            prop.load(new FileInputStream("src/main/resources/Config.properties"));
            value = prop.getProperty(key);
        }catch (Exception e){}
        System.out.println(value);
        return value;
    }

    public static void clickOnMatch(List<WebElement> elements,String name){
        for (WebElement element:elements){
            if (element.getText().contains(name)){
                element.click();
                break;
            }
        }
    }
    public static WebElement returnWebElementOnMatch(List<WebElement> elements, String name){
        WebElement webElement = null;
        for (WebElement element:elements){
            if (element.getText().contains(name)){
                webElement=element;
                break;
            }
        }
        return webElement;
    }
    public static void clickOnMatchUsingJSExecutor(WebDriver driver,List<WebElement> elements,String name){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        for (WebElement element:elements){
            if (element.getText().contains(name)){
                js.executeScript("arguments[0].click()",element);
                break;
            }
        }
    }
    public static void scrollIntoView(WebDriver driver,WebElement element){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()",element);
    }
    public void moveToElement(WebDriver driver,WebElement element){
        Actions actions=new Actions(driver);
        actions.moveToElement(element);
    }

    public static void main(String[] args) throws IOException {
        getValue("name");
        getConfig("url");
    }
}
