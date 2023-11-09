package Test;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.InteractionsPage;


public class HomePageTest extends BaseTest {
    WebDriver driver;
    HomePage homePage;
    InteractionsPage interactionsPage;

    @BeforeMethod
    public void beforeMethod() {
        driver = initialiseBrowserAndOpenWebsite("chrome");
        driver.navigate().to("https://demoqa.com/");
    }

    @Test
    public void tet() {
        homePage = new HomePage(driver);
        interactionsPage = homePage.homePageWindow().interactionCard();
        interactionsPage
                .gotoDroppable()
                .gotoSortable()
                .gotoSelectable()
                .gotoSortable()
                .sortable_list("One","Four");
        Assert.assertEquals(interactionsPage.sortable_List_Elements.get(3).getText(), "One");
        interactionsPage.sortable_grid();
        Assert.assertEquals(interactionsPage.sortable_Grid_Elements.get(3).getText(), "One");



    }
}
