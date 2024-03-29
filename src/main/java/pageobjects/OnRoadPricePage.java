package pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static testdata.Urls.ON_ROAD_PRICE_PAGE;

public class OnRoadPricePage extends BaseElement {

    private static final By locationBox = By.cssSelector(".ui-state-highlight");

    @FindBy(css = ".form-lead [name='brand']")
    private WebElement selectBrandDropDown;

    @FindBy(css = ".form-lead [name='brand'] option")
    private List<WebElement> brands;

    @FindBy(css = ".form-lead [name='model']")
    private WebElement selectModelDropDown;

    @FindBy(css = ".form-lead [name='model'] option")
    private List<WebElement> models;

    @FindBy(css = ".form-lead [name='name']")
    private WebElement inputName;

    @FindBy(css = ".form-lead [name='phone']")
    private WebElement inputPhone;

    @FindBy(css = ".form-lead [name='gop_type_address']")
    private WebElement inputLocation;

    @FindBy(css = ".ui-state-highlight")
    private List<WebElement> autocompleteOptions;

    @FindBy(css = ".form-lead [name='purchaseDate']")
    private WebElement purchasePeriodDropDown;

    @FindBy(css = ".form-lead [name='purchaseDate'] option")
    private List<WebElement> purchaseDates;

    @FindBy(css = ".form-lead .red_but.cell-sm")
    private WebElement btnProceed;

    @Step("Navigate to the On Road Price page")
    public void navigate() {
        LOGGER.info("Navigate to the On Road Price page");
        webDriver.navigate().to(ON_ROAD_PRICE_PAGE);
    }

    @Step("Select Brand on the OnRoadPrice page")
    public OnRoadPricePage selectBrand(String brandName) {
        LOGGER.info("Select Brand on the OnRoadPrice page");
        click(selectBrandDropDown);
        for (WebElement brand : brands) {
            if (brand.getText().equals(brandName)) {
                click(brand);
                break;
            }
        }
        return this;
    }

    @Step("Select Model on the OnRoadPrice page")
    public OnRoadPricePage selectModel(String modelName) {
        LOGGER.info("Select Model on the OnRoadPrice page");
        click(selectModelDropDown);
        for (WebElement model : models) {
            if (model.getText().equals(modelName)) {
                click(model);
                break;
            }
        }
        return this;
    }

    @Step("Fill the User name in the GOP form")
    public OnRoadPricePage fillInInputName(String userName) {
        LOGGER.info("Fill the User name in the GOP form");
        sendKeys(inputName, userName);
        return this;
    }

    @Step("Fill the User phone in the GOP form")
    public OnRoadPricePage fillInInputPhone(String userPhone) {
        LOGGER.info("Fill the User phone in the GOP form");
        sendKeys(inputPhone, userPhone);
        return this;
    }

    @Step("Select the User Location from autosuggest")
    public OnRoadPricePage fillInInputLocation(String userLocation) {
        LOGGER.info("Select the User Location from autosuggest");
        sendKeys(inputLocation, userLocation);
        waitForVisibilityBy(locationBox);
        for (WebElement location : autocompleteOptions) {
            if (location.getText().contains(userLocation)) {
                click(location);
                break;
            }
        }
        return this;
    }

    @Step("Select Purchase period from the drop-down")
    public OnRoadPricePage selectPurchasePeriod(String purchaseDate) {
        LOGGER.info("Select Purchase period from the drop-down");
        click(purchasePeriodDropDown);
        for (WebElement date : purchaseDates) {
            if (date.getText().equals(purchaseDate)) {
                click(date);
                break;
            }
        }
        return this;
    }

    @Step("Click the Proceed btn")
    public GetOnRoadPriceResultPage clickBtnProceed() {
        LOGGER.info("Click the Proceed btn");
        click(btnProceed);
        return new GetOnRoadPriceResultPage();
    }
}
