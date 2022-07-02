package org.basecls;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseCls {
	
	
	public static WebDriver driver;
	public static Select option;
	public static XSSFWorkbookType file;
	public static BufferedWriter writer;

	public static void browserOpen(String browser) {
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\mithi\\eclipse-workspace\\SeleniumSample\\exefile\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\mithi\\eclipse-workspace\\SeleniumSample\\exefile\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		}
	}

	public static void launch(String url) {
		driver.manage().window().maximize();
		driver.get(url);
	}

	public static void windowMaximize() {
		driver.manage().window().maximize();
	}

	public static String getPropertyData(String key) throws IOException {
		FileReader read = new FileReader(
				"C:\\Users\\mithi\\eclipse-workspace\\Hotelinfo\\SampleProp");
		Properties prop = new Properties();
		prop.load(read);
		System.out.println(prop.getProperty(key));
		return prop.getProperty(key);

	}

	public static WebElement findElementById(String id) {
		return driver.findElement(By.id(id));
	}

	public static void sendKeys(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void clickButton(WebElement element) {
		element.click();

	}

	public static void clear(WebElement element) {
		element.clear();
	}

	public static void city(String value) {
		WebElement dropdown = driver.findElement(By.id("location"));
		option = new Select(dropdown);
		option.selectByVisibleText(value);
	}

	public static void hotel(String value) {
		WebElement hotels = driver.findElement(By.id("hotels"));
		option = new Select(hotels);
		option.selectByValue(value);

	}

	public static void roomType(String value) {
		WebElement roomtype = driver.findElement(By.id("room_type"));
		option = new Select(roomtype);
		option.selectByValue(value);

	}

	public static void numOfRoom(String value) {
		WebElement numofroom = driver.findElement(By.id("room_nos"));
		option = new Select(numofroom);
		option.selectByValue(value);

	}

	public static void adults(String value) {
		WebElement adult = driver.findElement(By.id("adult_room"));
		option = new Select(adult);
		option.selectByValue(value);
	}

	public static void child(String value) {
		WebElement child = driver.findElement(By.id("child_room"));
		option = new Select(child);
		option.selectByValue(value);
	}

	public static void creditType(String value) {
		WebElement credittyp = driver.findElement(By.id("cc_type"));
		option = new Select(credittyp);
		option.selectByValue(value);

	}

	public static void expMonth(String value) {
		WebElement month = driver.findElement(By.id("cc_exp_month"));
		option = new Select(month);
		option.selectByValue(value);

	}

	public static void expYear(String value) {
		WebElement year = driver.findElement(By.id("cc_exp_year"));
		option = new Select(year);
		option.selectByValue(value);

	}

	public static void implicitWait(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

	public static String xcell(int row1, int cell1) throws IOException {
		String value = null;
		File f = new File("C:\\Users\\mithi\\eclipse-workspace\\SampleNew\\Samplexl\\Book1.xlsx");
		try {
			FileInputStream fis = new FileInputStream(f);

			Workbook wb = new XSSFWorkbook(fis);

			Sheet sh = wb.getSheet("Sheet2");
			Row row = sh.getRow(row1);
			Cell cell = row.getCell(cell1);

			int cellType = cell.getCellType();
			if (cellType == 1) {
				value = cell.getStringCellValue();
				System.out.println(value);
			} else if (cellType == 0) {

				if (DateUtil.isCellDateFormatted(cell)) {
					Date dateCellValue = cell.getDateCellValue();

					SimpleDateFormat sc = new SimpleDateFormat("dd-MM-yyyy");
					value = sc.format(dateCellValue);
					System.out.println(value);
				} else {
					double numericCellValue = cell.getNumericCellValue();

					long a = (long) numericCellValue;
					value = String.valueOf(a);
					System.out.println(value);

				}
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;
	}

	public static void orderid(String path) throws IOException, InterruptedException {
		WebElement orderid = driver.findElement(By.xpath("(//input[@type='text'])[16]"));
		Thread.sleep(2000);
		String s = orderid.getAttribute("value");
		System.out.println(s);

		FileInputStream fis = new FileInputStream(path);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet createSheet = wb.createSheet("sample1");
		Row createRow = createSheet.createRow(1);
		Cell createCell = createRow.createCell(0);
		createCell.setCellValue(s);
		FileOutputStream fos = new FileOutputStream(path);
		wb.write(fos);

		Thread.sleep(2000);
		wb.write(fos);
		Thread.sleep(5000);
		wb.close();
	}
	
    }


	
	
	

