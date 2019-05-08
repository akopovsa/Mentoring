package google_calc;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import com.codeborne.selenide.junit.ScreenShooter;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoogleCalcPage {

    @Test
    public void userCanSearch() {
        open("https://google.com/");
        $(By.name("q")).setValue("google calculator").pressEnter();
        $(By.xpath("//*[@id=\"cwmcwd\"]/div/div/div[3]/div[1]/table[2]/tbody/tr[4]/td[1]/div/div")).click();
        $(By.xpath("//*[@id=\"cwmcwd\"]/div/div/div[3]/div[1]/table[2]/tbody/tr[5]/td[4]/div/div")).click();
        $(By.xpath("//*[@id=\"cwmcwd\"]/div/div/div[3]/div[1]/table[2]/tbody/tr[4]/td[1]/div/div")).click();
        $(By.xpath("//*[@id=\"cwmcwd\"]/div/div/div[3]/div[1]/table[2]/tbody/tr[5]/td[3]/div/div")).click();
        assertEquals("2",$(By.xpath("//*[@id=\"cwos\"]")).getText().trim());
    }

}
