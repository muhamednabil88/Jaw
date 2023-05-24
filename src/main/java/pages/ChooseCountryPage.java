package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChooseCountryPage extends PageBase {
    public ChooseCountryPage(WebDriver driver) {
        super(driver);
    }
    PackagesPage packagesObject;
    @FindBy(id = "country-title")
    WebElement chooseCountryWizardTitle;

    @FindBy(id="om-contry-flag")
    WebElement omanCountryButtonInChooseCountryWizard;

    @FindBy(id = "jo")
    WebElement jordonCountryButtonInChooseCountryWizard;

    @FindBy(id="iq")
    WebElement iraqCountryButtonInChooseCountryWizard;

    public void chooseOmanCountry(){
        packagesObject = new PackagesPage(driver);
        clickButton(packagesObject.chosenCountryFieldInPackagesPage);
        waitElementToBeVisible(chooseCountryWizardTitle);
        clickButton(omanCountryButtonInChooseCountryWizard);
        waitElementToBeVisible(packagesObject.chosenCountryFieldInPackagesPage);
        soft.assertTrue(packagesObject.chosenCountryFieldInPackagesPage.getText().contains("عمان"));
        soft.assertAll();
    }

    public void chooseJordonCountry(){
        packagesObject = new PackagesPage(driver);
        clickButton(packagesObject.chosenCountryFieldInPackagesPage);
        waitElementToBeVisible(chooseCountryWizardTitle);
        clickButton(jordonCountryButtonInChooseCountryWizard);
        waitElementToBeVisible(packagesObject.chosenCountryFieldInPackagesPage);
        soft.assertTrue(packagesObject.chosenCountryFieldInPackagesPage.getText().contains("الأردن"));
        soft.assertAll();
    }
    public void chooseIraqCountry(){
        packagesObject = new PackagesPage(driver);
        clickButton(packagesObject.chosenCountryFieldInPackagesPage);
        waitElementToBeVisible(chooseCountryWizardTitle);
        clickButton(iraqCountryButtonInChooseCountryWizard);
        waitElementToBeVisible(packagesObject.chosenCountryFieldInPackagesPage);
        soft.assertTrue(packagesObject.chosenCountryFieldInPackagesPage.getText().contains("العراق"));
        soft.assertAll();
    }
}
