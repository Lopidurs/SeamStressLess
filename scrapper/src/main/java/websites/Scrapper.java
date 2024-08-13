package websites;

import com.seamstressless.storage.utils.dto.Supply.SupplyRes;
import models.ScrappedData;
import org.htmlunit.WebClient;
import org.htmlunit.html.HtmlElement;
import org.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Scrapper {
    private final SupplyRes product;
    protected HtmlPage page;
    public Scrapper(SupplyRes product) {
        this.product = product;
        System.out.println(product.URL());
        try (final WebClient webClient = new WebClient()) {
            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setJavaScriptEnabled(false);
            page = webClient.getPage(product.URL());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final ScrappedData scrap(){
        HtmlElement element = page.getFirstByXPath(product.xPathPrice());
        return new ScrappedData(product.id(), parsePrice(element.asNormalizedText()), LocalDateTime.now());
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
