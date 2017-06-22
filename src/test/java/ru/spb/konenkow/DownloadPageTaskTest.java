package ru.spb.konenkow;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;

import java.util.concurrent.ExecutorService;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;

/**
 * Created by konenkow on 18.06.2017.
 */
public class DownloadPageTaskTest {
    @Test
    public void downloadUrl() throws Exception {
        ExecutorService executorServiceMock = mock(ExecutorService.class);
        String url_string = "http://glav.su";
        DownloadPageTask downloadUrlTask = new DownloadPageTask(executorServiceMock, url_string);
        HtmlPage htmlPage = downloadUrlTask.downloadUrl(url_string);
        assertNotNull("Can not download the page", htmlPage);
    }


}