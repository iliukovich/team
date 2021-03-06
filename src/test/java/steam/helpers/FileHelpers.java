package steam.helpers;

import aquality.selenium.browser.BrowserManager;
import aquality.selenium.waitings.ConditionalWait;

import java.io.File;
import java.nio.file.Paths;

public class FileHelpers {
    private static final String DOWNLOAD_DIR_DEFAULT = BrowserManager.getBrowser().getDownloadDirectory();
    private static final String DOWNLOAD_DIR = System.getProperty("downloadsDir", DOWNLOAD_DIR_DEFAULT);

    public static boolean waitForFileIsDownloaded(String fileName) {
        File file = new File(Paths.get(DOWNLOAD_DIR, fileName).toString());
        return ConditionalWait.waitForTrue(file::exists, "File isn't downloaded during timeout");
    }

    public static long getDownloadedFileSize(String fileName) {
        File file = new File(Paths.get(DOWNLOAD_DIR, fileName).toString());
        return file.getTotalSpace();
    }
}
