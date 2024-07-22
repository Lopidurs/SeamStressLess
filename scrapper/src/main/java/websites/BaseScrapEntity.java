package websites;

import org.htmlunit.WebClient;
import org.htmlunit.html.HtmlElement;
import org.htmlunit.html.HtmlPage;

import java.io.IOException;

public abstract class BaseScrapEntity {
    protected HtmlPage page;
    public BaseScrapEntity(String URL) {
        try (final WebClient webClient = new WebClient()) {
            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setJavaScriptEnabled(false);
            page = webClient.getPage(URL);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract void scrap();

}
