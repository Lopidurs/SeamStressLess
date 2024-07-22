package websites;

import org.htmlunit.WebClient;
import org.htmlunit.html.DomElement;
import org.htmlunit.html.HtmlElement;
import org.htmlunit.html.HtmlPage;

import java.io.IOException;

public class Stragier extends BaseScrapEntity{
    private static final String URL = "https://www.stragier.com/fr/home";
    private final HtmlPage page;
    public Stragier() {
        super(URL);
        this.page = super.page;
    }

    public void scrap() {
        DomElement title = page.getElementsByTagName("h2").getFirst();
        System.out.println(title.asNormalizedText());
    }
}
