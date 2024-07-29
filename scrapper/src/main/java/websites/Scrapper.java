package websites;

import models.ProductResponse;
import models.ScrappedData;
import org.htmlunit.WebClient;
import org.htmlunit.html.HtmlElement;
import org.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Scrapper {
    private final ProductResponse product;
    protected HtmlPage page;
    public Scrapper(ProductResponse product) {
        this.product = product;
        System.out.println(product.getUrl());
        try (final WebClient webClient = new WebClient()) {
            webClient.getOptions().setCssEnabled(false);
            webClient.getOptions().setJavaScriptEnabled(false);
            page = webClient.getPage(product.getUrl());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final ScrappedData scrap(){
        HtmlElement element = page.getFirstByXPath(product.getXpathPrice());
        return new ScrappedData(product.getCategory().getName(), parsePrice(element.asNormalizedText()), product.getUrl(), LocalDateTime.now());
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
