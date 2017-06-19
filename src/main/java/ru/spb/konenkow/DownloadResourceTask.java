package ru.spb.konenkow;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URL;

import static ru.spb.konenkow.ConfigConstants.PATH_TO_SAVE;

/**
 * Download resource and save it to file
 * Created by konenkow on 19.06.2017.
 */
public class DownloadResourceTask implements Runnable {
    private final Logger log = LoggerFactory.getLogger(DownloadResourceTask.class);

    private String url_string;
    private String path;

    public DownloadResourceTask(String url_string) {
        path = App.getProperties().getProperty(PATH_TO_SAVE);
        this.url_string = url_string;
    }

    @Override
    public void run() {
        try {
            URL url = new URL(url_string);
            File file = new File(path + url.getFile());
            FileUtils.copyURLToFile(url, file);
        } catch (Exception e) {
            log.error("Error downloading resource", e);
        }
    }
}
