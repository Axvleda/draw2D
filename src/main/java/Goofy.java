import Chessboard.Chessboard;
import Chessboard.Figures.Pawn;
import javafx.scene.input.KeyCode;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import lombok.var;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Goofy {
    @Getter
    private Logger logger;

    @DataProvider(name = "data")
    public Object[][] data() {
        String[] lines = {
                "I Love Chase!",
                "Chase loves me.",
                "If the sun doesnt rise",
                "she'll stay, forever with me.",
                "This is the song",
                "This is the melody.",
                "Listen here",
                "Listen there",
        };
        Object[][] content = new Object[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            content[i] = new Object[]{lines[i]};
        }
        return content;
    }

    @Getter
    @Setter
    private String s = "something";

    @Test(dataProvider = "data", threadPoolSize = 5, invocationCount = 3)
    public void test(String zeile) {
        System.out.println(zeile + " <- ThreadID: " + Thread.currentThread().getId());
        setS(zeile);

    }

    @BeforeMethod
    public void setUp() {

        Logger.getGlobal().log(Level.INFO, "Setup started?");
    }

    @SneakyThrows
    @Test
    public void test_goofyThread() {
        Thread thread = new Thread(new MousePositionRunnable(5));
        Logger.getGlobal().log(Level.INFO, "Started");
        System.out.println(Toolkit.getDefaultToolkit().getScreenSize());
        thread.start();

        thread.join();
    }
}
