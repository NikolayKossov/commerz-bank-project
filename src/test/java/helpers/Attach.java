package helpers;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.sessionId;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class Attach {

    @Attachment(value = "{attachName}", type = "image/png")
    public static byte[] screenshotAs(String attachName) {
        return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Page source", type = "text/html", fileExtension = ".html")
    public static byte[] pageSource() {
        return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
    }

    @Attachment(value = "{attachName}", type = "text/plain")
    public static String attachAsText(String attachName, String message) {
        return message;
    }

    public static void browserConsoleLogs() {
        attachAsText("Browser console logs", String.join("\n", Selenide.getWebDriverLogs(BROWSER)));
    }

    public static void attachSelenoidVideo() {
        String sid = String.valueOf(sessionId());
        String base = System.getProperty("selenoid.video.baseUrl",
                System.getenv().getOrDefault("SELENOID_VIDEO_BASE_URL", "http://localhost:4444/video"));
        String url = base.replaceAll("/$", "") + "/" + sid + ".mp4";

        try { getWebDriver().quit(); } catch (Throwable ignored) {}

        byte[] mp4 = waitAndDownloadByReading(url, Duration.ofSeconds(120), Duration.ofMillis(800));
        if (mp4 != null && mp4.length > 0) {
            Allure.addAttachment("Test Video", "video/mp4", new ByteArrayInputStream(mp4), "mp4");
        } else {
            Allure.addAttachment("Test Video (unavailable yet)", "text/plain",
                    new ByteArrayInputStream("Video file not ready".getBytes(StandardCharsets.UTF_8)), "txt");
        }
    }

    private static byte[] waitAndDownloadByReading(String url, Duration totalTimeout, Duration step) {
        long deadline = System.nanoTime() + totalTimeout.toNanos();
        while (System.nanoTime() < deadline) {
            try {
                HttpURLConnection get = (HttpURLConnection) new URL(url).openConnection();
                get.setRequestMethod("GET");
                get.setConnectTimeout((int) step.toMillis());
                get.setReadTimeout((int) step.toMillis() * 10);
                get.setInstanceFollowRedirects(true);
                try (var is = get.getInputStream();
                     var bos = new ByteArrayOutputStream()) {
                    byte[] buf = new byte[8192];
                    int total = 0, r;
                    while ((r = is.read(buf)) != -1) {
                        bos.write(buf, 0, r);
                        total += r;
                    }
                    if (total > 0) return bos.toByteArray();
                } finally {
                    get.disconnect();
                }
            } catch (Exception ignored) {
            }
            try { Thread.sleep(step.toMillis()); } catch (InterruptedException ie) { Thread.currentThread().interrupt(); break; }
        }
        return null;
    }
}
