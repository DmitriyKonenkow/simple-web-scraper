package ru.spb.konenkow;

import org.junit.Before;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;
import static ru.spb.konenkow.ConfigConstants.PATH_TO_SAVE;

/**
 * Created by konenkow on 19.06.2017.
 */
public class DownloadResourceTaskTest {

    @Before
    public void setUp() throws Exception {
        App.getProperties().setProperty(PATH_TO_SAVE, "target/test_data");
    }

    @Test
    public void downloadResourceTest() throws Exception {
        DownloadResourceTask downloadResourceTask = new DownloadResourceTask("https://mc.yandex.ru/metrika/advert.gif");
        downloadResourceTask.run();
        Path path = Paths.get("target/test_data/metrika/advert.gif");
        assertTrue("File not downloaded", Files.exists(path));
        Files.delete(path);
    }
}