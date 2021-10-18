import org.openqa.selenium.WebDriver;
public class UITest
{
    @Test
    public void startB()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver d = new Chromedriver();
        d.manage().window().maximize();
        d.get("https://opensource-demo.orangehrmlive.com/");
        Assert.assertTrue(d.getTitle().contains("Orange"),"Not Found");
        d.quit();
    }
}