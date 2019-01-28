import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_object.LeadsAdmin;
import page_object.ModelPage;
import utils.Utils;

public class ModelPageTest extends BaseTest {
    private ModelPage modelPage;

    @Override
    @BeforeMethod
    public void beforeMethodInit() {
        super.beforeMethodInit();
        modelPage = new ModelPage();
        modelPage.navigateToModelPage();
    }

    @Test (description = "Click on the Top Gop btn on the Model page, fill in GOP pup-up, verify if lead is created ")
    public void createLeadTopGopPopup() {
        String userName = Utils.getRandomStringWithoutNumbers(7);
        String userLocation = Utils.getRandomLocation();

        modelPage
                .clickTopGopBtn()
                .fillInAndSubmit(userName, "9999999999", userLocation,"Just researching")
                .verifyChosenModelTab("Tata Tiago");
        new LeadsAdmin()
                .navigateToAdmin()
                .loginAdmin()
                .navigateToGopRequestTab()
                .checkSavedLead(userName);
    }

    @Test (description = "Click on the Gop btn from the Price List, fill in GOP pup-up, verify if lead is created")
    public void createLeadPriceListGopPopup() {
        String userName = Utils.getRandomStringWithoutNumbers(7);
        String userLocation = Utils.getRandomLocation();

        modelPage
                .clickPriceListGopBtn()
                .fillInAndSubmit(userName, "9999999999", userLocation, "Just researching")
                .verifyChosenModelTab("Tata Tiago");
        new LeadsAdmin()
                .navigateToAdmin()
                .loginAdmin()
                .navigateToGopRequestTab()
                .checkSavedLead(userName);
    }

    @Test (description = "Click on the Top Booking btn, create booking lead")
    public void createLeadTopBookingPopup() {
        String userName = Utils.getRandomStringWithoutNumbers(7);
        String userLocation = Utils.getRandomLocation();

        modelPage
                .clickTopBookingBtn()
                .fillInAndSubmitBookingPopup(userLocation, userName, "test@test.com", "9999999999");
        new LeadsAdmin()
                .navigateToAdmin()
                .loginAdmin()
                .navigateToBookingRequestTab()
                .checkSavedLead(userName);
    }

    @Override
    @AfterMethod
    public void afterMethodStop() {
        super.afterMethodStop();
    }
}
