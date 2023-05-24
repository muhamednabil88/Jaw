package data;

import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFTable;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class ExcelReader {
    DataFormatter formatter = new DataFormatter();
    public Object[][] readSheet() throws IOException, InvalidFormatException {
        DataFormatter formatter = new DataFormatter();
        File myfile = new File("D:\\Work\\ITQAN\\Nabil\\Selenium Framework\\src\\test\\java\\data\\TestData.xlsx");
        XSSFWorkbook wb= new XSSFWorkbook(myfile);
        XSSFSheet mysheet = wb.getSheet("Sheet1");
        int number_of_rows= mysheet.getPhysicalNumberOfRows();
        System.out.println(number_of_rows);
        int number_of_columns=mysheet.getRow(0).getLastCellNum();
        //  System.out.println(number_of_columns);
        Object[][] myarray = new Object[number_of_rows-1][number_of_columns];
        for (int i = 1; i < number_of_rows ; i++){
            for(int a =0; a < number_of_columns ; a++){
                XSSFRow row = mysheet.getRow(i);
                myarray[i-1][a]= row.getCell(a).getStringCellValue();

            }



        }

        return myarray;


    }
    public Object[][] readSheet2() throws IOException, InvalidFormatException {
        DataFormatter formatter = new DataFormatter();
        File myfile = new File("D:\\Work\\ITQAN\\Nabil\\Selenium Framework\\src\\test\\java\\data\\TestData.xlsx");
        XSSFWorkbook wb= new XSSFWorkbook(myfile);
        XSSFSheet mysheet = wb.getSheet("Sheet2");
        int number_of_rows= mysheet.getPhysicalNumberOfRows();
        System.out.println(number_of_rows);
        int number_of_columns=mysheet.getRow(0).getLastCellNum();
        //  System.out.println(number_of_columns);
        Object[][] myarray = new Object[number_of_rows-1][number_of_columns];
        for (int i = 1; i < number_of_rows ; i++){
            for(int a =0; a < number_of_columns ; a++){
                XSSFRow row = mysheet.getRow(i);
                myarray[i-1][a]= row.getCell(a).getStringCellValue();

            }



        }

        return myarray;


    }

}
