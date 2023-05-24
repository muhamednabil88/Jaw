package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.ChooseCountryPage;
import pages.PackagesPage;

public class PackagesTests extends TestBase {

    PackagesPage packgesObject;
    ChooseCountryPage chooseCountryObject;

    @Test(priority = 1)
    public void subscribeInDefaultPackage() throws InterruptedException {
        packgesObject = new PackagesPage(driver);
        packgesObject.checkThatDefaultCountryIsEgypt();
        packgesObject.chooseDefaultPackage();
        packgesObject.subscribeInDefaultPackage();
        driver.get("https://subscribe.stctv.com");
    }

    @Test(priority = 2)
    public void checkPackagesDetailsInJordon(){
        packgesObject = new PackagesPage(driver);
        chooseCountryObject = new ChooseCountryPage(driver);
        chooseCountryObject.chooseJordonCountry();
        packgesObject.validateLightPackageDetails("لايت","2.7 دولار أمريكي/شهر","ليوم");
        packgesObject.validateBasicPackageDetails("الأساسية","5.2 دولار أمريكي/شهر","لـ 7 أيام");
        packgesObject.validatePremiumPackageDetails("بريميوم","8 دولار أمريكي/شهر","لـ 14 يوما");
    }

    @Test(priority = 3)
    public void checkPackagesDetailsInOman(){
        packgesObject = new PackagesPage(driver);
        chooseCountryObject = new ChooseCountryPage(driver);
        chooseCountryObject.chooseOmanCountry();
        packgesObject.validateLightPackageDetails("لايت","5 دولار أمريكي/شهر","ليوم");
        packgesObject.validateBasicPackageDetails("الأساسية","10 دولار أمريكي/شهر","لـ 7 أيام");
        packgesObject.validatePremiumPackageDetails("بريميوم","15 دولار أمريكي/شهر","لـ 14 يوما");
    }

    @Test(priority = 4)
    public void checkPackagesDetailsInIraq(){
        packgesObject = new PackagesPage(driver);
        chooseCountryObject = new ChooseCountryPage(driver);
        chooseCountryObject.chooseIraqCountry();
        packgesObject.validateLightPackageDetails("لايت","2.4 دولار أمريكي/شهر","ليوم");
        packgesObject.validateBasicPackageDetails("الأساسية","4.1 دولار أمريكي/شهر","لـ 7 أيام");
        packgesObject.validatePremiumPackageDetails("بريميوم","6.2 دولار أمريكي/شهر","لـ 14 يوما");
    }

}
