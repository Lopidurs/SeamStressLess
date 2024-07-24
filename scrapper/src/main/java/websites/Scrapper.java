package websites;

import models.DataToScrap;
import models.ScrappedData;
import org.htmlunit.WebClient;
import org.htmlunit.html.HtmlElement;
import org.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Scrapper {
    private final DataToScrap dataToScrap;
    protected HtmlPage page;
    public Scrapper(DataToScrap dataToScrap) {
        this.dataToScrap = dataToScrap;
        try (final WebClient webClient = new WebClient()) {
            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setJavaScriptEnabled(false);
            page = webClient.getPage(dataToScrap.url());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final ScrappedData scrap(){
        HtmlElement element = page.getFirstByXPath(dataToScrap.xPathPrice());
        return new ScrappedData(dataToScrap.website(), dataToScrap.product(), parsePrice(element.asNormalizedText()), dataToScrap.url(), LocalDateTime.now());
    };

    private static double parsePrice(String priceStr) {
        Pattern pattern = Pattern.compile("(\\d+([,.]\\d{1,2})?)");
        Matcher matcher = pattern.matcher(priceStr);

        if (matcher.find()) {
            String numberStr = matcher.group(1);
            numberStr = numberStr.replace(',', '.');

            return Double.parseDouble(numberStr);
        }

        throw new IllegalArgumentException("No valid price found in string: " + priceStr);
    }

}
