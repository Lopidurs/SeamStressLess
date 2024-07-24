import models.DataToScrap;
import websites.Scrapper;

public class Main {
    public static void main(String[] args) {
        DataToScrap[] dataToScraps = {
                new DataToScrap("Stragier", "Calicot Uni Blanc","https://www.stragier.com/fr/article/298069/calicot-coton-souple-uni-blanc", "/html/body/form/div[4]/div[1]/div[6]/div/div[3]/div[2]/span[2]"),
                new DataToScrap("Verotex", "Calicot Uni Blanc","https://verotex.be/en/products/tissu-calicot", "/html/body/main/section[1]/div/product-rerender/div/safe-sticky/div[3]/div/div/price-list/sale-price")
        };
        for (DataToScrap dataToScrap : dataToScraps) {
            System.out.println(dataToScrap);
            System.out.println(new Scrapper(dataToScrap).scrap());
        }
    }
}
