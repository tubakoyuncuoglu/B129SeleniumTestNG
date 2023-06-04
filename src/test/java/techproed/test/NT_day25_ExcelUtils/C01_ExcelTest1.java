package techproed.test.NT_day25_ExcelUtils;

import org.testng.annotations.Test;
import techproed.utilities.ExcelUtils;

public class C01_ExcelTest1 {
    @Test
    public void excelTest1() {

        String path ="src/test/java/resources/mysmoketestdata.xlsx";
        String sayfa ="customer_info";
        ExcelUtils excelUtils = new ExcelUtils(path,sayfa);
        excelUtils.getCellData(1,0);
        //2.yol
        ExcelUtils excelUtils1 = new ExcelUtils("src/test/java/resources/mysmoketestdata.xlsx","customer_info");
        String email = excelUtils.getCellData(1,0);
        String password =excelUtils.getCellData(1,1);
        System.out.println(email+ "||" +password);





    }
}
