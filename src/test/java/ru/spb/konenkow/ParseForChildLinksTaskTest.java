package ru.spb.konenkow;

import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItem;
import static org.junit.Assert.assertThat;
import static ru.spb.konenkow.ConfigConstants.CHILD_REG_EXP;

/**
 * Created by konen on 03.07.2017.
 */
public class ParseForChildLinksTaskTest {

    @Test
    public void checkParseRegExp() throws Exception {
        String file = "src\\test\\resources\\1.html";
        HtmlPage htmlPage = DownloadPageTask.downloadUrl("file://" + new File(file).getAbsolutePath());
        App.getProperties().put(CHILD_REG_EXP, ".*w3schools.*");
        List<String> result = ParseForChildLinksTask.parsePageForChildren(htmlPage);
        assertThat("Does not parse for regExp", result, hasItem("https://www.w3schools.com"));

    }
}