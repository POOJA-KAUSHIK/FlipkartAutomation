package pooja_flipkart;

import java.util.List;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class flipkart {
    
    ChromeDriver driver;

    @BeforeTest
    public void init(){     
        System.out.println("Constructor: TestCases");
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();  
    }

    @AfterTest
    public void closeBrowser(){
        driver.close(); 
    }    

    @Test
    public void testCase01() throws InterruptedException{
        int count =0;
        driver.get("https://www.flipkart.com/");
        WebElement searchField = driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']"));
        searchField.sendKeys("washing machine" +Keys.ENTER);
        WebElement sort_Popularity = driver.findElement(By.xpath("//div[text()='Popularity']"));
        sort_Popularity.click();      
    
        Thread.sleep(3000);
        List<WebElement> ratings =  driver.findElements(By.xpath("//div[@class='_3LWZlK']"));
        
        for(int i=0;i<ratings.size();i++){
            Thread.sleep(2000);
            
            float ratingVal = Float.valueOf(ratings.get(i).getText());
            //System.out.println("ratingString = "+ratings.get(i).getText()); 
            //System.out.println("ratingVal = "+ratingVal);
            if (ratingVal <= 4.0) {
                count++;
            }
            
        }    
        System.out.println(count);          
    }
    @Test
    public void testCase02() throws InterruptedException{
    
        driver.get("https://www.flipkart.com/");
        WebElement searchField = driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']"));
        searchField.sendKeys("iphone" +Keys.ENTER);
        List<WebElement> title = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
        List<WebElement> discount = driver.findElements(By.xpath("//div[@class='_3Ay6Sb']"));
            
        for(int i=0;i<discount.size();i++){
            Thread.sleep(2000);
            String disVal = discount.get(i).getText();
            String d[] = disVal.split(" ");
            String dval[] = d[0].split("\\%");
            //System.out.println(title.get(i).getText()+"    "+discount.get(i).getText());
            int val = Integer.valueOf(dval[0]);
           // System.out.println(val); 
            if (val >= 17) {
                System.out.println(title.get(i).getText()+"    "+val);
            }
        } 
                         
    }
    @Test
    public void testCase03() throws InterruptedException{
    
        driver.get("https://www.flipkart.com/");
        WebElement searchField = driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']"));
        searchField.sendKeys("Coffee Mug" +Keys.ENTER);
        WebElement rating = driver.findElement(By.xpath("//label[@class='_2iDkf8 t0pPfW']/div[text()='4★ & above']"));
        rating.click();
        List<WebElement> title = driver.findElements(By.xpath("//a[@class='s1Q9rs']"));
        List<WebElement> imageUrl = driver.findElements(By.xpath("//img[@class='_396cs4']"));

        //List<WebElement> reviews = driver.findElements(By.className("_2_R_DZ"));
        
        for(int i=0;i<title.size();i++){
            System.out.println(title.get(i).getText());
            
        }

    }
}
