import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void fillFormTest() {
        driver.get("https://demoqa.com/automation-practice-form");

        // First Name
        WebElement firstNameInput = driver.findElement(By.id("firstName"));
        firstNameInput.sendKeys("Lera");

        // Last Name
        WebElement lastNameInput = driver.findElement(By.id("lastName"));
        lastNameInput.sendKeys("Urev");

        // Email
        WebElement emailInput = driver.findElement(By.id("userEmail"));
        emailInput.sendKeys("valer.aca@emailol.com");

        // Gender
        WebElement genderRadio = driver.findElement(By.xpath("//*[@id=\"genterWrapper\"]/div[2]/div[2]/label"));
        genderRadio.click();

        // Mobile
        WebElement mobileInput = driver.findElement(By.id("userNumber"));
        mobileInput.sendKeys("8800003232");

        // Date of birth
        WebElement dobInput = driver.findElement(By.id("dateOfBirthInput"));
        dobInput.click();
        WebElement calendar = driver.findElement(By.className("react-datepicker__month"));
        WebElement date = calendar.findElement(By.xpath("//div[text()='15']"));
        date.click();

        // Subjects
        WebElement subjectsInput = driver.findElement(By.id("subjectsInput"));
        subjectsInput.sendKeys("Maths");

        // Picture
        WebElement uploadButton = driver.findElement(By.id("uploadPicture"));
        uploadButton.sendKeys("C:\\Users\\Valeriya\\IdeaProjects\\auto-test -SS\\src\\main\\resources\\imgSS.png");

        //Current Address
        WebElement addressInput = driver.findElement(By.id("currentAddress"));
        addressInput.sendKeys("123 Street, City");

        //elect State
        WebElement stateDropdown = driver.findElement(By.id("state"));
        stateDropdown.click();
        WebElement stateOption = driver.findElement(By.xpath("//div[text()='NCR']"));
        stateOption.click();

        // Select City
        WebElement cityDropdown = driver.findElement(By.id("city"));
        cityDropdown.click();
        WebElement cityOption = driver.findElement(By.xpath("//div[text()='Delhi']"));
        cityOption.click();

        // Нажать Submit
        WebDriverWait wait = new WebDriverWait(driver, 5L);
        WebElement submitButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#submit.btn-primary")));
        submitButton.click();

        wait = new WebDriverWait(driver, 2L);
        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/automation-practice-form"));

    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}