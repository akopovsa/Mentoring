import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HomeWorkEdgeTest {
    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.edgedriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new EdgeDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testTask2_1() {
        List<String> href = new ArrayList();
        String url = "https://www.google.com/";
        driver.get(url);
        WebElement search = driver.findElement(By.name("q"));

        search.sendKeys("selenium automation testing");
        search.submit();
        for (int i = 0; i < 10; i++) {
            if (href.isEmpty()) {
                List<WebElement> links = driver.findElements(By.tagName("a"));
                System.out.println(links.size());
                href = links.stream().map(e -> e.getAttribute("href")).filter(e -> e != null).filter(e -> e.contains("seleniumhq.org")).collect(Collectors.toList());
                System.out.println(href);
                WebElement nextPage = driver.findElement(By.xpath("//*[@id='pnnext']/span[2]"));
                nextPage.click();
            } else {
                System.out.printf("Find that `seleniumhq.org` is on the %s page", i);
                break;
            }
        }
        if (href.isEmpty()) {
            System.out.println("`seleniumhq.org` was not found");
        }
    }

    @Test
    public void testTask2_2() {
        List<String> href = new ArrayList();
        String url = "https://www.google.com/";
        driver.get(url);
        WebElement search = driver.findElement(By.name("q"));

        search.sendKeys("осциллограф");
        search.submit();
        for (int i = 0; i < 10; i++) {
            if (href.isEmpty()) {
                List<WebElement> links = driver.findElements(By.tagName("a"));
                href = links.stream().map(e -> e.getAttribute("href")).filter(e -> e != null).filter(e -> e.contains("vit.ua")).collect(Collectors.toList());
                WebElement nextPage = driver.findElement(By.xpath("//*[@id='pnnext']/span[2]"));
                nextPage.click();
            } else {
                System.out.printf("Find that `vit.ua` is on the %s page", i);
                break;
            }
        }
        if (href.isEmpty()) {
            System.out.println("`vit.ua` was not found");
        }
    }

    @Test
    public void testTask2_3() {
        List<String> href = new ArrayList();
        String url = "https://www.google.com/";
        driver.get(url);
        WebElement search = driver.findElement(By.name("q"));

        search.sendKeys("абракадабра");
        search.submit();
        for (int i = 0; i < 10; i++) {
            if (href.isEmpty()) {
                List<WebElement> links = driver.findElements(By.tagName("a"));
                href = links.stream().map(e -> e.getAttribute("href")).filter(e -> e != null).filter(e -> e.contains("kpi.ua")).collect(Collectors.toList());
                WebElement nextPage = driver.findElement(By.xpath("//*[@id='pnnext']/span[2]"));
                nextPage.click();
            } else {
                System.out.printf("Find that `kpi.ua` is on the %s page", i);
                break;
            }
        }
        if (href.isEmpty()) {
            System.out.println("`kpi.ua` was not found");
        }
    }
}
