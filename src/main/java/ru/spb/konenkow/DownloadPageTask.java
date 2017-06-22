package ru.spb.konenkow;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.util.concurrent.ExecutorService;

/**
 * Created by konenkow on 18.06.2017.
 */
public class DownloadPageTask implements Runnable {

    private String url_string;
    private ExecutorService executorService;


    public DownloadPageTask(ExecutorService executorService, String url_string) {
        this.url_string = url_string;
        this.executorService = executorService;
    }

    @Override
    public void run() {

        try {

            HtmlPage page = downloadUrl(url_string);
         //   executorService.submit(new ParseForChildLinksTask(executorService, page));
          //  executorService.submit(new ParseTableContentTask(page));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static HtmlPage downloadUrl(String url_string) throws IOException {
        try (final WebClient webClient = new WebClient(BrowserVersion.BEST_SUPPORTED)) {
            webClient.getOptions().setThrowExceptionOnScriptError(false);
            return webClient.getPage(url_string);
        }
    }
}
