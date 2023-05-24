package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PackagesPage extends PageBase{

    public PackagesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "country-name")
    public WebElement   chosenCountryFieldInPackagesPage;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[1]/div[3]/div[1]")
    public WebElement   defaultPackagePriceInPackagesPage;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[1]/div[3]/a")
    WebElement chooseButtonOfDefaultPackageInPackagesPage;

    @FindBy(id = "لايت-selection")
    WebElement  lightPackageSubscribeButtonInPackagesPage;

    @FindBy(id = "name-لايت")
    WebElement  lightPackageNameTextInPackagesPage;

    @FindBy(id = "name-الأساسية")
    WebElement  basicPackageNameTextInPackagesPage;

    @FindBy(id = "name-بريميوم")
    WebElement  premiumPackageNameTextInPackagesPage;

    @FindBy(id = "currency-لايت")
    WebElement lightPackagePricePerMonthTextInPackagesPage;

    @FindBy(id = "currency-الأساسية")
    WebElement basicPackagePricePerMonthTextInPackagesPage;

    @FindBy(id = "currency-بريميوم")
    WebElement premiumPackagePricePerMonthTextInPackagesPage;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[8]/div[2]/div[1]")
    WebElement  lightPackagePeriodPerDayTextInPackagesPage;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[8]/div[2]/div[2]")
    WebElement basicPackagePeriodPerDayTextInPackagesPage;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[8]/div[2]/div[3]")
    WebElement  premiumPackagePeriodPerDayTextInPackagesPage;

    @FindBy(id = "order-tier-name")
    WebElement packageNameInLightSubscribePage;

    @FindBy(id = "order-tier-price")
    WebElement  packagePricePerMonthInLightSubscribePage;

    @FindBy(id = "vodafone_egy-checkbox")
    WebElement  vodafonePaymentCheckboxInEgyptianDefaultPackagePage;

    @FindBy(id = "btnChoosePaymentMethod")
    WebElement  nextButtonInDefaultPackagePage;

    @FindBy(id = "btnFinalStepSubscribe")
    WebElement  finishButtonInDefaultPackagePage;

    @FindBy(xpath = "//input[@placeholder='رقم الموبيل']")
    WebElement  mobileFieldInDefaultPackagePage;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div/h2")
    WebElement  confirmPinFormInDefaultPackagePage;


    public void checkThatDefaultCountryIsEgypt() throws InterruptedException {
        //Check default package info
        waitElementToBeVisible(chosenCountryFieldInPackagesPage);
        soft.assertTrue(chosenCountryFieldInPackagesPage.getText().contains("مصر"));
        Thread.sleep(1000);
        soft.assertTrue(defaultPackagePriceInPackagesPage.getText().contains("ابتداءا من 7.00 جنيه مصري/بالشهر"));
        soft.assertAll();
    }

    public void chooseDefaultPackage(){
        //Choose default package
        clickButton(chooseButtonOfDefaultPackageInPackagesPage);
        waitElementToBeVisible(packagePricePerMonthInLightSubscribePage);
        soft.assertTrue(packagePricePerMonthInLightSubscribePage.getText().contains("10 جنية مصري/الشهر"));
        soft.assertAll();

    }

    public void     subscribeInDefaultPackage(){
        clickButton(nextButtonInDefaultPackagePage);
        //Check button is disabled until enter phone number
        waitElementToBeVisible(finishButtonInDefaultPackagePage);
        soft.assertTrue(!finishButtonInDefaultPackagePage.isEnabled());
        setTextElementText(mobileFieldInDefaultPackagePage,"1115840119");
        //Check button is enabled after enter phone number
        soft.assertTrue(finishButtonInDefaultPackagePage.isEnabled());
        clickButton(finishButtonInDefaultPackagePage);
        //Check that after finish redirect to pin page
        waitElementToBeVisible(confirmPinFormInDefaultPackagePage);
        soft.assertTrue(confirmPinFormInDefaultPackagePage.getText().contains("تأكيد PIN"));
        soft.assertAll();
    }
    public void validateLightPackageDetails(String packageName, String packagePrice, String advancedPackagePrice){
        //Check light package details
        soft.assertTrue(lightPackageNameTextInPackagesPage.getText().contains(packageName));
        soft.assertTrue(lightPackagePricePerMonthTextInPackagesPage.getText().contains(packagePrice));
        soft.assertTrue(lightPackagePeriodPerDayTextInPackagesPage.getText().contains(advancedPackagePrice));
        soft.assertAll();
    }

    public void validateBasicPackageDetails(String packageName, String packagePrice, String advancedPackagePrice){
        //Check basic package details
        soft.assertTrue(basicPackageNameTextInPackagesPage.getText().contains(packageName));
        soft.assertTrue(basicPackagePricePerMonthTextInPackagesPage.getText().contains(packagePrice));
        soft.assertTrue(basicPackagePeriodPerDayTextInPackagesPage.getText().contains(advancedPackagePrice));
        soft.assertAll();
    }

    public void validatePremiumPackageDetails(String packageName, String packagePrice, String advancedPackagePrice){
        //Check premium package details
        soft.assertTrue(premiumPackageNameTextInPackagesPage.getText().contains(packageName));
        soft.assertTrue(premiumPackagePricePerMonthTextInPackagesPage.getText().contains(packagePrice));
        soft.assertTrue(premiumPackagePeriodPerDayTextInPackagesPage.getText().contains(advancedPackagePrice));
        soft.assertAll();
    }
}
