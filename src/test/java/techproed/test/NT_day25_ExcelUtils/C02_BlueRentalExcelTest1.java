package techproed.test.NT_day25_ExcelUtils;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;

public class C02_BlueRentalExcelTest1 {
    @Test
    public void excelTest() {
        /*
        Eger bir veriyi(datayi) .properties dosyasindan almak istiyorsak, ConfigReader classindan getProperty()
        methodunu kullanarak .properties dosyamiza koydugumuz key degerini belirtiriz ve bize bu key degerinin value sini dondurur
          Eger bir veriyi(datayi) excel dosyasindan almak istiyorsak , olusturmus oldugumuz ExcelUtils class'indaki
          method'lari kullanarak istedigimiz veriyi alabiliriz
         */
        ExcelUtils excelUtils = new ExcelUtils("src/test/java/resources/mysmoketestdata.xlsx","customer_info");
        String email = excelUtils.getCellData(1,0);
        String password = excelUtils.getCellData(1,1);
        System.out.println(email+ "||" +password);


        //BlueRentalCar adresine gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));


        //Excel dosyamizdan aldigimiz ilk email ve password ile sayfaya login olalim
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login.click();// login buttonuna tiklar
        blueRentalPage.email.sendKeys(email, Keys.TAB,password,Keys.ENTER);
        //Excel'den alacagimiz verileri sendKeys() methodu ile gondeririz



        //Login oldugumuzu dogrulayalim
        Assert.assertTrue(blueRentalPage.verify.isDisplayed());


    }
}
