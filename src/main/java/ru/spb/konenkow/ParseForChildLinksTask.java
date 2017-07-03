package ru.spb.konenkow;

import com.gargoylesoftware.htmlunit.html.HtmlAnchor;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.regex.Pattern;

import static ru.spb.konenkow.ConfigConstants.CHILD_REG_EXP;

/**
 * Created by konenkow on 22.06.2017.
 */
public class ParseForChildLinksTask implements Runnable {
    private ExecutorService executorService;
    private HtmlPage htmlPage;

    public ParseForChildLinksTask(ExecutorService executorService, HtmlPage htmlPage) {
        this.executorService = executorService;
        this.htmlPage = htmlPage;
    }

    public static List<String> parsePageForChildren(HtmlPage htmlPage) {
        List<HtmlAnchor> htmlPageAnchors = htmlPage.getAnchors();
        ArrayList<String> urls = new ArrayList<>();
        String childRegExp = App.getProperties().getProperty(CHILD_REG_EXP);

        String[] regExpStrings = childRegExp.split(";");
        for (String regExpString : regExpStrings) {
            for (HtmlAnchor htmlAnchor : htmlPageAnchors) {
                String link = htmlAnchor.getHrefAttribute();
                if (Pattern.matches(regExpString, link)) {
                    urls.add(link);
                }
            }
        }
        return urls;
    }

    @Override
    public void run() {
        List<String> children = parsePageForChildren(htmlPage);
        children.forEach(url_string -> executorService.submit(new DownloadPageTask(executorService, url_string)));
    }
}
