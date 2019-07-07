import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HomeWorkChromeTest {
    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testTask1() {
        String url = "https://en.wikipedia.org/wiki/Main_Page";
        driver.get(url);
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement link : links) {
            System.out.println(link.getText());
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
                href = links.stream().map(e -> e.getAttribute("href")).filter(e -> e != null).filter(e -> e.contains("seleniumhq.org")).collect(Collectors.toList());
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

    @Test
    public void testTask3() {
        boolean sorted = false;
        String url = "https://demoqa.com/sortable/";
        driver.get(url);
        WebElement ul = driver.findElement(By.id("sortable"));
        List<WebElement> list = ul.findElements(By.tagName("li"));
        for (int i = 0; i < list.size() - 1; i++) {
            sorted = list.get(i).getText().charAt(5) < list.get(i + 1).getText().charAt(5);
        }
        assertTrue("all the items now are  sorted correctly", sorted);

        WebElement from = list.get(1);
        WebElement to = list.get(5);
        Actions act = new Actions(driver);
        act.dragAndDrop(from, to).build().perform();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testTask4() {
        String url = "https://demoqa.com/selectable/";
        driver.get(url);
        WebElement ol = driver.findElement(By.id("selectable"));
        List<WebElement> list = ol.findElements(By.tagName("li"));

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL)
                .click(list.get(1))
                .click(list.get(3))
                .click(list.get(5))
                .keyUp(Keys.CONTROL)
                .build()
                .perform();

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("3_elements_selected_" + System.currentTimeMillis() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static int getRandomInt() {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(6) + 1;
    }

    @Test
    public void testTask5() {
        String url = "https://demoqa.com/resizable/";
        driver.get(url);
        WebElement rectangle = driver.findElement(By.xpath("//*[@id='resizable']"));
        WebElement arrow = driver.findElement(By.xpath("//*[@id='resizable']/div[3]"));
        System.out.printf("Original Rectangle size is: %s%n", rectangle.getSize());
        Actions actions = new Actions(driver);
        actions.clickAndHold(arrow)
                .moveByOffset(50, 50)
                .release()
                .build()
                .perform();
        System.out.printf("New Rectangle size is: %s%n", rectangle.getSize());
        actions.clickAndHold(arrow)
                .moveByOffset(-25, -25)
                .release()
                .build()
                .perform();
        System.out.printf("New Rectangle size is: %s%n", rectangle.getSize());

    }

    @Test
    public void testTask6() {
        String url = "https://demoqa.com/tooltip-and-double-click/";
        driver.get(url);
        WebElement doubleClickBtn = driver.findElement(By.xpath("//*[@id='doubleClickBtn']"));
        WebElement rightClickBtn = driver.findElement(By.xpath("//*[@id='rightClickBtn']"));
        WebElement tooltipDemo = driver.findElement(By.xpath("//*[@id='tooltipDemo']"));


        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickBtn)
                .build()
                .perform();
        Alert alert1 = driver.switchTo().alert();
        String alertMessage1 = alert1.getText();
        alert1.accept();
        assertTrue(alertMessage1.contains("Double Click Alert"));

        actions.contextClick(rightClickBtn).perform();
        WebElement rightclickItem = driver.findElement(By.xpath("//*[@id='rightclickItem']"));
        List<WebElement> items = rightclickItem.findElements(By.tagName("div")); //
        items.get(0).click();
        Alert alert2 = driver.switchTo().alert();
        String alertMessage2 = alert2.getText();
        alert1.accept();
        assertTrue(alertMessage2.contains("You have selected Edit"));

        actions.moveToElement(tooltipDemo).perform();
        WebElement tooltip = driver.findElement(By.xpath("//*[@id='tooltipDemo']/span"));
        String tooltipMessage = tooltip.getText();
        assertTrue(tooltipMessage.contains("We ask for your age"));
    }

    @Test
    public void testTask7() {
        String url = "https://demoqa.com/tooltip/";
        driver.get(url);
        Actions actions = new Actions(driver);
        WebElement tooltip = driver.findElement(By.xpath("//*[@id='age']"));
        String tooltipMessage = tooltip.getAttribute("title");
        assertTrue(tooltipMessage.contains("statistical purposes"));

    }

    @Test
    public void testTask8() {
        String url = "https://demoqa.com/slider/";
        driver.get(url);
        WebElement carriage = driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));
        WebElement slider = driver.findElement(By.xpath("//*[@id=\"slider\"]"));

        System.out.printf("Current position: %s%n", carriage.getAttribute("style").substring(4));
        int step_to_move = slider.getSize().width / 2;
        Actions actions = new Actions(driver);
        actions.clickAndHold(carriage)
                .moveByOffset(step_to_move, 0)
                .release()
                .build()
                .perform();
        System.out.printf("Current position: %s%n", carriage.getAttribute("style").substring(4));

        actions.clickAndHold(carriage)
                .moveByOffset(-20, 0)
                .release()
                .build()
                .perform();
        System.out.printf("Current position: %s%n", carriage.getAttribute("style").substring(4));
    }

    @Test
    public void testTask9() {
        String url = "https://demoqa.com/datepicker/";
        driver.get(url);
        WebElement dateInput = driver.findElement(By.xpath("//*[@id='datepicker']"));
        dateInput.click();

        WebElement nextMonthBtn = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[2]"));
        WebElement month = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/span[1]"));
        WebElement year = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/span[2]"));

        while (!month.getText().equals("August") && year.getText().equals("2019")) {

            nextMonthBtn.click();
            month = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/span[1]"));
            year = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/div/span[2]"));
        }
        WebElement datePicker = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table"));
        List<WebElement> columns = datePicker.findElements(By.tagName("td"));

        for (WebElement cell : columns) {
            if (cell.getText().equals("11")) {
                cell.findElement(By.linkText("11")).click();
                break;
            }
        }
        assertEquals("08/11/2019", dateInput.getAttribute("value"));
    }

    @Test
    public void testTask10() {
        String url = "https://demoqa.com/checkboxradio/";
        driver.get(url);
        WebElement radioGroup = driver.findElement(By.xpath("//*[@id='content']/div[2]/div/fieldset[1]"));
        WebElement checkboxGroup = driver.findElement(By.xpath("//*[@id='content']/div[2]/div/fieldset[2]"));

        List<WebElement> radioBtns = radioGroup.findElements(By.tagName("label"));
        radioBtns.get(0).click();
        radioBtns.get(1).click();
        if (radioBtns.get(1).getAttribute("class").contains("ui-checkboxradio-checked") && !radioBtns.get(0).getAttribute("class").contains("ui-checkboxradio-checked")) {
            System.out.println("It’s possible to select only one location");
        }

        List<WebElement> checkboxes = checkboxGroup.findElements(By.tagName("label"));
        checkboxes.get(0).click();
        checkboxes.get(1).click();
        if (checkboxes.get(1).getAttribute("class").contains("ui-checkboxradio-checked") && checkboxes.get(0).getAttribute("class").contains("ui-checkboxradio-checked")) {
            System.out.println("It’s possible to select several Hotel ratings ");
        }

    }


}
