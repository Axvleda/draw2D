import javafx.scene.input.KeyCode;
import lombok.SneakyThrows;
import lombok.var;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MousePositionRunnable implements Runnable {
    private final int minutes;
    private final Robot robot;

    @SneakyThrows
    public MousePositionRunnable(int minutes) {
        this.minutes = minutes;
        this.robot = new Robot();
    }

    @SneakyThrows
    public void run() {
        var end = getMinute() + minutes;

        while (getMinute() < end) {

            var mouseInfo = MouseInfo.getPointerInfo().getLocation();
            var capture = robot.createScreenCapture(new Rectangle(mouseInfo.x, mouseInfo.y, 1, 1));
            var rgbColor = robot.getPixelColor(mouseInfo.x, mouseInfo.y);
            String mousePosition = String.format("X: %d | Y: %d", mouseInfo.x, mouseInfo.y);
            String rgb = String.format("R: %d | G: %d | B: %d", rgbColor.getRed(), rgbColor.getGreen(), rgbColor.getBlue());
            System.out.printf("%s at %s.%n", rgb, mousePosition);

//            Thread.sleep(500);
        }
    }
    @SneakyThrows
    private void controlPress(Robot robot) {
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(200);
    }

    private int getMinute() {
        return LocalTime.MIN.getMinute();
    }
}
