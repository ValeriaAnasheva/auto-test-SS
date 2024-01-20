import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class MainTest {private WebDriver driver;

    @FindBy(id = "firstName")
    private WebElement firstNameInput;

    @FindBy(id = "lastName")
    private WebElement lastNameInput;

    @FindBy(id = "userEmail")
    private WebElement emailInput;

    @FindBy(xpath = "//*[@id='genterWrapper']/div[2]/div[2]/label")
    private WebElement genderRadio;

    @FindBy(id = "userNumber")
    private WebElement mobileInput;

    @FindBy(id = "dateOfBirthInput")
    private WebElement dobInput;

    @FindBy(className = "react-datepicker__month")
    private WebElement calendar;

    @FindBy(id = "subjectsInput")
    private WebElement subjectsInput;

    @FindBy(id = "uploadPicture")
    private WebElement uploadButton;

    @FindBy(id = "currentAddress")
    private WebElement addressInput;

    @FindBy(id = "state")
    private WebElement stateDropdown;

    @FindBy(xpath = "//div[text()='NCR']")
    private WebElement stateOption;

    @FindBy(id = "city")
    private WebElement cityDropdown;

    @FindBy(xpath = "//div[text()='Delhi']")
    private WebElement cityOption;

    @FindBy(css = "#submit.btn.btn-primary")
    private WebElement submitButton;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        PageFactory.initElements(driver, this);
    }

    @Test
    public void fillFormTest() {
        driver.get("https://demoqa.com/automation-practice-form");

        //First Name
        firstNameInput.sendKeys("Valeria");

        //Last Name
        lastNameInput.sendKeys("Lera");

        //Email
        emailInput.sendKeys("Lera.valera@xmail.com");

        //Gender
        genderRadio.click();

        //Mobile
        mobileInput.sendKeys("8800003232");

        //Date of birth
        dobInput.click();
        WebElement date = calendar.findElement(By.xpath("//div[text()='15']"));
        date.click();

        //Subjects
        subjectsInput.sendKeys("Maths");

        //Picture
        uploadButton.sendKeys("C:\\Users\\Valeriya\\IdeaProjects\\auto-test -SS\\src\\main\\resources\\imgSS.png");

        //Current Address
        addressInput.sendKeys("234 Red Square, Moscow");

        //Select State
        stateDropdown.click();
        stateOption.click();

        //Select City
        cityDropdown.click();
        cityOption.click();

        //Submit
        WebDriverWait waiit = new WebDriverWait(driver, 10L);
        waiit.until(ExpectedConditions.elementToBeClickable(submitButton));
        submitButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 15L);
        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/automation-practice-form"));

    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}